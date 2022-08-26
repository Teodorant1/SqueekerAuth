package sample;


import com.google.gson.*;
import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.*;
import java.util.Base64;
import java.util.Iterator;
import java.util.Set;
import javax.net.ssl.*;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;


public class Connect {

    private String login = null;
    private String password = null;
    private String key = null;
    private String ip = null;

    private TypeApiEnum typeApi = TypeApiEnum.JSON;
    private static String baseurl = "https://api2.questblue.com/";

    public Connect()
    {
        this.login = "smsauth"; // Your account username or API username
        this.password = "Lambda!@#12"; // Your account password or API password
        this.key = "zlQgPIOeRdRn9IccQqtcAaHV6N8yQJsL";  // Your API private key
        this.ip = "198.0.237.9";  // Your server IP address
    }


    protected JsonObject query(String request) {
        return query(request, null, TypeMethodEnum.GET);
    }


    protected JsonObject query(String request, JsonObject params) {
        return query(request, params, TypeMethodEnum.GET);
    }


    protected JsonObject query(String request, JsonObject params,
                               TypeMethodEnum typeMethod)
    {
        JsonObject ret = null;
        try {
            String encodedstring = Base64.getEncoder().encodeToString(
                    (login + ":" + password).getBytes()
            );

            SSLContext ctx = SSLContext.getInstance("TLS");
            ctx.init(new KeyManager[0],
                    new TrustManager[]{new DefaultTrustManager() {
                    }},
                    new SecureRandom());
            SSLContext.setDefault(ctx);

            HttpClient client = new HttpClient();
            MethodRequest method = new MethodRequest(baseurl + request, typeMethod);

            method.setRequestHeader("Authorization", "Basic " + encodedstring);
            method.setRequestHeader("Security-Key", getMd5(key + ip));
            method.setRequestHeader("User-Agent", "QB API v.2");
            method.setRequestHeader("Content-Type", "application/"
                    + typeApi.getName());

            if (params != null) {
                StringRequestEntity entity = new StringRequestEntity(params.toString(),
                        null, null);
                method.setRequestEntity(entity);
            }

            int statusCode = client.executeMethod(method);
            String response = method.getResponseBodyAsString();

            System.out.println("Status Code: " + statusCode);
            System.out.println("Code: "
                    + HttpStatus.getStatusText(statusCode));
            System.out.println("Sererv Response: "+response);
            if (statusCode == 200) {
                ret = (new JsonParser()).parse(response).getAsJsonObject();
            }
            method.releaseConnection();

        } catch (IOException | KeyManagementException | NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
   //     System.out.println(ret);
        return ret;
    }


    private String getMd5(String input)
    {
        try {
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Method is called to calculate message digest, returns byte array
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    public void setTypeApi(TypeApiEnum t) {
        typeApi = t;
    }


    private class MethodRequest extends PostMethod
    {
        private MethodRequest(String url, TypeMethodEnum t)
        {
            super(url);
            type = t;
        }

        @Override
        public String getName() {
            return type.getName();
        }
        TypeMethodEnum type = TypeMethodEnum.GET;
    }


    public enum TypeApiEnum
    {
        JSON("json"), XML("xml");

        TypeApiEnum(String s) {
            name = s;
        }

        public String getName() {
            return name;
        }

        private String name;
    }


    public enum TypeMethodEnum
    {
        POST("POST"), GET("GET"), PUT("PUT"), DELETE("DELETE");

        TypeMethodEnum(String s) {
            name = s;
        }

        public String getName() {
            return name;
        }

        private String name;
    }


    private static class DefaultTrustManager implements X509TrustManager
    {
        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }


    public void showResponse(JsonObject resp)
    {
        if (resp != null) {
            int total = resp.get("total").getAsInt();
            System.out.println("Totsl objects: " + total);

            System.out.println("Object list:");
            JsonElement element = resp.get("data");
            if (element.isJsonObject()) {
                JsonObject data = element.getAsJsonObject();

                Set set = data.entrySet();
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    System.out.println(it.next());
                }
            } else if (element.isJsonArray()) {
                JsonArray arr = element.getAsJsonArray();
                Iterator it = arr.iterator();
                while (it.hasNext()) {
                    System.out.println(it.next());
                }
            }
        }
    }


}
