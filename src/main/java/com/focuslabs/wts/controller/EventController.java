package com.focuslabs.wts.controller;

import com.focuslabs.wts.entity.Event;
import com.focuslabs.wts.service.IEventService;
import com.focuslabs.wts.vo.EventVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baba on 6/13/2016.
 */
@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    IEventService eventService;

    @RequestMapping(value = "/numberOfEvents", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "number of events", notes = "return number of events")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    public ResponseEntity<?> numberOfEvents() {
        try {
            Long numberOfEvents = eventService.getNumberOfEvents();
            return new ResponseEntity<Object>(numberOfEvents, HttpStatus.valueOf(200));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.valueOf(500));
        }
    }

    @RequestMapping(value = "/allEvents",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "get all events", notes = "return all events")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Success", response = EventVo.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    public ResponseEntity<?> getAllEvents() {
        try {
            List<EventVo> events = new ArrayList<>();
            eventService.getAllEvents().stream().forEach(e -> {
                events.add(new EventVo(e.getId(),e.getTitle(),e.getDate(),e.getLength(),e.getShort_desc(),e.getLong_desc(),e.getWhere_about(),e.getEvent_icon_Location(),e.getEvent_pic_Location()));
            });
            return new ResponseEntity<Object>(events, HttpStatus.valueOf(200));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.valueOf(500));
        }
    }

    @RequestMapping(value = "/event",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "get event with specified event id", notes = "return the specified event")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Success", response = EventVo.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @ApiImplicitParam(name = "eventId", required = true, dataType = "string", paramType = "query", value = "unique event Id")
    public ResponseEntity<?> getUser(@RequestParam(value = "eventId", required = true) String eventId) {
        if(eventId != null && !eventId.isEmpty()) {
            try {
                Event e = eventService.getEvent(eventId);
                EventVo event = new EventVo(e.getId(),e.getTitle(),e.getDate(),e.getLength(),e.getShort_desc(),e.getLong_desc(),e.getWhere_about(),e.getEvent_icon_Location(),e.getEvent_pic_Location());
                return new ResponseEntity<Object>(event, HttpStatus.valueOf(200));
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<Object>(e.getMessage(), HttpStatus.valueOf(500));
            }
        }
        return new ResponseEntity<Object>("Parameter Error", HttpStatus.valueOf(500));
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "update event", notes = "return the modified event")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Success", response = EventVo.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    public ResponseEntity<?> updateEvent(@RequestBody EventVo eventVo) {
        if(eventVo != null) {
            try {
                Event e = eventService.updateEvent(eventVo);
                EventVo event = new EventVo(e.getId(),e.getTitle(),e.getDate(),e.getLength(),e.getShort_desc(),e.getLong_desc(),e.getWhere_about(),e.getEvent_icon_Location(),e.getEvent_pic_Location());
                return new ResponseEntity<Object>(event, HttpStatus.valueOf(200));
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<Object>(e.getMessage(), HttpStatus.valueOf(500));
            }
        }
        return new ResponseEntity<Object>("Parameter Error", HttpStatus.valueOf(500));
    }

}
