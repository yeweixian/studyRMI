package com.danger.thrift;

import com.danger.thrift.server.AdditionService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by PC-361 on 2017/3/6.
 */
public class Application {

    public static void main(String[] args) {
        try {
            TTransport transport;
            transport = new TSocket("localhost", 9090);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            AdditionService.Client client = new AdditionService.Client(protocol);

            System.out.println("thrift server result: " + client.add(123, 321));

            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
