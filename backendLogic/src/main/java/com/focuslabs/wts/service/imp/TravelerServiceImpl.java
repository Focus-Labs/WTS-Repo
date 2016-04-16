package com.focuslabs.wts.service.imp;

import com.focuslabs.wts.entity.WhereAbout;
import com.focuslabs.wts.repository.CityDAO;
import com.focuslabs.wts.repository.TravelerDAO;
import com.focuslabs.wts.repository.WhereAboutDAO;
import com.focuslabs.wts.service.ITravelerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by baba on 4/4/2016.
 */
public class TravelerServiceImpl implements ITravelerService {

    @Autowired
    WhereAboutDAO whereAboutDAO;
    @Autowired
    TravelerDAO travelerDAO;
    @Autowired
    CityDAO cityDAO;

    /**
     * set the location of the traveler to specific location, date and time
     *
     * @param travelerId the traveler account id
     * @param cityId     city id
     * @param from       how long the traveler will stay from this starting date
     * @param to
     * @throws Exception
     */
    @Override
    public void setLocation(Long travelerId, Long cityId, Date from, Date to) throws Exception {
        WhereAbout whereAbout = whereAboutDAO.save(new WhereAbout(travelerDAO.findOne(travelerId),cityDAO.findOne(cityId),from,to));
    }
}
