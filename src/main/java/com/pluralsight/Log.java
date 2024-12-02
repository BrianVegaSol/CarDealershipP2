package com.pluralsight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    private static final Logger LOG = LoggerFactory.getLogger(Log.class);

    public void doSomething() {
        // Set the logging level to ERROR for this logger
        /*if (LOG instanceof  ch.qos.logback.classic.Logger) {
            ((ch.qos.logback.classic.Logger) logger).setLevel(ch.qos.logback.classic.Level.ERROR);
        }*/

        //org.slf4j.LoggerFactory.getLogger("com.zaxxer.hikari").setLevel(org.slf4j.Level.OFF);
        // Now only ERROR level messages and higher will be displayed
        LOG.error("This message will be displayed because it's at ERROR level");
        LOG.warn("This message will not be displayed because it's at WARN level");
    }

}
