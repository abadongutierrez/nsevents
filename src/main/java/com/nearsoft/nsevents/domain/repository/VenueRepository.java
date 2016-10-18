package com.nearsoft.nsevents.domain.repository;

import com.nearsoft.nsevents.domain.model.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends CrudRepository<Venue, Long> {
}
