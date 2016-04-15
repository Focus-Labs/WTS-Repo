package com.focuslabs.wts.service;

import com.focuslabs.wts.vo.MessageVO;

import java.util.List;

/**
 * Created by mel on 4/5/2016.
 */
public interface IMessageService {

    void sendMessage(Account fromAccountID, Account toAccountId, String message, Date date, boolean flag_read) throws Exception;

    List<MessageVO> getConversation(Account account1, Account account2, int start, int end) throws Exception;
}