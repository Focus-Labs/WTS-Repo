package com.focuslabs.wts.controller;

import com.focuslabs.wts.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by baba on 6/13/2016.
 */
@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    ILocationService locationService;

    @RequestMapping(value = "/numberOfLocations", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> numberOfLocations() {
        try {
            return new ResponseEntity<Object>(locationService.getNumberOdLocations(), HttpStatus.valueOf(200));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.valueOf(500));
        }
    }

}
