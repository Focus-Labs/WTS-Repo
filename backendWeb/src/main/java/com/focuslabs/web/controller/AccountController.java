package com.focuslabs.web.controller;

import com.focuslabs.wts.service.IAccountService;
import com.focuslabs.wts.vo.AccountVO;
import com.focuslabs.wts.vo.CountryVO;
import com.focuslabs.wts.vo.LocalAccountVo;
import com.focuslabs.wts.vo.TravelerAccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by baba on 4/3/2016.
 */
@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    IAccountService accountService;

    @RequestMapping("/createTravelerAccount")
    @ResponseBody
    public ResponseEntity<?> createAccount(@RequestParam(value = "username",defaultValue = "")String username,
                                           @RequestParam(value = "password",defaultValue = "")String password,
                                           @RequestParam(value = "email",defaultValue = "")String email,
                                           @RequestParam(value = "dateOfBirth",defaultValue = "")Date dateOfBirth,
                                           @RequestParam(value = "cityId",defaultValue = "") Long cityId,
                                           @RequestParam(value = "profilePic",defaultValue = "")String pic) {
        try {
            accountService.createTravelerAccount(new TravelerAccountVo(dateOfBirth,new CountryVO.CityVO(cityId,null,null),pic,new AccountVO(username,password,email,1)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/createLocalAccount")
    @ResponseBody
    public ResponseEntity<?> createAccount(@RequestParam(value = "username",defaultValue = "")String username,
                                           @RequestParam(value = "password",defaultValue = "")String password,
                                           @RequestParam(value = "email",defaultValue = "")String email,
                                           @RequestParam(value = "companyName",defaultValue = "")String companyName,
                                           @RequestParam(value = "startedDate",defaultValue = "")Date startedDate,
                                           @RequestParam(value = "cityId",defaultValue = "") Long cityId,
                                           @RequestParam(value = "address",defaultValue = "")String address,
                                           @RequestParam(value = "phoneNo",defaultValue = "")String phoneNo,
                                           @RequestParam(value = "logoPic",defaultValue = "")String logoPic) {
        // TODO In Account Entity == add final static attributes to represent types of accounts (Traveler == 1 and Local == 0)
        try {
            accountService.createLocalAccount(new LocalAccountVo(companyName,startedDate,new CountryVO.CityVO(cityId,null,null),address,phoneNo,logoPic,new AccountVO(username,password,email,0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/authenticate")
    @ResponseBody
    public ResponseEntity<?> authenticate(@RequestParam(value = "username",defaultValue = "")String username,
                                          @RequestParam(value = "password",defaultValue = "")String password) {

        try {
            accountService.authentication(username,password);
            return new ResponseEntity<Object>("",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>("Error message",null);
        }
    }


    @RequestMapping("/numOfLocals")
    @ResponseBody
    public ResponseEntity<?> numOfLocals() {

        try {
            Integer numberOfLocals = accountService.getNumberOfLocals();
            return new ResponseEntity<Object>("",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>("Error message",null);
        }
    }

    @RequestMapping("/numOfTravelers")
    @ResponseBody
    public ResponseEntity<?> numOfTravelers() {

        try {
            Integer numberOfTravelers = accountService.getNumberOfTravelers();
            return new ResponseEntity<Object>("",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>("Error message",null);
        }
    }

}
