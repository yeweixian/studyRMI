package com.danger.thrift;

import com.danger.thrift.server.AdditionService;
import com.danger.thrift.server.AdditionServiceImpl;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

/**
 * Created by danger.ye on 2017/6/5.
 */
public class Application {

    public static void runSimpleServer(AdditionService.Processor<AdditionServiceImpl> processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
            // Use this for a multithreaded server
            //TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            System.out.println("running the simple server...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        runSimpleServer(new AdditionService.Processor<>(new AdditionServiceImpl()));
    }
}
