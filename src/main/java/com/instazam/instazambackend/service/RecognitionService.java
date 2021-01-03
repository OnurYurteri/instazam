package com.instazam.instazambackend.service;

import com.instazam.instazambackend.model.EventType;
import com.instazam.instazambackend.model.Recognition;

/**
 * @author Onur Yurteri
 */
public interface RecognitionService {

    Recognition save(Recognition recognition);

    Recognition saveAndFireEvent(Recognition recognition, EventType eventToPublish);

    Recognition find(String id);

}
