package sample;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

public class minihttphandler implements HttpHandler {


    public minihttphandler() {}
    @Override
    public void handle(HttpExchange t) throws IOException {

        InputStream ios = t.getRequestBody();

        byte[] input = ios.readAllBytes();
        String inputString = new String(input, StandardCharsets.UTF_8);

        t.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        t.getResponseHeaders().add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
        t.getResponseHeaders().add("Access-Control-Allow-Credentials", "true");
        t.getResponseHeaders().add("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS,HEAD");
      //  t.sendResponseHeaders(200, response.getPayload2().getBytes().length);

        OutputStream os = t.getResponseBody();
       // os.write(response.getPayload2().getBytes());
        os.close();



    }




}
