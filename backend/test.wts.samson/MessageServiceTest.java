import com.focuslabs.wts.MainApp;
import com.focuslabs.wts.entity.Account;
import com.focuslabs.wts.repository.AccountDAO;
import com.focuslabs.wts.repository.MessageDAO;
import com.focuslabs.wts.service.IMessageService;
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
import java.util.Random;

/**
 * Created by Samson Tekleab on 4/19/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApp.class)
public class MessageServiceTest {

    @Autowired
    private IMessageService messageService;

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private MessageDAO messageDAO;

    private Account fromAccount;
    private Account toAccount;

    @Before
    public void setUp() throws Exception {

        messageDAO.deleteAll();
        accountDAO.deleteAll();

        fromAccount = new Account("from", "ABCD", "from@message.com", new Random(Integer.MAX_VALUE).nextInt(), true);
        toAccount = new Account("to", "ABCD", "to@message.com", new Random(Integer.MAX_VALUE).nextInt(), true);

        fromAccount = accountDAO.save(fromAccount);
        toAccount = accountDAO.save(toAccount);
    }

    @After
    public void tearDown() throws Exception {

        messageDAO.deleteAll();
        accountDAO.deleteAll();

        fromAccount = null;
        toAccount = null;
    }

    @Test
    public void testSendMessage() throws Exception {
        messageService.sendMessage(fromAccount, toAccount, "Message", Date.from(Instant.now()), true);
        Assert.assertEquals(messageDAO.findAll().isEmpty(), false);
    }

    @Test
    public void testGetConversation() throws Exception {
        // Don't Know how to test
        // TODO Check that start and end integers are valid (not zero, negative, out of bound)
    }
}