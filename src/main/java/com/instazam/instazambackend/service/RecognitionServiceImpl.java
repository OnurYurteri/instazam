package com.instazam.instazambackend.service;

import com.instazam.instazambackend.dao.RecognitionDao;
import com.instazam.instazambackend.model.Recognition;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Onur Yurteri
 */
public class RecognitionServiceImpl implements RecognitionService {

    @Autowired
    RecognitionDao recognitionDao;

    @Override
    public void save(Recognition recognition) {
        recognitionDao.save(recognition);
    }

}
