package sample;

import com.google.gson.JsonObject;

public class Main {

    public static void main(String[] args) {

        JsonObject params = new JsonObject();
        params.addProperty("did", "5594090014");
        params.addProperty("did_to", "5594716064");
        params.addProperty("msg", "Hey it's me ur brother");
        Connect connect = new Connect();
        connect.query("smsv2", params , Connect.TypeMethodEnum.POST );
        System.out.println( connect.query("smsv2", params , Connect.TypeMethodEnum.POST ));
    // Dids api = new Dids();
    //  api.showResponse(api.listStates());
    //  api.showResponse(api.listRateCenters("2", "NC"));
    //  api.showResponse( api.listAvailableDids("local", "1b", "NC", "DURHAM") );
    //  api.showResponse( api.orderDid("1b", "9842430530", "My note") );
    //  api.showResponse( api.listDids() );
    //  api.showResponse( api.updateDid("9842430530", "my note2", "1111", "") );
        jsonParser jsonParser = new jsonParser();
        jsonParser.printinfo();

    }
}
