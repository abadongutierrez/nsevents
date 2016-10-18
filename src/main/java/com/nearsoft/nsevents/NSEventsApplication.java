package com.nearsoft.nsevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.servlet.Filter;

@SpringBootApplication
public class NSEventsApplication {

   public static void main(String[] args) {
      SpringApplication.run(NSEventsApplication.class, args);
   }
}
