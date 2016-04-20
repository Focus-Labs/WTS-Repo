import com.focuslabs.wts.MainApp;
import com.focuslabs.wts.entity.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

/**
 * Created by Samson Tekleab on 4/19/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApp.class)
public class EventServiceTest {

    @Before
    public void setUp() throws Exception {
        Account inviter = new Account("Sam", "ABCD", "sam@sam.com", new Random(Integer.MAX_VALUE).nextInt(), true);
        Account invitee = new Account("Son", "abcd", "son@son.com", new Random(Integer.MAX_VALUE).nextInt(), true);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testInviteToEvent() throws Exception {

    }

    @Test
    public void testAcceptInvite() throws Exception {

    }

    @Test
    public void testUploadToEvent() throws Exception {

    }

    @Test
    public void testPostToEvent() throws Exception {

    }

    @Test
    public void testVote() throws Exception {

    }
}