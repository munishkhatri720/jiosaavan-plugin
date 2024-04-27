package com.github.appujet.jiosaavan;

import com.sedmelluq.discord.lavaplayer.container.mp3.Mp3AudioTrack;
import com.sedmelluq.discord.lavaplayer.tools.io.HttpInterface;
import com.sedmelluq.discord.lavaplayer.tools.io.PersistentHttpStream;
import com.sedmelluq.discord.lavaplayer.tools.io.SeekableInputStream;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackInfo;
import com.sedmelluq.discord.lavaplayer.track.DelegatedAudioTrack;
import com.sedmelluq.discord.lavaplayer.track.InternalAudioTrack;
import com.sedmelluq.discord.lavaplayer.track.playback.LocalAudioTrackExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

public class ExtendedAudioTrack extends DelegatedAudioTrack {
    protected static final Logger log = LoggerFactory.getLogger(ExtendedAudioTrack.class);

    private final ExtendedAudioSourceManager  manager;

    public ExtendedAudioTrack(AudioTrackInfo trackInfo, ExtendedAudioSourceManager  manager) {
        super(trackInfo);
        this.manager = manager;
    }

    protected HttpInterface getHttpInterface() {
        return this.manager.getHttpInterface();
    }

    @Override
    public void process(LocalAudioTrackExecutor executor) throws Exception {
        try (HttpInterface httpInterface = getHttpInterface()) {
            loadStream(executor, httpInterface);
        }
    }

    protected void loadStream(LocalAudioTrackExecutor localExecutor, HttpInterface httpInterface) throws Exception {
        final String trackUrl = getPlaybackUrl();
        log.debug("Starting {} track from URL: {}", manager.getSourceName(), trackUrl);
        // Setting contentLength (last param) to null makes it default to Long.MAX_VALUE
        try (PersistentHttpStream stream = new PersistentHttpStream(httpInterface, new URI(trackUrl), this.getTrackDuration())) {
            processDelegate(createAudioTrack(this.trackInfo, stream), localExecutor);
        }
    }

    protected InternalAudioTrack createAudioTrack(AudioTrackInfo trackInfo, SeekableInputStream stream) {
        return new Mp3AudioTrack(trackInfo, stream);
    }

    /**
     * A special helper to determine the length of the file in milliseconds.
     * @return The clip length in milliseconds, for some sources this needs to be set to unknown for them to properly work.
     */
    protected long getTrackDuration() {
        return this.trackInfo.length;
    }

    public String getPlaybackUrl() {
        return this.trackInfo.identifier;
    }

    @Override
    public ExtendedAudioSourceManager  getSourceManager() {
        return manager;
    }
}
