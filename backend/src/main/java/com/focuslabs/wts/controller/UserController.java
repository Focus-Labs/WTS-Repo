package com.focuslabs.wts.controller;

import com.focuslabs.wts.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by baba on 4/3/2016.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;


    @RequestMapping(value = "/numberOfUsers", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> numberOfUsers() {
        try {
            return new ResponseEntity<Object>(userService.getNumberOfUsers(), HttpStatus.valueOf(200));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.valueOf(500));
        }
    }
}
