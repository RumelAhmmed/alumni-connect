package com.example.alumniconnect.service;

import com.example.alumniconnect.entity.Event;
import com.example.alumniconnect.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepo;

    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    public Event save(Event event) {
        return eventRepo.save(event);
    }

    public Optional<Event> findById(Long id) {
        return eventRepo.findById(id);
    }

    public void deleteById(Long id) {
        eventRepo.deleteById(id);
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        return eventRepo.findById(id).map(existingEvent -> {
            existingEvent.setTitle(updatedEvent.getTitle());
            existingEvent.setDescription(updatedEvent.getDescription());
            existingEvent.setDate(updatedEvent.getDate());
            return eventRepo.save(existingEvent);
        }).orElseThrow(() -> new RuntimeException("Event not found with id " + id));
    }
}
