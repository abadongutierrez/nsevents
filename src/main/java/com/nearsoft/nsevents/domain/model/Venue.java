package com.nearsoft.nsevents.domain.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "venue")
public class Venue {
   @Id
   @SequenceGenerator(name="app_user_app_user_id_seq", sequenceName="app_user_app_user_id_seq")
   @GeneratedValue(generator="app_user_app_user_id_seq", strategy=GenerationType.IDENTITY)
   @Column(name = "venue_id")
   private Long id;

   @Column(name = "name")
   private String name;

   @Column(name = "address_1")
   private String addressLine1;

   @Column(name = "address_2")
   private String addressLine2;

   @Column(name = "city")
   private String city;

   @Column(name = "postal_code")
   private String postalCode;

   @Column(name = "country")
   private String country;

   public String getAddressLine1() {
      return addressLine1;
   }

   public void setAddressLine1(String addressLine1) {
      this.addressLine1 = addressLine1;
   }

   public String getAddressLine2() {
      return addressLine2;
   }

   public void setAddressLine2(String addressLine2) {
      this.addressLine2 = addressLine2;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getPostalCode() {
      return postalCode;
   }

   public void setPostalCode(String postalCode) {
      this.postalCode = postalCode;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getAddressDisplay() {
      List<String> list = Arrays.asList(getAddressLine1(), getAddressLine2(), getCity(), getPostalCode(), getCountry());
      return String.join(", ", list);
   }
}
