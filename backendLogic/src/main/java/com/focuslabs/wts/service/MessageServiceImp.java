package com.focuslabs.wts.service;

import com.focuslabs.wts.entity.Account;
import com.focuslabs.wts.vo.MessageVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by mel on 4/5/2016.
 */
@Service
@Transactional
public class MessageServiceImp implements IMessageService {

    @Override
    public void sendMessage(Account fromAccountID, Account toAccountId, String message, Date date, boolean flag_read) throws Exception {

    }

    @Override
    public List<MessageVO> getConversation(Account account1, Account account2, int start, int end) throws Exception {
        return null;
    }
}