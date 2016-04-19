package com.focuslabs.wts.service.imp;

import org.springframework.stereotype.Service;

import com.focuslabs.wts.entity.*;
import com.focuslabs.wts.repository.EventDAO;
import com.focuslabs.wts.repository.EventMaterialDAO;
import com.focuslabs.wts.repository.NotificationDAO;
import com.focuslabs.wts.repository.PostMediaDAO;
import com.focuslabs.wts.entity.Event;
import com.focuslabs.wts.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <<<<<<< HEAD
 * Created by melkamu on 3/30/2016.
 */
@Service
@Transactional
public class EventServiceImpl implements IEventService {

    @Autowired
    NotificationDAO notificationDAO;
    @Autowired
    EventDAO eventDAO;
    @Autowired
    EventMaterialDAO eventMaterialDAO;
    @Autowired
    PostMediaDAO postMediaDAO;

    Notification notification;
    Event event;
    EventMaterial eventMaterial;
    PostMedia postMedia;
    String message = "Event Message";
    Date date = new Date();

    @Override
    public void inviteToEvent(Account inviter, Account invitee) {

        notification = new Notification(inviter, invitee, message, date, false);
        notificationDAO.save(notification);

    }

    @Override
    public void acceptInvite(Account invitee, Account inviter) {

        notification = new Notification(invitee, inviter, message, date, false);
        notificationDAO.save(notification);

        event = new Event(null, null, null, null, null, null, null, null, null, null, null, null, null);

    }

    @Override
    public void uploadToEvent(Long eventId, String description, Traveler traveler, String materialLocation, String materialType) {

        eventMaterial = new EventMaterial(materialLocation, description, materialType, traveler);
        eventMaterialDAO.save(eventMaterial);
    }

    @Override
    public void postToEvent(Long eventId, Account accountId, String postMaterialLocation, String postMaterialType) {
        postMedia = new PostMedia(postMaterialLocation, postMaterialType);
        postMediaDAO.save(postMedia);

    }

    @Override
    public void vote(Account voterId, Account targetedAccountId, int amount) {
        //TODO: vote impl

    }
}
