package com.focuslabs.wts.service.impl;

import com.focuslabs.wts.entity.Event;
import com.focuslabs.wts.repository.EventRepository;
import com.focuslabs.wts.service.IEventService;
import com.focuslabs.wts.vo.EventVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Event updateEvent(EventVo e) {
        Event event = eventRepository.findOne(e.getId());
        if(event != null) {
            event.setDate(e.getDate());
            event.setLength(e.getLength());
            event.setEvent_icon_Location(e.getEventIconLocation());
            event.setEvent_pic_Location(e.getEventPictureLocation());
            event.setLong_desc(e.getLongDescription());
            event.setShort_desc(e.getShortDescription());
            event.setTitle(e.getTitle());
            event.setWhere_about(e.getWhereAbout());
            return eventRepository.save(event);
        }
        return null;
    }
}
