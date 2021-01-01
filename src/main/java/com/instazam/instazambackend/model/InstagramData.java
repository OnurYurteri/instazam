package com.instazam.instazambackend.model;

import lombok.Data;

/**
 * @author Onur Yurteri
 */
@Data
public class InstagramData {

    String displayImageUrl;
    boolean isVideo;
    boolean hasAudio;
    String videoUrl;

}
