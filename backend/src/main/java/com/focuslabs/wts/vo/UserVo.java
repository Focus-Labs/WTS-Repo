package com.focuslabs.wts.vo;

import java.io.Serializable;

/**
 * Created by baba on 6/13/2016.
 */
public class UserVo implements Serializable{

    private long numberOfUsers;

    public UserVo() {
    }

    public UserVo(long numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public long getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(long numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }
}
