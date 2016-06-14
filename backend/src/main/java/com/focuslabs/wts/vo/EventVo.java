package com.focuslabs.wts.vo;

import java.io.Serializable;

/**
 * Created by baba on 6/13/2016.
 */
public class EventVo implements Serializable {

    private long numberOfEvents;

    public EventVo() {
    }

    public EventVo(long numberOfEvents) {
        this.numberOfEvents = numberOfEvents;
    }

    public long getNumberOfEvents() {
        return numberOfEvents;
    }

    public void setNumberOfEvents(long numberOfEvents) {
        this.numberOfEvents = numberOfEvents;
    }
}
