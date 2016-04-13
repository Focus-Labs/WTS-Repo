package com.focuslabs.wts.service;

<<<<<<< HEAD
import com.focuslabs.wts.entity.Account;
import com.focuslabs.wts.vo.MessageVO;

import java.util.Date;
import java.util.List;

/**
 * Created by melkamu on 3/30/2016.
 */
public interface IMessageService {

    void sendMessage(Account fromAccountId, Account toAccountID, String message, Date date, boolean flag_read) throws Exception;
=======
import com.focuslabs.wts.vo.MessageVO;

import java.util.List;

/**
 * Created by mel on 4/5/2016.
 */
public interface IMessageService {

    void sendMessage(Account fromAccountID, Account toAccountId, String message, Date date, boolean flag_read) throws Exception;
>>>>>>> 6c3bb111e8da25929ae55c03f030eff73fd2b323

    List<MessageVO> getConversation(Account account1, Account account2, int start, int end) throws Exception;
}