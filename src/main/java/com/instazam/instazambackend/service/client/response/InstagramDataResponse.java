package com.instazam.instazambackend.service.client.response;

import lombok.Data;

import java.util.Map;

/**
 * @author Onur Yurteri
 */
@Data
public class InstagramDataResponse {

    Map<String, Object> graphql;

    public String getVideoUrl() {
        final Map<String, Object> shortcode_media = (Map<String, Object>) graphql.get("shortcode_media");
        if (shortcode_media == null) {
            return null;
        }
        return (String) shortcode_media.get("video_url");
    }

}
