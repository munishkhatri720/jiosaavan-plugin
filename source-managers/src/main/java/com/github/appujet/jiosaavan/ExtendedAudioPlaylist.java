package com.github.appujet.jiosaavan;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.BasicAudioPlaylist;


import javax.annotation.Nullable;
import javax.annotation.Nonnull;
import java.util.List;

public class ExtendedAudioPlaylist extends BasicAudioPlaylist {

    @Nonnull
    protected final Type type;
    @Nullable
    protected final String url;
    @Nullable
    protected final String artworkURL;
    @Nullable
    protected final String author;
    @Nullable
    protected final Integer totalTracks;

    public ExtendedAudioPlaylist(String name, List<AudioTrack> tracks, @Nonnull Type type, @Nullable String url, @Nullable String artworkURL, @Nullable String author, @Nullable Integer totalTracks) {
        super(name, tracks, null, false);
        this.type = type;
        this.url = url;
        this.artworkURL = artworkURL;
        this.author = author;
        this.totalTracks = totalTracks;
    }

    @Nonnull
    public Type getType() {
        return type;
    }

    @Nullable
    public String getUrl() {
        return this.url;
    }

    @Nullable
    public String getArtworkURL() {
        return this.artworkURL;
    }

    @Nullable
    public String getAuthor() {
        return this.author;
    }

    @Nullable
    public Integer getTotalTracks() {
        return this.totalTracks;
    }

    public enum Type {
        ALBUM("album"),
        PLAYLIST("playlist"),
        ARTIST("artist"),
        RECOMMENDATIONS("recommendations");

        public final String name;

        Type(String name) {
            this.name = name;
        }
    }
}