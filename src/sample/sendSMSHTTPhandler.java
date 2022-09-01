package sample;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

public class sendSMSHTTPhandler implements HttpHandler {

    sqlrobot sqlrobot1 = new sqlrobot();

    @Override
    public void handle(HttpExchange t) throws IOException {
        InputStream ios = t.getRequestBody();

        byte[] input = ios.readAllBytes();

        String inputString = new String(input, StandardCharsets.UTF_8);

        System.out.println(inputString);



        String response = null;
        try {
            response = handlerequest(inputString);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        t.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        t.getResponseHeaders().add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
        t.getResponseHeaders().add("Access-Control-Allow-Credentials", "true");
        t.getResponseHeaders().add("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS,HEAD");

        t.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    public String handlerequest(String entrystring) throws SQLException {
        JSONObject object1 = new JSONObject(entrystring);
        String from = sqlrobot1.pull_user_bynumber(Integer.parseInt
                (object1.getString("from")));
        String to = sqlrobot1.pull_contact_bynumber(
                Integer.parseInt(object1.getString("to")) );

        telegramsender telegramsender1 = new telegramsender();
        telegramsender1.sendmessage
                (
                object1.getString("from"),
                object1.getString("to"),
                object1.getString("text")
        );

        sqlrobot1.insertmessage(
                from,
                to,
                object1.getString("text"),
                from,
                "1",
                1);
        return "Message sent by"+from;
    }
}
