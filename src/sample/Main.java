package sample;

import org.json.JSONObject;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException, SQLException, InterruptedException {

        minihttpserver server2 = new minihttpserver();
        server2.launch();
        SMSendpointHTTPServer server = new SMSendpointHTTPServer();
        server.launch();
        SendSMSServer server1 = new SendSMSServer();
        server1.launch();
        loginhttpserver server3 = new loginhttpserver();
        server3.launch();


        sqlrobot sqlrobot1 = new sqlrobot();


//        for (int i = 0; i < 5; i++) {
//
//           sqlrobot1.insertmessage
//                   ("john", "joane",
//                           "Sup" + i, "john",
//                           "john", 1, "right");
//           sqlrobot1.insertmessage
//                   ("john", "jelly",
//                           "Sup" + i, "john",
//                           "john", 1, "right");
//           sqlrobot1.insertmessage
//                   ("john", "joakim",
//                           "Sup" + i, "john",
//                           "john", 1, "right");
//
//           sqlrobot1.insertmessage
//                   ("john", "joane",
//                           "Sup" + i, "joane",
//                           "john", 1, "left");
//           sqlrobot1.insertmessage
//                   ("john", "jelly",
//                           "Sup" + i, "jelly",
//                           "john", 1, "left");
//           sqlrobot1.insertmessage
//                   ("john", "joakim",
//                           "Sup" + i, "joakim",
//                           "john", 1, "left");
//
//       }

        System.out.println(sqlrobot1.get_contact_messages("john"));

//     //    String Paloki = LocalDateTime.now().toString();
//     //   System.out.println(Paloki);

//     SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
//     SimpleDateFormat formatter2 = new SimpleDateFormat("hh:mm:ss a");

//     Date date = new Date();

//     String string1 = date.toString();
//     String string2 = formatter1.format(date);
//     String string3 = formatter2.format(date);

//     System.out.println(string1);
//     System.out.println(string2);
//     System.out.println(string3);

//
//
//
//
//        ArrayList<LocalDateTime> timelist = new ArrayList<>();
//        ArrayList<Integer> numbers = new ArrayList<>();
//        for (int i = 0; i < 50; i++) {
//            timelist.add(LocalDateTime.now());
//            System.out.println(LocalDateTime.now());
//            System.out.println(timelist.get(i).toEpochSecond(ZoneOffset.of("Z")));
//
//            Thread.sleep(1000);
//           // numbers.add(i);
//        }
//        Collections.shuffle(timelist);
//        System.out.println(timelist);
//        System.out.println(timelist.get(0).toEpochSecond(ZoneOffset.of("Z")));
//        Collections.sort(timelist);
//        System.out.println("Hopefully this works");
//        System.out.println(timelist);
        //    String actualmessage = "{\"from\":\"458967459867\",\"to\":[\"666666666\"],\"text\":\"test " +
        //           "from wetext\",\"media\":[],\"segments\":2,\"type\":\"SMS\"}\n ";
        //     sqlrobot sqlrobot1 = new sqlrobot();
        //    JSONObject object1 = new JSONObject(actualmessage);
        //   String to = sqlrobot1
        //          .pull_user_bynumber(object1.getJSONArray("to").get(0).toString());
        // String from = sqlrobot1
        //        .pull_contact_bynumber(object1.getString("from"));


        //  sqlrobot1.insertmessage(to,from,object1.getString("text"),from,object1.getJSONArray("media").toString(), object1.getInt("segments"));


        //  JSONObject obj = new JSONObject(actualmessage);
        //  System.out.println(obj.getString("from"));
        //  System.out.println(obj.getJSONArray("to"));
        //  System.out.println(obj.getJSONArray("media"));
        //  System.out.println(obj.getString("text"));
        //  System.out.println(obj.getInt("segments"));
        //   System.out.println(obj.getJSONArray("to").get(0).toString());
        //  System.out.println("Experiment with array:  "+obj.getJSONArray("to").get(0).toString());
        //  System.out.println(obj.getJSONArray("media").get(0));

        //  if (obj.getJSONArray("media").isEmpty()) {       System.out.println("array is empty"); }
        //  System.out.println(obj.getString("text"));
        //  System.out.println(obj.getInt("segments"));

        //        System.out.println(obj.getString("type"));
        //        JsonObject params = new JsonObject();
        //        params.addProperty("did", "5594090014");
        //        params.addProperty("did_to", "5594716064");
        //        params.addProperty("msg", "Hey it's Clear Converse !");
        //        Connect connect = new Connect();
        //        connect.query("smsv2", params , Connect.TypeMethodEnum.POST );


        //       jsonParser jsonParser = new jsonParser();
        //        jsonParser.printinfo();

    }
}
