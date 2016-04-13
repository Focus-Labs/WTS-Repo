package com.focuslabs.wts.service.imp;

<<<<<<< HEAD
import com.focuslabs.wts.entity.*;
import com.focuslabs.wts.repository.EventDAO;
import com.focuslabs.wts.repository.EventMaterialDAO;
import com.focuslabs.wts.repository.NotificationDAO;
import com.focuslabs.wts.repository.PostMediaDAO;
=======
import com.focuslabs.wts.entity.Event;
import com.focuslabs.wts.repository.EventDAO;
>>>>>>> 6c3bb111e8da25929ae55c03f030eff73fd2b323
import com.focuslabs.wts.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
<<<<<<< HEAD
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
=======

>>>>>>> 6c3bb111e8da25929ae55c03f030eff73fd2b323
import java.util.Date;
import java.util.List;

/**
<<<<<<< HEAD
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
    public void postToEvent(Long eventId, Account accountId, String postMaterialLocation,String postMaterialType) {
        postMedia = new PostMedia(postMaterialLocation, postMaterialType);
        postMediaDAO.save(postMedia);

    }

    @Override
    public void vote(Account voterId, Account targetedAccountId, int amount) {
        //TODO: vote impl
=======
 * Created by baba on 4/4/2016.
 */
@Service
@Transactional
public class EventServiceImpl implements IEventService{

    private int numberOfActiveEvents = 0;
    private int numberOfActiveCountries = 0;
    @Autowired
    EventDAO eventDAO;

    /**
     * get all active events ( 1 hour before the event until its the event finishes)
     *
     * @return total number of active events
     * @throws Exception
     */
    @Override
    public int getNumberOfActiveMeetings() throws Exception {
        List<Event> events = eventDAO.findAll();
        events.stream().forEach(event -> {
            // TODO check if the time gets equal
            // TODO add condition to check events between the stating and ending time of the event
            if((((new Date()).getTime() - event.getDate().getTime()) <= 1)) {
                numberOfActiveEvents++;
            }
        });
        return this.numberOfActiveEvents;
    }

    /**
     * get all active event countries ( 1 hour before the event until its the event finishes)
     *
     * @return total number of active event countries
     * @throws Exception
     */
    @Override
    public int getNumberOfActiveCountry() throws Exception {
        List<Event> events = eventDAO.findAll();
        events.stream().forEach(event -> {
            // TODO check if the time gets equal
            // TODO add condition to check events between the stating and ending time of the event
            // TODO add relationship between city and country
            // TODO match the country and count the countries
            if((((new Date()).getTime() - event.getDate().getTime()) <= 1)) {

            }
        });
        return this.numberOfActiveEvents;
>>>>>>> 6c3bb111e8da25929ae55c03f030eff73fd2b323
    }
}
