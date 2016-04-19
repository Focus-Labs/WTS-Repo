package com.focuslabs.wts.service.imp;

import com.focuslabs.wts.entity.Account;
import com.focuslabs.wts.entity.Message;
import com.focuslabs.wts.repository.MessageDAO;
import com.focuslabs.wts.service.IMessageService;
import com.focuslabs.wts.vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by melkamu on 3/30/2016.
 */
@Service
@Transactional
public class MessageServiceImpl implements IMessageService {

    @Autowired
    MessageDAO messageDAO;

    @Override
    public void sendMessage(Account fromAccountId, Account toAccountID, String message, Date date, boolean flag_read) throws Exception {
        Message msg = new Message(fromAccountId, toAccountID, message, date, flag_read);
        messageDAO.save(msg);
    }

    @Override
    public List<MessageVO> getConversation(Account account1, Account account2, int start, int end) throws Exception {
        List<Message> message = messageDAO.findAll();
        List<MessageVO> messageVOs = new ArrayList<>();
        for (int i = start; i < end; i++) {
            messageVOs.add(new MessageVO(message.get(i)));
        }
        return messageVOs;
    }
}
