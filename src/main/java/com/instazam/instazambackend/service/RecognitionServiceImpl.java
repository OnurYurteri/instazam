package com.instazam.instazambackend.service;

import com.instazam.instazambackend.dao.RecognitionDao;
import com.instazam.instazambackend.model.EventType;
import com.instazam.instazambackend.model.Recognition;
import com.instazam.instazambackend.model.event.RecognitionSavedCmd;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Onur Yurteri
 */
@Service
public class RecognitionServiceImpl implements RecognitionService, ApplicationEventPublisherAware {

    private RecognitionDao recognitionDao;

    private ApplicationEventPublisher applicationEventPublisher;

    public RecognitionServiceImpl(RecognitionDao recognitionDao) {
        this.recognitionDao = recognitionDao;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public Recognition save(Recognition recognition) {
        return recognitionDao.save(recognition);
    }

    @Override
    public Recognition saveAndFireEvent(Recognition recognition, EventType eventToPublish) {
        Recognition saved = save(recognition);

        RecognitionSavedCmd cmd = new RecognitionSavedCmd(this, saved.getId(), eventToPublish);
        applicationEventPublisher.publishEvent(cmd);

        return saved;
    }

    @Override
    public Recognition find(String id) {
        Optional<Recognition> byId = recognitionDao.findById(id);
        return byId.isPresent() ? byId.get() : null;
    }

}
