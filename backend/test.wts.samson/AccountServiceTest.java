import com.focuslabs.wts.MainApp;
import com.focuslabs.wts.entity.City;
import com.focuslabs.wts.entity.Local;
import com.focuslabs.wts.entity.Traveler;
import com.focuslabs.wts.repository.AccountDAO;
import com.focuslabs.wts.repository.CityDAO;
import com.focuslabs.wts.repository.LocalDAO;
import com.focuslabs.wts.repository.TravelerDAO;
import com.focuslabs.wts.service.IAccountService;
import com.focuslabs.wts.vo.AccountVO;
import com.focuslabs.wts.vo.CountryVO;
import com.focuslabs.wts.vo.LocalAccountVo;
import com.focuslabs.wts.vo.TravelerAccountVo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Created by Samson Tekleab on 4/19/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApp.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private CityDAO cityDAO;

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private TravelerDAO travelerDAO;

    @Autowired
    private LocalDAO localDAO;

    City cityAddisAbaba;
    AccountVO account;
    CountryVO.CityVO cityVoAA;
    TravelerAccountVo tav;
    LocalAccountVo lav;
    ArrayList<Traveler> travelers = new ArrayList<>();
    ArrayList<Local> locals = new ArrayList<>();

    @Before
    public void setUp() throws Exception {

        travelerDAO.deleteAll();
        localDAO.deleteAll();
        accountDAO.deleteAll();
        cityDAO.deleteAll();

        for (int i = 0; i < new Random(Byte.MAX_VALUE).nextInt(); i++) {

            Traveler traveler = new Traveler();
            traveler.setId((long) i);
            travelers.add(traveler);
            travelerDAO.save(traveler);

        }

        for (int i = 0; i < new Random(Byte.MAX_VALUE).nextInt(); i++) {

            Local local = new Local();
            local.setId((long) i);
            locals.add(local);
            localDAO.save(local);

        }

        cityAddisAbaba = cityDAO.save(new City("Addis Ababa"));
        account = new AccountVO("username", "password", "a@a.com", new Random(Integer.MAX_VALUE).nextInt());
        cityVoAA = new CountryVO.CityVO(cityAddisAbaba.getId(), "Addis Ababa", new CountryVO("Ethiopia"));

        tav = new TravelerAccountVo(Date.from(Instant.EPOCH), cityVoAA, "PPL", account);
        lav = new LocalAccountVo("Company Name", Date.from(Instant.now()), cityVoAA, "Address", "Phone No", "LPL", account);

    }

    @After
    public void tearDown() throws Exception {

        travelerDAO.deleteAll();
        localDAO.deleteAll();
        accountDAO.deleteAll();
        cityDAO.deleteAll();

        cityAddisAbaba = null;
        account = null;
        cityVoAA = null;
        tav = null;
        lav = null;
        travelers.clear();
        locals.clear();
    }

    @Test
    public void testCreateTravelerAccount() throws Exception {
        accountService.createTravelerAccount(tav);
        Assert.assertEquals(accountDAO.findAll().isEmpty(), false);
        Assert.assertEquals(travelerDAO.findAll().isEmpty(), false);
    }

    @Test
    public void testCreateLocalAccount() throws Exception {
        accountService.createLocalAccount(lav);
        Assert.assertEquals(accountDAO.findAll().isEmpty(), false);
        Assert.assertEquals(localDAO.findAll().isEmpty(), false);

    }

    @Test
    public void testAuthentication() throws Exception {
        //accountService.authentication(""."");
        // I don't know what to test
    }

    @Test
    public void testGetNumberOfTravelers() throws Exception {
        Assert.assertEquals(accountService.getNumberOfTravelers(), travelers.size());
    }

    @Test
    public void testGetNumberOfLocals() throws Exception {
        Assert.assertEquals(accountService.getNumberOfLocals(), locals.size());
    }
}