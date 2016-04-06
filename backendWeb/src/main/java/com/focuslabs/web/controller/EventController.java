package com.focuslabs.web.controller;

import com.focuslabs.wts.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by baba on 4/4/2016.
 */
@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    IEventService eventService;

    @RequestMapping("/allActiveEvents")
    @ResponseBody
    public ResponseEntity<?> allActiveEvents() {

        try {
            Integer activeMeetings = eventService.getNumberOfActiveMeetings();
            return new ResponseEntity<Object>("",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>("Error message",null);
        }
    }

    @RequestMapping("/allActiveEventCountries")
    @ResponseBody
    public ResponseEntity<?> allActiveEventsCountries() {

        try {
            Integer activeCountries = eventService.getNumberOfActiveCountry();
            return new ResponseEntity<Object>("",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>("Error message",null);
        }
    }

}
