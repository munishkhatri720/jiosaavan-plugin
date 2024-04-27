package com.github.appujet.jiosaavan.source;

import com.github.appujet.jiosaavan.ExtendedAudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;


import java.util.List;

public class JioSaavanAudioPlaylist extends ExtendedAudioPlaylist {
    public JioSaavanAudioPlaylist(String name, List<AudioTrack> tracks, Type type, String url, String artworkURL, String author, Integer totalTracks) {
        super(name, tracks, type, url, artworkURL, author, totalTracks);
    }
}
