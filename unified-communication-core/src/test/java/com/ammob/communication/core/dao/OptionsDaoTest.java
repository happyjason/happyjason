package com.ammob.communication.core.dao;

import com.ammob.communication.core.model.Options;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

public class OptionsDaoTest extends BaseDaoTestCase {
    @Autowired
    private OptionsDao optionsDao;

    @Test(expected = DataAccessException.class)
    public void testAddAndRemoveOptions() {
        Options options = new Options();

        // enter all required fields
        options.setAutoload("EeSpXjGfRgFkNlHuSyWo");
        options.setOptionName("GhDeRvTgQzYrDsZeIcDuIoDsOyJsKgUxYaEoEzOoTzZuPoOcDtYfMzIlRiIqZlDh");
        options.setOptionValue("ZdVsXpJoKaZeAfGxUwLxOzEjLiSrBrUvVbXxViSzKkHiYnKcKpYeLaGvMwPgDyPvAtOiJoYoZyIaAkThOfIwVxDjKiVuKeKvDsSkHmUwEtCqHoEeAvVsQpNyXeGrExOvIlVqXmKnRqKoIrVkUnKnVaWyGwHkJxXdEePpJrEoWlXgFwOsQnLxKjYzTwZaLgNyIpJdHrGcCwRzJhQoKxHbPoViYaYsFoElDgKuRtZgGiZlSvKpBfOwJtEmKeSyPlT");

        log.debug("adding options...");
        options = optionsDao.save(options);

        options = optionsDao.get(options.getOptionId());

        assertNotNull(options.getOptionId());

        log.debug("removing options...");

        optionsDao.remove(options.getOptionId());

        // should throw DataAccessException 
        optionsDao.get(options.getOptionId());
    }
}