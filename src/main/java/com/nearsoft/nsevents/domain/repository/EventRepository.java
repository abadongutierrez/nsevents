package com.nearsoft.nsevents.domain.repository;

import com.nearsoft.nsevents.domain.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
}
