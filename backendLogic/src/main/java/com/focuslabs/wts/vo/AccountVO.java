package com.focuslabs.wts.vo;

/**
 * Created by baba on 4/3/2016.
 */
public class AccountVO {

    private Long id;
    private String username;
    private String password;
    private String email;
    private Integer type;


    /**
     * constructor for the purpose of retrieving account information
     * @param id
     * @param username
     * @param password
     * @param email
     * @param type type of the account (Traveler or Local)
     */
    public AccountVO(Long id, String username, String password, String email, Integer type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.type = type;
    }

    /**
     * constructor for the purpose of inserting account data
     * @param username
     * @param password
     * @param email
     * @param type
     */
    public AccountVO(String username, String password, String email, Integer type) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
