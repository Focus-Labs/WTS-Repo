package com.focuslabs.wts.service;

import java.util.Date;

/**
 * Created by baba on 4/4/2016.
 */
public interface ITravelerService {

    /**
     * set the location of the traveler to specific location, date and time
     *
     * @param travelerId the traveler account id
     * @param cityId city id
     * @param from how long the traveler will stay from this starting date
     * @param to
     * @throws Exception
     */
    void setLocation(Long travelerId,Long cityId,Date from,Date to) throws Exception;

}
