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
    telegramsender telegramsender1 = new telegramsender();


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
        String username = object1.getString("user");
        String password = object1.getString("password");

        if (sqlrobot1.checkcredentials(username, password).equals("true")) {
            String tov1 = object1.getString("to");
            String fromv1 = object1.getString("from");
            System.out.println(" tov1 is: "   +tov1  );
            System.out.println(" fromv1 is: " +fromv1);

            String sendernumber = sqlrobot1.pull_number_byuser(fromv1);
            String receivernumber = sqlrobot1.pull_number_bycontact(tov1);



            telegramsender1.sendmessage(sendernumber, receivernumber, object1.getString("text"));

            sqlrobot1.insertmessage(
                    fromv1,
                    tov1,
                    object1.getString("text"),
                    fromv1,
                    "1",
                    1,
                    "right");
            return "Message sent by: " + fromv1;
        }
        return "Message not-sent";

    }
}
