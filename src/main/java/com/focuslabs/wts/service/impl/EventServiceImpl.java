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
            event.setDate((e.getDate() != null) ? e.getDate() : event.getDate());
            event.setLength((e.getLength() != null && !e.getLength().isEmpty()) ? e.getLength() : event.getLength());
            event.setEvent_icon_Location((e.getEventIconLocation() != null && !e.getEventIconLocation().isEmpty()) ? e.getEventIconLocation() : event.getEvent_icon_Location());
            event.setEvent_pic_Location((e.getEventPictureLocation() != null && !e.getEventPictureLocation().isEmpty()) ? e.getEventPictureLocation() : event.getEvent_pic_Location());
            event.setLong_desc((e.getLongDescription() != null && !e.getLongDescription().isEmpty()) ? e.getLongDescription() : event.getLong_desc());
            event.setShort_desc((e.getShortDescription() != null && !e.getShortDescription().isEmpty()) ? e.getShortDescription() : event.getShort_desc());
            event.setTitle((e.getTitle() != null && !e.getTitle().isEmpty()) ? e.getTitle() : event.getTitle());
            event.setWhere_about((e.getWhereAbout() != null && !e.getWhereAbout().isEmpty()) ? e.getWhereAbout() : event.getWhere_about());
            return eventRepository.save(event);
        }
        return null;
    }
}
