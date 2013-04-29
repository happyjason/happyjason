package com.ammob.communication.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ammob.communication.core.service.impl.OptionsManagerImpl;
import com.ammob.communication.core.dao.OptionsDao;
import com.ammob.communication.core.model.Options;
import com.ammob.communication.core.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class OptionsManagerImplTest extends BaseManagerMockTestCase {
    private OptionsManagerImpl manager = null;
    private OptionsDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(OptionsDao.class);
        manager = new OptionsManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetOptions() {
        log.debug("testing get...");

        final Long optionId = 7L;
        final Options options = new Options();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(optionId)));
            will(returnValue(options));
        }});

        Options result = manager.get(optionId);
        assertSame(options, result);
    }

    @Test
    public void testGetOptionss() {
        log.debug("testing getAll...");

        final List<Object> optionss = new ArrayList<Object>();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(optionss));
        }});

        List<Options> result = manager.getAll();
        assertSame(optionss, result);
    }

    @Test
    public void testSaveOptions() {
        log.debug("testing save...");

        final Options options = new Options();
        // enter all required fields
        options.setAutoload("KuToSyCuEkIbZbPrWuOd");
        options.setOptionName("JhNmRnBlIpJaJeOhMjJiOzTrUzWyVeYzIiWzDvHsJsPqUuUuLvOqGyViNmDdXyUw");
        options.setOptionValue("AhToJcTqYjKlAzOhDiBwEjVaYmTlEsPhMcUvLkHgGwSzQnDxDnWbJfMkIxZjIfDwTvDrZpJaCkQgAcXlWvJeMjLvGrQjWlTwNlTbExLwDhSrCkXqAcZmMvWzToNfPjTcBfUrWwZbSsBkSlKlYoFcJlOkKeKaGuFsGaGmGkJuTgVvOvZyLwDvKmCtFsBkOiFsAkByPiMpVeAhDnJySnTfQqItBjSvKwXlXgDtHaBjTtMgJzHkNkAwHpCwAmPdGdB");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(options)));
        }});

        manager.save(options);
    }

    @Test
    public void testRemoveOptions() {
        log.debug("testing remove...");

        final Long optionId = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(optionId)));
        }});

        manager.remove(optionId);
    }
}