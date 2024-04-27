package com.github.appujet.lavalinkplugin;


import com.github.appujet.jiosaavan.source.JioSaavnAudioSourceManager;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import dev.arbjerg.lavalink.api.AudioPlayerManagerConfiguration;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class Injector implements AudioPlayerManagerConfiguration {
    private final Config sourcesConfig;

    public Injector(Config config, Config sourcesConfig) {
        this.sourcesConfig = sourcesConfig;
    }

    @NotNull
    @Override
    public AudioPlayerManager configure(@NotNull AudioPlayerManager manager) {
        final Logger logger = LoggerFactory.getLogger(Injector.class);

        if (this.sourcesConfig.getApiURL() != null) {
            logger.info("Registering JioSaavn audio source manager");

            manager.registerSourceManager(new JioSaavnAudioSourceManager(this.sourcesConfig.getApiURL()));
        } else {
            logger.warn("JioSaavn audio source manager not registered, no API URL provided");
        }

        return manager;
    }
}
