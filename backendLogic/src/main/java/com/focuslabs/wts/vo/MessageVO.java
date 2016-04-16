package com.focuslabs.wts.vo;

/**
 * Created by mel on 4/5/2016.
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
