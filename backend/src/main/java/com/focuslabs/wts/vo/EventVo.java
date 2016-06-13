package com.focuslabs.wts.vo;

import java.io.Serializable;

/**
 * Created by baba on 6/13/2016.
 */
public class EventVo implements Serializable {

    private int numberOfEvents;

    public EventVo() {
    }

    public EventVo(int numberOfEvents) {
        this.numberOfEvents = numberOfEvents;
    }

    public int getNumberOfEvents() {
        return numberOfEvents;
    }

    public void setNumberOfEvents(int numberOfEvents) {
        this.numberOfEvents = numberOfEvents;
    }
}
