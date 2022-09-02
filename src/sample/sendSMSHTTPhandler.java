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
        System.out.println(object1.getString("from"));
        System.out.println(object1.getString("to"));

        String tov1 = object1.getString("to");
        String fromv1 = object1.getString("from");
        String[] toFragments = tov1.split("quiznos");
        String[] fromFragments = fromv1.split("quiznos");
        String toFinal   =   toFragments[1];
        String fromFinal = fromFragments[1];


        System.out.println(toFragments[1]);
        System.out.println(fromFragments[1]);


    //    System.out.println(toFinal);
    //    System.out.println(fromFinal);

        String from = sqlrobot1.pull_user_bynumber(fromFinal);
        String to = sqlrobot1.pull_contact_bynumber
                (toFinal);

       // telegramsender telegramsender1 = new telegramsender();
       // telegramsender1.sendmessage(fromFinal,toFinal,object1.getString("text"));

        sqlrobot1.insertmessage(
                from,
                to,
                object1.getString("text"),
                from,
                "1",
                1);
        return "Message sent by: " + from;
    }
}
