package com.focuslabs.wts.service.impl;

import com.focuslabs.wts.entity.Event;
import com.focuslabs.wts.repository.EventRepository;
import com.focuslabs.wts.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baba on 6/13/2016.
 */
@Service
@Transactional
public class EventServiceImpl implements IEventService {

    @Autowired
    EventRepository eventRepository;

    @Override
    public long getNumberOfEvents() {
        return eventRepository.count();
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEvent(String eventId) {
        return eventRepository.findOne(eventId);
    }
}
