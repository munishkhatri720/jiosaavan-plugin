package com.github.appujet.lavalinkplugin;

import com.github.appujet.jiosaavan.ExtendedAudioPlaylist;
import com.github.appujet.jiosaavan.ExtendedAudioTrack;
import com.github.appujet.jiosaavan.IWillUseIdentifierInstead;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import dev.arbjerg.lavalink.api.AudioPluginInfoModifier;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;


import java.util.Map;

@Component
public class PluginInfoModifier implements AudioPluginInfoModifier {

    @Override
    public JsonObject modifyAudioPlaylistPluginInfo(@NotNull AudioPlaylist playlist) {
        if (playlist instanceof ExtendedAudioPlaylist extendedPlaylist) {
            return new JsonObject(Map.of(
                    "type", JsonElementKt.JsonPrimitive(extendedPlaylist.getType().name),
                    "url", JsonElementKt.JsonPrimitive(extendedPlaylist.getUrl()),
                    "artworkUrl", JsonElementKt.JsonPrimitive(extendedPlaylist.getArtworkURL()),
                    "author", JsonElementKt.JsonPrimitive(extendedPlaylist.getAuthor()),
                    "totalTracks", JsonElementKt.JsonPrimitive(extendedPlaylist.getTotalTracks())
            ));
        }
        return null;
    }
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
