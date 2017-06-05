package com.danger.thrift.server;

import org.apache.thrift.TException;

/**
 * Created by danger.ye on 2017/6/5.
 */
public class AdditionServiceImpl implements AdditionService.Iface {

    @Override
    public int add(int n1, int n2) throws TException {
        return n1 + n2;
    }
}
