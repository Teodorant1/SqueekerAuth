package sample;

public class message {


    public String toJson ()

    { return
            "{" + symbol + "user" + symbol +":" + symbol + getUser() + symbol + "," +
            symbol + "contact" + symbol + ":" + symbol + getContact() + symbol + "," +
            symbol + "message" + symbol + ":" + symbol + getMessage() + symbol + "," +
            symbol + "size"+ symbol + ":" +symbol+ getSize() + symbol + "}";  }

    String user;
    String contact;
    String message;
    int size;
    private final String symbol = "\"";


    public message(String user, String contact, String message, int size) {
        this.user = user;
        this.contact = contact;
        this.message = message;
        this.size = size;
    }

    public message() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
