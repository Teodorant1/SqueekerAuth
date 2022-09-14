package sample;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class loginhttpserver

{
    HttpServer server = HttpServer.create(new InetSocketAddress(8004), 20000);
    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

    generalhttphandler myHttpHandler1 = new generalhttphandler();

    public void launch()
    {
        System.out.println("AND HER NAME IS ERIKA");

        server.createContext("/general", myHttpHandler1);

        server.setExecutor(threadPoolExecutor);

        server.start();

    }

    public loginhttpserver() throws IOException {
    }

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

    public generalhttphandler getMyHttpHandler1() {
        return myHttpHandler1;
    }

    public void setMyHttpHandler1(generalhttphandler myHttpHandler1) {
        this.myHttpHandler1 = myHttpHandler1;
    }



}