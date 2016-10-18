package com.nearsoft.nsevents;

import com.nearsoft.nsevents.web.controller.EventController;
import com.nearsoft.nsevents.web.controller.VenueController;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class CommonHandlerInterceptor extends HandlerInterceptorAdapter {
   @Override
   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                          ModelAndView modelAndView) throws Exception {
      super.postHandle(request, response, handler, modelAndView);

      Map<String, Object> model = modelAndView.getModel();
      model.put("contextPath", request.getContextPath());
      model.put("venuesPath", MvcUriComponentsBuilder.fromController(VenueController.class).build().getPath());
      model.put("eventsPath", MvcUriComponentsBuilder.fromController(EventController.class).build().getPath());
   }
}
