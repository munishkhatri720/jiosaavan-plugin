package com.github.appujet.lavalinkplugin;

import com.github.appujet.jiosaavan.IWillUseIdentifierInstead;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import dev.arbjerg.lavalink.api.AudioPluginInfoModifier;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PluginInfoModifier implements AudioPluginInfoModifier {
    @Nullable
    @Override
    public JsonObject modifyAudioTrackPluginInfo(@NotNull AudioTrack track) {
        final String uri;

        if (track instanceof IWillUseIdentifierInstead) {
            uri = track.getInfo().identifier;
        } else {
            uri = track.getInfo().uri;
        }

        return new JsonObject(Map.of(
                "save_uri", JsonElementKt.JsonPrimitive(uri)
        ));
    }
}
