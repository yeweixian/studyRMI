package com.danger.rmi;

import com.danger.rmi.intf.IUserManager;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by PC-361 on 2017/3/6.
 */
public class Application {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 2000);
            IUserManager userManager = (IUserManager) registry.lookup("userManager");
            System.out.println("UserName: " + userManager.getUserName());
            System.out.println("AdminName: " + userManager.getAdminAccount().getUsername());
            System.out.println("AdminPWD: " + userManager.getAdminAccount().getPassword());
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
