package com.github.appujet.jiosaavan;

import com.sedmelluq.discord.lavaplayer.tools.Units;
import com.sedmelluq.discord.lavaplayer.track.AudioReference;

public class IdentifiedAudioReference extends AudioReference {

    private final String uri;

    public IdentifiedAudioReference(String identifier, String uri, String title) {
        super(identifier, title);

        this.uri = uri;
    }

    @Override
    public Long getLength() {
        return Units.CONTENT_LENGTH_UNKNOWN;
    }

    @Override
    public String getUri() {
        return uri;
    }
}
