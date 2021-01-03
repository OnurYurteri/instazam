package com.instazam.instazambackend.dao;

import com.instazam.instazambackend.model.RecognitionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author Onur Yurteri
 */
public class RecognitionDaoImpl implements RecognitionCustomDao {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public RecognitionDaoImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void updateRecognition(String id, RecognitionStatus status) {

    }

}
