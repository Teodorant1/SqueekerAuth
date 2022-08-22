package sample;

public class contact {




    String fullname;
    String user;
    String org;
    String phonenumber;
    private final String symbol = "\"";

    public String tojson()
    { return "{" + symbol + "fullname" + symbol +":" + symbol + getFullname() + symbol + "," +
            symbol + "user" + symbol + ":" + symbol + getUser() + symbol + "," +
            symbol + "org" + symbol + ":" + symbol + getOrg() + symbol + "," +
            symbol + "phonenumber"+ symbol + ":" +symbol+ getPhonenumber() + symbol + "}"; }

    public contact() {
    }
    public contact(String fullname, String user, String org, String phonenumber) {
        this.fullname = fullname;
        this.user = user;
        this.org = org;
        this.phonenumber = phonenumber;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

}
