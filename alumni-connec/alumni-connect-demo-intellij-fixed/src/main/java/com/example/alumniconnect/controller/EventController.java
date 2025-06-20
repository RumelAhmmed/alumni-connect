package com.example.alumniconnect.controller;

import com.example.alumniconnect.entity.Event;
import com.example.alumniconnect.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    // ✅ Show Events page
    @GetMapping("/events")
    public String listEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "events";
    }

    // ✅ Create new Event
    @PostMapping("/events")
    public String createEvent(Event event) {
        eventService.save(event);
        return "redirect:/events";
    }

    // ✅ Update Event using JavaScript (PUT API)
    @PutMapping("/api/events/{id}")
    @ResponseBody
    public ResponseEntity<String> updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
        Optional<Event> optionalEvent = eventService.findById(id);
        if (optionalEvent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Event existing = optionalEvent.get();
        existing.setTitle(updatedEvent.getTitle());
        existing.setDescription(updatedEvent.getDescription());
        existing.setDate(updatedEvent.getDate());

        eventService.save(existing);
        return ResponseEntity.ok("Event updated");
    }

    // ✅ Delete Event using JavaScript (DELETE API)
    @DeleteMapping("/api/events/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        Optional<Event> optionalEvent = eventService.findById(id);
        if (optionalEvent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        eventService.deleteById(id);
        return ResponseEntity.ok("Event deleted");
    }
}
