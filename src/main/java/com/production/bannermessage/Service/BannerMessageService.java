package com.production.bannermessage.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.production.bannermessage.Entity.Event;
import com.production.bannermessage.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BannerMessageService {
    @Autowired
    private EventRepository eventRepository;
    public Event saveEvent(Event event) {
        return eventRepository.saveAndFlush(event);
    }
    public List<Event> fetchEventList() {
            return (List<Event>) eventRepository.findAll();
        }
    public Event fetchEvent(Event event) {
        return (Event) eventRepository.findByEvent(event.getEvent());
    }
    public Event updateEvent(Event event) {
        return eventRepository.saveAndFlush(event);
    }

}
