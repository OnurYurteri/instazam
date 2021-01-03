package com.instazam.instazambackend.dao;

import com.instazam.instazambackend.model.RecognitionStatus;

/**
 * @author Onur Yurteri
 */
public interface RecognitionCustomDao {

    void updateRecognition(String id, RecognitionStatus status);

}
