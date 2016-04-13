package com.focuslabs.web.controller;

import com.focuslabs.wts.entity.Account;
import com.focuslabs.wts.entity.Traveler;
import com.focuslabs.wts.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by melkamu on 3/30/2016.
 */
public class EventController {

    @Autowired
    IEventService eventService;

    @RequestMapping("/inviteToEvent")
    @ResponseBody
    public int inviteToEvent(@RequestParam(value = "inviter", defaultValue = "") Account inviter,
                             @RequestParam(value = "invitee", defaultValue = "") Account invitee) {
        try {
            eventService.inviteToEvent(inviter, invitee);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    @RequestMapping("/acceptInvite")
    @ResponseBody
    public int acceptInvite(@RequestParam(value = "invitee", defaultValue = "") Account invitee,
                            @RequestParam(value = "inviter", defaultValue = "") Account inviter) {
        try {
            eventService.acceptInvite(invitee, inviter);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    @RequestMapping(value = "/uploadToEvent", method = RequestMethod.POST)
    @ResponseBody
    public String uploadToEvent(@RequestParam(value = "description", defaultValue = "") String description,
                                @RequestParam(value = "traveler", defaultValue = "") Traveler traveler,
                                @RequestParam(value = "data", defaultValue = "") MultipartFile[] data) {
        //TODO: not test
        String materialLocationUrl = null;
        String materialType = null;
        String message = null;
        try {
            if (data != null && data.length > 0) {
                for (int i = 0; i < data.length; i++) {

                    MultipartFile file = data[i];

                    //get file name
                    String fileName = file.getOriginalFilename();

                    //get material content type
                    materialType = file.getContentType();

                    //stream to write data to file in server.
                    String savedLocation = "upload-dir";
                    materialLocationUrl = "Http://www.wts.com/" + savedLocation;//TODO: Add the correct file location url


                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(savedLocation + "/" + fileName)));
                    FileCopyUtils.copy(file.getInputStream(), stream);
                    stream.close();

                    eventService.uploadToEvent(0L, description, traveler, materialLocationUrl, materialType);
                    message = "you have successfully uploaded";
                }
            }

            return message;
        } catch (Exception e) {
            message = "unable to upload file";
            return message;
        }
    }

    @RequestMapping("/postToEvent")
    @ResponseBody
    public String postToEvent(@RequestParam(value = "accountId", defaultValue = "") Account accountId,
                           @RequestParam(value = "data", defaultValue = "") MultipartFile[] data) {
        //TODO: not test
        String materialLocationUrl = null;
        String materialType = null;
        String message = null;
        try {
            if (data != null && data.length > 0) {
                for (int i = 0; i < data.length; i++) {

                    MultipartFile file = data[i];

                    //get file name
                    String fileName = file.getOriginalFilename();

                    //get material content type
                    materialType = file.getContentType();

                    //stream to write data to file in server.
                    String savedLocation = "upload-dir";
                    materialLocationUrl = "Http://www.wts.com/" + savedLocation;//TODO: Add the correct file location url


                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(savedLocation + "/" + fileName)));
                    FileCopyUtils.copy(file.getInputStream(), stream);
                    stream.close();

                    eventService.postToEvent(0L,accountId,materialLocationUrl,materialType);
                    message = "you have successfully uploaded";
                }
            }

            return message;
        } catch (Exception e) {
            message = "unable to upload file";
            return message;
        }
    }

    @RequestMapping("/vote")
    @ResponseBody
    public void vote() {

    }
}
