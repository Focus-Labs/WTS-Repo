package com.focuslabs.wts.controller;

import com.focuslabs.wts.entity.Location;
import com.focuslabs.wts.service.ILocationService;
import com.focuslabs.wts.vo.EventVo;
import com.focuslabs.wts.vo.LocationVo;
import com.focuslabs.wts.vo.UserVo;
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
@CrossOrigin
@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    ILocationService locationService;

    @RequestMapping(value = "/numberOfLocations", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "number of locations", notes = "return number of locations")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    public ResponseEntity<?> numberOfLocations() {
        try {
            return new ResponseEntity<Object>("{\"numberOfLocations\" : \"" + locationService.getNumberOdLocations() + "\"}", HttpStatus.valueOf(200));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.valueOf(500));
        }
    }

    @RequestMapping(value = "/allLocations",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "get all locations", notes = "return all locations")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Success", response = LocationVo.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    public ResponseEntity<?> getAllLocations() {
        try {
            List<LocationVo> locations = new ArrayList<>();
            locationService.getAllLocations().stream().forEach(l -> {
                locations.add(new LocationVo(l.getId(),l.getName()));
            });
            return new ResponseEntity<Object>(locations, HttpStatus.valueOf(200));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.valueOf(500));
        }
    }

    @RequestMapping(value = "/location",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "get location with specified location id", notes = "return the specified location")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Success", response = LocationVo.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @ApiImplicitParam(name = "locationId", required = true, dataType = "string", paramType = "query", value = "unique location Id")
    public ResponseEntity<?> getLocation(@RequestParam(value = "locationId", required = true) String locationId) {
        if(locationId != null && !locationId.isEmpty()) {
            try {
                Location l = locationService.getLocation(locationId);
                LocationVo location = new LocationVo(l.getId(),l.getName());
                return new ResponseEntity<Object>(location, HttpStatus.valueOf(200));
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<Object>(e.getMessage(), HttpStatus.valueOf(500));
            }
        }
        return new ResponseEntity<Object>("Parameter Error", HttpStatus.valueOf(500));
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "update location", notes = "return the modified location")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Success", response = LocationVo.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    public ResponseEntity<?> updateLocation(@RequestBody LocationVo locationVo) {
        if(locationVo != null) {
            try {
                Location l = locationService.updateLocation(locationVo);
                LocationVo location = new LocationVo(l.getId(),l.getName());
                return new ResponseEntity<Object>(location, HttpStatus.valueOf(200));
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<Object>(e.getMessage(), HttpStatus.valueOf(500));
            }
        }
        return new ResponseEntity<Object>("Parameter Error", HttpStatus.valueOf(500));
    }



}
