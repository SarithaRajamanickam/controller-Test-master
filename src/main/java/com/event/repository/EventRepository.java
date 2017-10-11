package com.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.bean.Event;

@Repository("eventRepository")
public interface EventRepository extends JpaRepository<Event, Long> {

}
