package com.instazam.instazambackend.model;

import lombok.Data;

import java.util.Map;

/**
 * @author Onur Yurteri
 */
@Data
public class RecognitionResult {

    String artist;
    String title;
    String album;
    String release_date;
    String label;
    String timecode;
    String song_link;
    Map<String, Object> apple_music;
    Map<String, Object> deezer;
    Map<String, Object> napster;
    Map<String, Object> spotify;

}
