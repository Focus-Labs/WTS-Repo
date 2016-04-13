package com.focuslabs.wts.service;

<<<<<<< HEAD
import com.focuslabs.wts.entity.Account;
import com.focuslabs.wts.entity.Event;
import com.focuslabs.wts.entity.Local;
import com.focuslabs.wts.entity.Traveler;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by melkamu on 3/30/2016.
 */
public interface IEventService {

    void inviteToEvent(Account inviter, Account invitee);

    void acceptInvite(Account invitee, Account inviter);

    void uploadToEvent(Long eventId, String description, Traveler traveler,String materialLocation,String materialType);

    void postToEvent(Long eventId, Account accountId,  String postMaterialLocation,String postMaterialType);

    void vote(Account voterId, Account targetedAccountId, int amount);
=======
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

>>>>>>> 6c3bb111e8da25929ae55c03f030eff73fd2b323
}
