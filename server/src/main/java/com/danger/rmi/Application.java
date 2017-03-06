package com.danger.rmi;

import com.danger.rmi.intf.IUserManager;
import com.danger.rmi.server.UserManager;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by PC-361 on 2017/3/6.
 */
public class Application {

    public static void main(String[] args) throws RemoteException {
        UserManager userManager = new UserManager();
        IUserManager iUserManager = (IUserManager) UnicastRemoteObject.exportObject(userManager, 0);
        Registry registry = LocateRegistry.createRegistry(2000);
        registry.rebind("userManager", iUserManager);
        System.out.println("server is ready");
    }
}
