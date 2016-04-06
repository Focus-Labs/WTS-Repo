package com.focuslabs.wts.service;

/**
 * Created by baba on 4/4/2016.
 */
public interface IEventService {

    /**
     * get all active events ( 1 hour before the event until its the event finishes)
     *
     * @return total number of active events
     * @throws Exception
     */
    int getNumberOfActiveMeetings() throws Exception;

    /**
     * get all active event countries ( 1 hour before the event until its the event finishes)
     *
     * @return total number of active event countries
     * @throws Exception
     */
    int getNumberOfActiveCountry() throws  Exception;

}
