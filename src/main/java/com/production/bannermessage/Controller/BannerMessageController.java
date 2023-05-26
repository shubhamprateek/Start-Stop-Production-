package com.production.bannermessage.Controller;

import com.production.bannermessage.Entity.Event;
import com.production.bannermessage.Service.BannerMessageService;
import com.production.bannermessage.HTTP.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.production.bannermessage.Requests.BannerMessageRequest;
@RestController
@CrossOrigin
@Slf4j
public class BannerMessageController {
    @Autowired BannerMessageService bannerMessageService;
    @ExceptionHandler(ConstraintViolationException.class)
    @GetMapping(value = "/get-banner-message")
    public ResponseEntity<HttpResponse>  getBannerMessage(@RequestBody  Event event) {
        log.info("Got request to get-banner-message for event : {} " , event.getEvent());
        final HttpResponse response = new HttpResponse();

        try {
            Event saveResponse = bannerMessageService.fetchEvent(event);
            String eventString = saveResponse.toString();
            response.setStatusCode(200);
            response.setMessage("Fetch Successful : " + eventString);
            return new ResponseEntity<HttpResponse>(response, HttpStatus.OK);
        }
        catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
            return new ResponseEntity<HttpResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping(value = "/update-event")
    public ResponseEntity<HttpResponse> updateEvent(@RequestBody Event event) {
        log.info("Got request to update-event for event: {}", event.getEvent());
        final HttpResponse response = new HttpResponse();

        try {
            Event existingEvent = bannerMessageService.fetchEvent(event);
            if (existingEvent == null) {
                response.setStatusCode(404);
                response.setMessage("Event not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            if (event.getEvent() != null) {
                existingEvent.setEvent(event.getEvent());
            }
            log.info("existingevent.isEvent_value() : {}", existingEvent.isEvent_value());
            log.info("event.isEvent_value() : {}", event.isEvent_value());
            if (event.isEvent_value() != existingEvent.isEvent_value()) {
                existingEvent.setEvent_value(event.isEvent_value());
            }

            if (event.getEndDateTime() != null) {
                existingEvent.setEndDateTime(event.getEndDateTime());
            }
            if (event.getStartDateTime() != null) {
                existingEvent.setStartDateTime(event.getStartDateTime());
            }

            Event updatedEvent = bannerMessageService.updateEvent(existingEvent);
            String eventString = updatedEvent.toString();
            response.setStatusCode(200);
            response.setMessage("Update Successful: " + eventString);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/create")
    public Event createEvent(@RequestBody Event event){
        return bannerMessageService.saveEvent(event);
    }

    @GetMapping("/read")
    public List<Event> fetchEventList(){
        return bannerMessageService.fetchEventList();
    }


}
