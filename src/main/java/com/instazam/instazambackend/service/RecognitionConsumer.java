package com.instazam.instazambackend.service;

import com.instazam.instazambackend.model.EventType;
import com.instazam.instazambackend.model.Recognition;
import com.instazam.instazambackend.model.event.RecognitionSavedCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @author Onur Yurteri
 */
@Service
public class RecognitionConsumer implements ApplicationListener<RecognitionSavedCmd> {

    @Autowired
    RecognitionService recognitionService;

    @Autowired
    InstagramService instagramService;

    @Autowired
    ConvertService convertService;

    @Autowired
    AuddService auddService;

    @Override
    public void onApplicationEvent(RecognitionSavedCmd cmd) {
        Recognition recognition = recognitionService.find(cmd.getId());

        if (recognition == null) {
            System.out.println("Recognition with given id not found!");
            return;
        }

        switch (cmd.getType()) {
            case INITIAL_SAVE:
                final String videoUrlFromLink = instagramService.getVideoUrlFromLink(recognition.getSourceUrl());
                recognition.setVideoUrl(videoUrlFromLink);
                recognitionService.saveAndFireEvent(recognition, EventType.CONVERT_TO_MP3);
                break;
            case CONVERT_TO_MP3:
                convertService.convert(recognition);
                break;
            case RECOGNIZE_FROM_AUDD:
                auddService.recognize(recognition);
                break;
        }

    }

}
