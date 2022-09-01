package sample;

import org.json.JSONObject;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        minihttpserver server2 = new minihttpserver();
        server2.launch();
        SMSendpointHTTPServer server = new SMSendpointHTTPServer();
        server.launch();
        SendSMSServer server1 = new SendSMSServer();
        server1.launch();




        String actualmessage = "{\"from\":\"5593029291\",\"to\":[\"5594090014\"],\"text\":\"test " +
                "from wetext\",\"media\":[],\"segments\":2,\"type\":\"SMS\"}\n ";

        JSONObject obj = new JSONObject(actualmessage);
       // System.out.println(obj.getString("from"));

       // System.out.println(obj.getJSONArray("to"));
       // System.out.println(obj.getJSONArray("media"));

        System.out.println("Experiment with array:  "+
                obj.getJSONArray("to").get(0).toString());
     //   System.out.println(obj.getJSONArray("media").get(0));

    if (obj.getJSONArray("media").isEmpty()) {
        System.out.println("array is empty");
    }
    //  System.out.println(obj.getString("text"));
    //  System.out.println(obj.getInt("segments"));

        System.out.println(obj.getString("type"));
        //        JsonObject params = new JsonObject();
        //        params.addProperty("did", "5594090014");
        //        params.addProperty("did_to", "5594716064");
        //        params.addProperty("msg", "Hey it's Clear Converse !");
        //        Connect connect = new Connect();
        //        connect.query("smsv2", params , Connect.TypeMethodEnum.POST );

   //     SMSendpointHTTPServer server = new SMSendpointHTTPServer();
  //      server.launch();
 //       jsonParser jsonParser = new jsonParser();
//        jsonParser.printinfo();

    }
}
