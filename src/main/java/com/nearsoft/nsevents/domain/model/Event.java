package com.nearsoft.nsevents.domain.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event")
public class Event {
   @Id
   @SequenceGenerator(name="event_event_id_seq", sequenceName="event_event_id_seq")
   @GeneratedValue(generator="event_event_id_seq", strategy= GenerationType.IDENTITY)
   @Column(name = "event_id")
   private Long id;

   @Column(name = "name")
   private String name;

   @Column(name = "description")
   private String description;

   @Column(name = "begin_at")
   private Date beginAt;

   @Column(name = "end_at")
   private Date endAt;

   @Column(name = "capacity")
   private Long capacity;

   @ManyToOne
   @JoinColumn(name="venue_id")
   private Venue venue;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Date getBeginAt() {
      return beginAt;
   }

   public void setBeginAt(Date beginAt) {
      this.beginAt = beginAt;
   }

   public Date getEndAt() {
      return endAt;
   }

   public void setEndAt(Date endAt) {
      this.endAt = endAt;
   }

   public Long getCapacity() {
      return capacity;
   }

   public void setCapacity(Long capacity) {
      this.capacity = capacity;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Venue getVenue() {
      return venue;
   }

   public void setVenue(Venue venue) {
      this.venue = venue;
   }
}
