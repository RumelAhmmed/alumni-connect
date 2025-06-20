package com.example.alumniconnect.repository;

import com.example.alumniconnect.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
