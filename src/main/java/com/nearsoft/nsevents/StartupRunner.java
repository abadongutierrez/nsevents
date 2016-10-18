package com.nearsoft.nsevents;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements ApplicationRunner {
   private final Logger LOGGER = LoggerFactory.getLogger(getClass());

   @Autowired
   private DataSource ds;

   @Autowired
   private JdbcTemplate jdbcTemplate;

   @Override
   public void run(ApplicationArguments args) throws Exception {
      LOGGER.debug("-----------------------------------------------------");
      LOGGER.debug("Hey!, Im here and running...");
      LOGGER.debug("DataSource: {}", ds.toString());
      LOGGER.debug("Database Version: {}", jdbcTemplate.queryForObject("select version()", String.class));
      LOGGER.debug("-----------------------------------------------------");
   }
}
