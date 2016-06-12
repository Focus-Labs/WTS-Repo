package com.focuslabs.wts.service.imp;

import com.focuslabs.wts.entity.Account;
import com.focuslabs.wts.entity.City;
import com.focuslabs.wts.entity.Local;
import com.focuslabs.wts.entity.Traveler;
import com.focuslabs.wts.libs.Encription;
import com.focuslabs.wts.repository.AccountDAO;
import com.focuslabs.wts.repository.CityDAO;
import com.focuslabs.wts.repository.LocalDAO;
import com.focuslabs.wts.repository.TravelerDAO;
import com.focuslabs.wts.service.IAccountService;
import com.focuslabs.wts.vo.LocalAccountVo;
import com.focuslabs.wts.vo.TravelerAccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by baba on 3/30/2016.
 */
@Service
@Transactional
public class AccountServiceImpl implements IAccountService {

    @Autowired
    AccountDAO accountDAO;
    @Autowired
    LocalDAO localDAO;
    @Autowired
    TravelerDAO travelerDAO;
    @Autowired
    CityDAO cityDAO;

    // TODO In Account Entity == add status attribute to deactivate and activate

    /**
     * create account for traveler in Account and insert specified traveler
     * information in to Traveler
     *
     * @param tav Traveler account information
     * @throws Exception
     */
    @Override
    public void createTravelerAccount(TravelerAccountVo tav) throws Exception {
        Account account = accountDAO.save(new Account(tav.getAccount().getUsername(), Encription.encrypt(tav.getAccount().getPassword()), tav.getAccount().getEmail(), Account.TRAVELER, Account.ACTIVE));
        if (account != null) {
            Traveler traveler = travelerDAO.save(new Traveler(tav.getDateOfBirth(), cityDAO.findOne(tav.getCity().getId()), tav.getProfilePicLocation(), account));
        }
        throw new Exception(" :( Problem creating Traveler account.");
    }

    /**
     * create account for local in Account and insert specified local
     * information in to Local
     *
     * @param hav Local account information
     * @throws Exception
     */
    @Override
    public void createLocalAccount(LocalAccountVo hav) throws Exception {
        Account account = accountDAO.save(new Account(hav.getAccount().getUsername(), Encription.encrypt(hav.getAccount().getPassword()), hav.getAccount().getEmail(), Account.LOCAL, Account.ACTIVE));
        if (account != null) {
            Local local = localDAO.save(new Local(hav.getCompanyName(), hav.getStartedDate(), cityDAO.findOne(hav.getCity().getId()), hav.getAddress(), hav.getPhoneNo(), hav.getLogoPicLocation(), account));
        }
        throw new Exception(" :( Problem creating Local account.");
    }

    /**
     * check if account with specified username and password exist
     *
     * @param userName username to be checked
     * @param password hashed password to be checked
     * @throws Exception
     */
    @Override
    public void authentication(String userName, String password) throws Exception {
        Account account = accountDAO.findAccount(userName, Encription.encrypt(password), Account.ACTIVE);
        // TODO create and return sessionVo
    }

    /**
     * get all number of travelers
     *
     * @return all travelers
     * @throws Exception
     */
    @Override
    public int getNumberOfTravelers() throws Exception {
        return travelerDAO.findAll().size();
    }

    /**
     * get all number of locals
     *
     * @return all locals
     * @throws Exception
     */
    @Override
    public int getNumberOfLocals() throws Exception {
        return localDAO.findAll().size();
    }
}
