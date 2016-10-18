package com.nearsoft.nsevents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

   @Autowired
   private CommonHandlerInterceptor commonHandlerInterceptor;

   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(commonHandlerInterceptor);
   }

   @Bean
   public Filter hiddenHttpMethodFilter() {
      HiddenHttpMethodFilter filter = new HiddenHttpMethodFilter();
      return filter;
   }
}
