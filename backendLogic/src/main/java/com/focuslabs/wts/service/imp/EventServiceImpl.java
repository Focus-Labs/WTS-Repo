package com.focuslabs.wts.service.imp;

import com.focuslabs.wts.entity.Event;
import com.focuslabs.wts.repository.EventDAO;
import com.focuslabs.wts.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
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
    }
}
