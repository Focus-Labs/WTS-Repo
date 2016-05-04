package com.focuslabs.wts.controller;

import com.focuslabs.wts.entity.Account;
import com.focuslabs.wts.service.IMessageService;
import com.focuslabs.wts.vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by melkamu on 3/30/2016.
 */
@RestController
public class MessageController {

    @Autowired
    IMessageService messageService;

    @RequestMapping("/sendMessage")
    @ResponseBody

    //TODO: synchronize unread message
    public int sendMessage(@RequestParam(value = "fromAccountId", defaultValue = "") Account fromAccountId,
                           @RequestParam(value = "toAccountId", defaultValue = "") Account toAccountId,
                           @RequestParam(value = "message", defaultValue = "") String message) {

        Date date = new Date();
        try {
            messageService.sendMessage(fromAccountId, toAccountId, message, date, false);
            return 0;
        } catch (Exception e) {
            return 1;
        }

    }

    @RequestMapping("/getConversation")
    public
    @ResponseBody
    ResponseEntity<?> getConversation(@RequestParam(value = "account1", defaultValue = "") Account account1,
                                      @RequestParam(value = "account2", defaultValue = "") Account account2,
                                      @RequestParam(value = "start", defaultValue = "") int start,
                                      @RequestParam(value = "end", defaultValue = "") int end
    ) {
        try {
            List<MessageVO> msg = messageService.getConversation(account1, account2, start, end);
            return new ResponseEntity<Object>(msg, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<Object>("", HttpStatus.BAD_REQUEST);
        }
    }
}
