package sample;



import com.google.gson.*;
import java.util.*;


public class Dids extends Connect {

    public Dids() {
        super();
    }

    /*
     * List available states
     */
    public JsonObject listStates() {
        return query("did/states");
    }


    /*
     * List available Rate Centers by state
     */
    public JsonObject listRateCenters(String tier, String state)
    {
        JsonObject params = new JsonObject();
        params.addProperty("tier", tier);
        params.addProperty("state", state);

        return query("did/ratecenters", params);
    }


    /*
     * List available DIDs by type, tier and state
     */
    public JsonObject listAvailableDids(String type, String tier, String state, String ratecenter)
    {
        JsonObject params = new JsonObject();
        params.addProperty("type", tier);
        params.addProperty("tier", tier);
        params.addProperty("state", state);
        params.addProperty("ratecenter", ratecenter);

        return query("did/available", params);
    }


    /*
     * Order DID
     */
    public JsonObject orderDid(String tier, String did, String note)
    {
        JsonObject params = new JsonObject();
        params.addProperty("tier", tier);
        params.addProperty("did", did);
        params.addProperty("note", note);

        return query("did", params, TypeMethodEnum.POST);
    }


    /*
     * List ordered DIDs
     */
    public JsonObject listDids()
    {
        JsonObject params = new JsonObject();

        return query("did", params, TypeMethodEnum.GET);
    }


    /*
     * Update DID properties
     */
    public JsonObject updateDid(String did, String note, String pin, String route2trunk)
    {
        JsonObject params = new JsonObject();
        params.addProperty("did", did);
        params.addProperty("note", note);
        params.addProperty("pin", pin);
        params.addProperty("route2trunk", route2trunk);

        return query("did", params, TypeMethodEnum.PUT);
    }



    /*
     * Completer remove DID from your account
     */
    public JsonObject deleteDid(String did)
    {
        JsonObject params = new JsonObject();
        params.addProperty("did", did);

        return query("did", params, TypeMethodEnum.DELETE);
    }


}
