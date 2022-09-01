package sample;

public class user {
    String name;
    String password;
    String domain;



    String usernumber;

    private final String symbol = "\"";

    public String toJSON ()
    { return
            "{" + symbol + "name" + symbol +":" + symbol + this.getName() + symbol + "," +
                    symbol + "password" + symbol + ":" + symbol + this.getPassword() + symbol + "," +
                    symbol + "usernumber" + symbol + ":" + symbol + this.getUsernumber() + symbol + "," +

                    symbol + "domain" + symbol + ":" + symbol + this.getDomain() + symbol + "}";
    }

    public user(){}
    public user(String name, String password, String usernumber , String domain) {
        this.name = name;
        this.password = password;
        this.usernumber = usernumber;
        this.domain = domain;
    }

    public String getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

}
