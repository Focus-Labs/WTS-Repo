package com.focuslabs.wts.service.impl;

import com.focuslabs.wts.repository.EventRepository;
import com.focuslabs.wts.service.IEventService;
import com.focuslabs.wts.vo.EventVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by baba on 6/13/2016.
 */
@Service
@Transactional
public class EventServiceImpl implements IEventService {

    @Autowired
    EventRepository eventRepository;

    @Override
    public EventVo getNumberOfEvents() {
        return new EventVo(eventRepository.count());
    }
}
