package com.nearsoft.nsevents.web.controller;

import com.nearsoft.nsevents.domain.model.Venue;
import com.nearsoft.nsevents.domain.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

@Controller
@RequestMapping("/venues")
public class VenueController {
   @Autowired
   private VenueRepository repository;

   @GetMapping("")
   public String listVenues(Model model) {
      UriComponents uriComponents = MvcUriComponentsBuilder.fromController(getClass()).path("/new").build();
      model.addAttribute("newPath", uriComponents.encode().getPath());
      model.addAttribute("venues", repository.findAll());
      model.addAttribute("showPath", MvcUriComponentsBuilder.fromController(getClass()).build().getPath());
      return "venues/list";
   }

   @GetMapping("/new")
   public String newVenue(Model model) {
      UriComponents uriComponents = MvcUriComponentsBuilder.fromController(getClass()).build();
      model.addAttribute("actionPath", uriComponents.encode().getPath());
      return "venues/new";
   }

   @PostMapping("")
   public String saveVenue(Venue venue) {
      Venue saved = repository.save(venue);
      UriComponents uriComponents = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(saved.getId());
      return "redirect:" + uriComponents.getPath();
   }

   @GetMapping("/{id}")
   public String getVenue(Model model, @PathVariable Long id) {
      Venue venue = repository.findOne(id);
      model.addAttribute("venue", venue);
      model.addAttribute("backPath", MvcUriComponentsBuilder.fromController(getClass()).build().getPath());
      return "venues/show";
   }

   @DeleteMapping("/{id}")
   public String deleteVenue(Model model, @PathVariable Long id) {
      repository.delete(id);
      return "redirect:" + MvcUriComponentsBuilder.fromController(getClass()).build().getPath();
   }
}
