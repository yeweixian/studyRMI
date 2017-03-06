package com.danger.rmi.intf;

import com.danger.rmi.entity.Account;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by PC-361 on 2017/3/6.
 */
public interface IUserManager extends Remote {

    String getUserName() throws RemoteException;
    Account getAdminAccount() throws RemoteException;
}
