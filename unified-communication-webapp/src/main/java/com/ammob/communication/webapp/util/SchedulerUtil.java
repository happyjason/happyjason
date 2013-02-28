package com.ammob.communication.webapp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContext;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Map;

/**
 * Extension of {@link SchedulerFactoryBean} that collects trigger bean
 * definitions from the application context and calls
 * {@link #setTriggers(org.quartz.Trigger[])} to autowire triggers at
 * {@link #afterPropertiesSet()} time.
 **/
public final class SchedulerUtil extends SchedulerFactoryBean implements ApplicationContextAware, InitializingBean {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private ApplicationContext applicationContext;

    public void afterPropertiesSet() throws Exception {
        final Map<String,Trigger> triggers = this.applicationContext.getBeansOfType(Trigger.class);
        super.setTriggers(triggers.values().toArray(new Trigger[triggers.size()]));

        if (log.isDebugEnabled()) {
            log.debug("Autowired the following triggers defined in application context: " + triggers.keySet().toString());
        }

        super.afterPropertiesSet();
    }

    public void setApplicationContext(final ApplicationContext applicationContext) {
        super.setApplicationContext(applicationContext);
        this.applicationContext = applicationContext;
    }
}
