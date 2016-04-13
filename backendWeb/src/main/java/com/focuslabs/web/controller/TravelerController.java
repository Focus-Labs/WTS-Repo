package com.focuslabs.web.controller;

import com.focuslabs.wts.service.ITravelerService;
import com.focuslabs.wts.vo.AccountVO;
import com.focuslabs.wts.vo.CountryVO;
import com.focuslabs.wts.vo.TravelerAccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by baba on 4/4/2016.
 */
@Controller
@RequestMapping("/travelers")
public class TravelerController {

    @Autowired
    ITravelerService travelerService;

    @RequestMapping("/setLocation")
    @ResponseBody
    public ResponseEntity<?> createAccount(@RequestParam(value = "travelerId",defaultValue = "")Long travelerId,
                                           @RequestParam(value = "cityId",defaultValue = "") Long cityId,
                                           @RequestParam(value = "from",defaultValue = "")Date from,
                                           @RequestParam(value = "to",defaultValue = "")Date to) {
        try {
            travelerService.setLocation(travelerId,cityId,from,to);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
