package sample;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class SendSMSServer {
    HttpServer server = HttpServer.create(new InetSocketAddress(8002), 20000);
    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
    sendSMSHTTPhandler myHttpHandler1 = new sendSMSHTTPhandler();

    public void launch()
    {
        System.out.println("AND HER NAME IS ERIKA");

        server.createContext("/sendsms", myHttpHandler1);

        server.setExecutor(threadPoolExecutor);

        server.start();

    }

    public SendSMSServer() throws IOException {}



    public HttpServer getServer() {
        return server;
    }

    public void setServer(HttpServer server) {
        this.server = server;
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    public void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        this.threadPoolExecutor = threadPoolExecutor;
    }

    public sendSMSHTTPhandler getMyHttpHandler1() {
        return myHttpHandler1;
    }

    public void setMyHttpHandler1(sendSMSHTTPhandler myHttpHandler1) {
        this.myHttpHandler1 = myHttpHandler1;
    }



}
