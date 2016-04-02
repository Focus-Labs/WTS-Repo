package com.focuslabs.wts.vo;

import com.focuslabs.wts.entity.Event;

/**
 * Created by Samson Tekleab on 3/24/2016.
 */
public class EventVO implements SearchResultVO {

    private Event event;

    public EventVO(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
