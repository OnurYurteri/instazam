package com.instazam.instazambackend.service;

import com.instazam.instazambackend.dao.RecognitionDao;
import com.instazam.instazambackend.model.Recognition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Onur Yurteri
 */
@Service
public class RecognitionServiceImpl implements RecognitionService {

    @Autowired
    RecognitionDao recognitionDao;

    @Override
    public Recognition save(Recognition recognition) {
        return recognitionDao.save(recognition);
    }

}
