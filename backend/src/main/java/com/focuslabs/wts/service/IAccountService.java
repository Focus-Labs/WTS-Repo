package com.focuslabs.wts.service;

import com.focuslabs.wts.vo.LocalAccountVo;
import com.focuslabs.wts.vo.TravelerAccountVo;

/**
 * Created by baba on 3/30/2016.
 */
public interface IAccountService {

    /**
     * create account for traveler in Account and insert specified traveler
     * information in to Traveler
     *
     * @param travelerAccountVo Traveler account information
     * @throws Exception
     */
    void createTravelerAccount(TravelerAccountVo travelerAccountVo) throws Exception;

    /**
     * create account for local in Account and insert specified local
     * information in to Local
     *
     * @param hostAccountVo Local account information
     * @throws Exception
     */
    void createLocalAccount(LocalAccountVo hostAccountVo) throws Exception;

    /**
     * check if account with specified username and password exist
     *
     * @param userName username to be checked
     * @param password hashed password to be checked
     * @throws Exception
     */
    void authentication(String userName,String password) throws Exception;

    /**
     * get all number of travelers
     *
     * @return all travelers
     * @throws Exception
     */
    int getNumberOfTravelers() throws Exception;

    /**
     * get all number of locals
     *
     * @return all locals
     * @throws Exception
     */
    int getNumberOfLocals() throws Exception;
}
