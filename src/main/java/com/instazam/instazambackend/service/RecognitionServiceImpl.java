package com.instazam.instazambackend.service;

import com.instazam.instazambackend.dao.RecognitionDao;
import com.instazam.instazambackend.model.Recognition;
import org.springframework.stereotype.Service;

/**
 * @author Onur Yurteri
 */
@Service
public class RecognitionServiceImpl implements RecognitionService {

    RecognitionDao recognitionDao;

    public RecognitionServiceImpl(RecognitionDao recognitionDao) {
        this.recognitionDao = recognitionDao;
    }

    @Override
    public Recognition save(Recognition recognition) {
        return recognitionDao.save(recognition);
    }

}
