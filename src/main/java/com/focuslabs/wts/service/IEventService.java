package com.focuslabs.wts.service;

import com.focuslabs.wts.entity.Event;
import com.focuslabs.wts.vo.EventVo;

import java.util.List;

/**
 * Created by baba on 6/13/2016.
 */
public interface IEventService {

    long getNumberOfEvents();
    List<Event> getAllEvents();
    Event getEvent(String eventId);
    Event update(EventVo eventVo);
    Event create(EventVo e);

}
