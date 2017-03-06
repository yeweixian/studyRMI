package com.danger.rmi.server;

import com.danger.rmi.entity.Account;
import com.danger.rmi.intf.IUserManager;

import java.rmi.RemoteException;

/**
 * Created by PC-361 on 2017/3/6.
 */
public class UserManager implements IUserManager {

    @Override
    public String getUserName() throws RemoteException {
        return "Danger Ye";
    }

    @Override
    public Account getAdminAccount() throws RemoteException {
        Account account = new Account();
        account.setUsername("admin");
        account.setPassword("123456");
        return account;
    }
}
