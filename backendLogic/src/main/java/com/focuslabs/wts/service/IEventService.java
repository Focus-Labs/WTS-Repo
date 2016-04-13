package com.focuslabs.wts.service;

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
}
