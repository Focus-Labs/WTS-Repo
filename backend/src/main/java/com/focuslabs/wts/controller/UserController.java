package com.focuslabs.wts.controller;

import com.focuslabs.wts.service.IUserService;
import com.focuslabs.wts.vo.UserVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


    @RequestMapping(value = "/numberOfUsers", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "number of users", notes = "return number of users")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Success", response = UserVo.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    public ResponseEntity<?> numberOfUsers() {
        try {
            return new ResponseEntity<Object>(userService.getNumberOfUsers(), HttpStatus.valueOf(200));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.valueOf(500));
        }
    }
}
