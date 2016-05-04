package com.focuslabs.wts.service;

import com.focuslabs.wts.entity.Account;
import com.focuslabs.wts.vo.MessageVO;

import java.util.Date;
import java.util.List;

/**
 * Created by melkamu on 3/30/2016.
 */
public interface IMessageService {

    void sendMessage(Account fromAccountId, Account toAccountID, String message, Date date, boolean flag_read) throws Exception;

    List<MessageVO> getConversation(Account account1, Account account2, int start, int end) throws Exception;
}