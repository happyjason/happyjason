package com.ammob.communication.core.service.impl;

import com.ammob.communication.core.dao.OptionsDao;
import com.ammob.communication.core.service.OptionsManager;
import com.ammob.communication.core.model.Options;
import com.ammob.communication.core.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("optionsManager")
public class OptionsManagerImpl extends GenericManagerImpl<Options, Long> implements OptionsManager {
    OptionsDao optionsDao;

    @Autowired
    public OptionsManagerImpl(OptionsDao optionsDao) {
        super(optionsDao);
        this.optionsDao = optionsDao;
    }
}