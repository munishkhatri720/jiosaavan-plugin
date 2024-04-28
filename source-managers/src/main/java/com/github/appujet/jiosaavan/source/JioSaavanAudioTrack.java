package com.github.appujet.jiosaavan.source;


import com.github.appujet.jiosaavan.ExtendedAudioSourceManager;
import com.github.appujet.jiosaavan.MpegTrack;
import com.github.appujet.jiosaavan.Utils;
import com.sedmelluq.discord.lavaplayer.tools.Units;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackInfo;


public class JioSaavanAudioTrack extends MpegTrack {
    private final ExtendedAudioSourceManager manager;
    public JioSaavanAudioTrack(AudioTrackInfo trackInfo, ExtendedAudioSourceManager  manager) {
        super(trackInfo, manager);
        this.manager =  manager;
    }

    @Override
    public String getPlaybackUrl() {
        return getDownloadURL(getIdentifier());
    }

    private String getDownloadURL(String identifier) {
        var json = Utils.fetchJson(JioSaavnAudioSourceManager.BASE_API + "/songs?ids=" + identifier, this.manager);

        var downloadInfoLink = json.get("data").index(0).get("downloadUrl");
        if (downloadInfoLink.isNull()) {
            return null;
        }
        var downloadUrls = downloadInfoLink.values();
        String downloadUrl = null;
        if (downloadUrls.isEmpty()) {
            return null;
        }
        for (var url : downloadUrls) {
            if (url.get("quality").text().equals("320kbps")) {
                downloadUrl = url.get("url").text();
            }
        }
        if (downloadUrl == null) {
            for (var url : downloadUrls) {
                if (url.get("quality").text().equals("160kbps")) {
                    downloadUrl = url.get("url").text();
                }
            }
        }
        if (downloadUrl == null) {
            for (var url : downloadUrls) {
                if (url.get("quality").text().equals("96kbps")) {
                    downloadUrl = url.get("url").text();
                }
            }
        }
        if (downloadUrl == null) {
            downloadUrl = downloadUrls.get(0).get("url").text();
        }
        return downloadUrl;
    }
    @Override
    protected long getTrackDuration() {
        return Units.CONTENT_LENGTH_UNKNOWN;
    }
}
