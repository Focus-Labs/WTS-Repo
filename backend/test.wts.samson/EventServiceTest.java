import com.focuslabs.wts.MainApp;
import com.focuslabs.wts.entity.Account;
import com.focuslabs.wts.entity.Traveler;
import com.focuslabs.wts.repository.*;
import com.focuslabs.wts.service.IEventService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

/**
 * Created by Samson Tekleab on 4/19/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApp.class)
public class EventServiceTest {

    @Autowired
    private IEventService eventService;

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private NotificationDAO notificationDAO;

    @Autowired
    private EventMaterialDAO eventMaterialDAO;

    @Autowired
    private TravelerDAO travelerDAO;

    @Autowired
    private PostMediaDAO postMediaDAO;

    Account inviter;
    Account invitee;
    Account localAccount;
    Account voter;
    Account targetedAccount;

    Traveler traveler;

    @Before
    public void setUp() throws Exception {

        inviter = new Account("Sam", "ABCD", "sam@sam.com", new Random(Integer.MAX_VALUE).nextInt(), true);
        invitee = new Account("Son", "abcd", "son@son.com", new Random(Integer.MAX_VALUE).nextInt(), true);
        localAccount = new Account("localAcc", "1234", "la@la.com", new Random(Integer.MAX_VALUE).nextInt(), true);
        voter = new Account("voter", "vote", "voter@election.com", new Random(Integer.MAX_VALUE).nextInt(), true);
        targetedAccount = new Account("tAcc", "5678", "tAcc@election.com", new Random(Integer.MAX_VALUE).nextInt(), true);

        traveler = new Traveler();

        clearRepos();

        accountDAO.save(inviter);
        accountDAO.save(invitee);
        accountDAO.save(localAccount);
        accountDAO.save(voter);
        accountDAO.save(targetedAccount);

        travelerDAO.save(traveler);
    }

    @After
    public void tearDown() throws Exception {

        clearRepos();

        inviter = null;
        invitee = null;
        localAccount = null;
        voter = null;
        targetedAccount = null;

        traveler = null;
    }

    private void clearRepos() {
        notificationDAO.deleteAll();
        eventMaterialDAO.deleteAll();
        postMediaDAO.deleteAll();
        accountDAO.deleteAll();
        travelerDAO.deleteAll();
    }

    @Test
    public void testInviteToEvent() throws Exception {

        eventService.inviteToEvent(inviter, invitee);
        Assert.assertEquals(notificationDAO.findAll().isEmpty(), false);
    }

    @Test
    public void testAcceptInvite() throws Exception {

        eventService.acceptInvite(invitee, inviter);
        Assert.assertEquals(notificationDAO.findAll().isEmpty(), false);
    }

    @Test
    public void testUploadToEvent() throws Exception {

        eventService.uploadToEvent(new Random(Long.MAX_VALUE).nextLong(), "Description", traveler, "Material Location", "Excel Document");
        Assert.assertEquals(eventMaterialDAO.findAll().isEmpty(), false);
    }

    @Test
    public void testPostToEvent() throws Exception {

        eventService.postToEvent(new Random(Long.MAX_VALUE).nextLong(), localAccount, "PML", "Excel");
        Assert.assertEquals(postMediaDAO.findAll().isEmpty(), false);
    }

    @Test
    public void testVote() throws Exception {

        eventService.vote(voter, targetedAccount, new Random(Integer.MAX_VALUE).nextInt());
    }
}