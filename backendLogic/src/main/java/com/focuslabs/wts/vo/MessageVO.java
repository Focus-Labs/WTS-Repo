package com.focuslabs.wts.vo;

import com.focuslabs.wts.entity.Message;

/**
 * Created by melkamu on 3/30/2016.
 */
public class MessageVO {

    private Message message;

    public MessageVO(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
