import com.focuslabs.wts.MainApp;
import com.focuslabs.wts.entity.City;
import com.focuslabs.wts.entity.Traveler;
import com.focuslabs.wts.repository.CityDAO;
import com.focuslabs.wts.repository.TravelerDAO;
import com.focuslabs.wts.repository.WhereAboutDAO;
import com.focuslabs.wts.service.ITravelerService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Instant;
import java.util.Date;

/**
 * Created by Samson Tekleab on 4/19/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApp.class)
public class TravelerServiceTest {

    @Autowired
    private ITravelerService travelerService;

    @Autowired
    private WhereAboutDAO whereAboutDAO;

    @Autowired
    private TravelerDAO travelerDAO;

    @Autowired
    private CityDAO cityDAO;

    private Traveler traveler;
    private City city;

    @Before
    public void setUp() throws Exception {

        whereAboutDAO.deleteAll();

        traveler = new Traveler();
        city = new City();

        traveler = travelerDAO.save(traveler);
        city = cityDAO.save(city);
    }

    @After
    public void tearDown() throws Exception {

        whereAboutDAO.deleteAll();
        travelerDAO.deleteAll();
        cityDAO.deleteAll();

        traveler = null;
        city = null;

    }

    @Test
    public void testSetLocation() throws Exception {

        travelerService.setLocation(traveler.getId(), city.getId(), Date.from(Instant.now()), Date.from(Instant.now()));
        Assert.assertEquals(whereAboutDAO.findAll().isEmpty(), false);
    }
}