package com.nearsoft.nsevents.web.controller;

import com.nearsoft.nsevents.domain.model.Event;
import com.nearsoft.nsevents.domain.model.Venue;
import com.nearsoft.nsevents.domain.repository.EventRepository;
import com.nearsoft.nsevents.domain.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

   @Autowired
   private EventRepository evenRepository;

   @Autowired
   private VenueRepository venueRepository;

   @GetMapping("")
   public String listEvents(Model model) {
      UriComponents uriComponents = MvcUriComponentsBuilder.fromController(getClass()).path("/new").build();
      model.addAttribute("newPath", uriComponents.encode().getPath());
      Iterable<Event> all = evenRepository.findAll();
      model.addAttribute("events", all);
      model.addAttribute("eventRows", buildEventsRows(3, all));
      model.addAttribute("showPath", MvcUriComponentsBuilder.fromController(getClass()).build().getPath());
      return "events/list";
   }

   @GetMapping("/new")
   public String newEvent(Model model) {
      UriComponents uriComponents = MvcUriComponentsBuilder.fromController(getClass()).build();
      model.addAttribute("actionPath", uriComponents.encode().getPath());
      model.addAttribute("venues", venueRepository.findAll());
      return "events/new";
   }

   @PostMapping("")
   public String saveEvent(Event event, @RequestParam("venue") Long venueId) {
      Venue venue = venueRepository.findOne(venueId);
      event.setVenue(venue);
      Event saved = evenRepository.save(event);
      UriComponents uriComponents = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(saved.getId());
      return "redirect:" + uriComponents.getPath();
   }

   @GetMapping("/{id}")
   public String getEvent(Model model, @PathVariable Long id) {
      Event event = evenRepository.findOne(id);
      model.addAttribute("event", event);
      model.addAttribute("backPath", MvcUriComponentsBuilder.fromController(getClass()).build().getPath());
      return "events/show";
   }

   @DeleteMapping("/{id}")
   public String deleteEvent(Model model, @PathVariable Long id) {
      evenRepository.delete(id);
      return "redirect:" + MvcUriComponentsBuilder.fromController(getClass()).build().getPath();
   }

   private List<List<EventHolder>> buildEventsRows(int totalEventsInRow, Iterable<Event> events) {
      List<List<EventHolder>> lists = new ArrayList<>();
      List<EventHolder> currentRow = new ArrayList<>();
      int total = 0;
      for (Event event : events) {
         if (total == totalEventsInRow) {
            lists.add(currentRow);
            currentRow = new ArrayList<>();
            total = 0;
         }
         currentRow.add(new EventHolder(event));
         total++;
      }

      if (total < totalEventsInRow) {
         while (total != totalEventsInRow) {
            currentRow.add(new EventHolder(null));
            total++;
         }
         lists.add(currentRow);
      } else {
         lists.add(currentRow);
      }

      return lists;
   }

   public class EventHolder {
      private Event event;

      public EventHolder(Event event) {
         this.event = event;
      }

      public boolean isEvent() {
         return event != null;
      }

      public Event getValue() {
         return event;
      }
   }
}
