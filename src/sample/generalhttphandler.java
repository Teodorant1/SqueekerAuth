package sample;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

public class generalhttphandler implements HttpHandler {

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
        JSONObject object1 =    new JSONObject(entrystring);
        String username = object1.getString("username");
        String password = object1.getString("password");
        String method   = object1.getString("method"  );

        System.out.println(username);
        System.out.println(password);
        System.out.println(method);


        if (sqlrobot1.checkcredentials(username, password).equals("true")) {
            if (method.equals("login")) {
                return "sms";
            }

            // else if (method.equals("login1")) {return "dashboard";}


        } else {
            return "Can't help you pal";
        }


        return "Bye!";
    }


}
