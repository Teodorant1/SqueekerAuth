package sample;

import org.json.JSONObject;

public class jsonParser {

    private final String symbol = "\"";
    String jsonstring =
            "{" +   symbol + "creator" + symbol +":" + symbol + 1 + symbol + "," +
                    symbol + "contact" + symbol + ":" + symbol + 2 + symbol + "," +
                    symbol + "schedule" + symbol + ":" + symbol + 3 + symbol + "," +
                    symbol + "datetime" + symbol + ":" + symbol + 4 + symbol + "," +
                    symbol + "template"+ symbol + ":" +symbol+ 5 + symbol + "}";

    JSONObject obj = new JSONObject(jsonstring);
    public void printinfo ()
    {System.out.println(obj.getString("schedule"));}








}
