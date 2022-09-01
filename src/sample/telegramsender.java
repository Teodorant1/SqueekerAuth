package sample;

import com.google.gson.JsonObject;

public class telegramsender {

    public void sendmessage (String did, String didto, String message)
    {
        JsonObject params = new JsonObject();
        params.addProperty("did", did);
        params.addProperty("did_to", didto);
        params.addProperty("msg", message);
        Connect connect = new Connect();
        connect.query("smsv2", params , Connect.TypeMethodEnum.POST );
    }



}
