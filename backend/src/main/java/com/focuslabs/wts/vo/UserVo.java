package com.focuslabs.wts.vo;

import java.io.Serializable;

/**
 * Created by baba on 6/13/2016.
 */
public class UserVo implements Serializable{

    private int numberOfUsers;

    public UserVo() {
    }

    public UserVo(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }
}
