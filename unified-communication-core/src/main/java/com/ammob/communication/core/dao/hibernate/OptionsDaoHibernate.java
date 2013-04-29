package com.ammob.communication.core.dao.hibernate;

import com.ammob.communication.core.dao.OptionsDao;
import com.ammob.communication.core.model.Options;

import org.springframework.stereotype.Repository;

@Repository("optionsDao")
public class OptionsDaoHibernate extends GenericDaoHibernate<Options, Long> implements OptionsDao {

    public OptionsDaoHibernate() {
        super(Options.class);
    }
}
