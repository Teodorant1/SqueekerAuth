package sample;

public class message {


    public String toJson ()
// I might need to refactor a lot of this
    { return
      "{" + symbol + "message" + symbol + ":" + symbol + getMessage() + symbol + "," +
            symbol + "size"    + symbol + ":" +symbol+ getSize() + symbol +
            symbol + "author"  + symbol + ":" +symbol+ getAuthor() + symbol +
                    "}";  }



    String user;
    String contact;
    String message;
    String author;
    int size;
    private final String symbol = "\"";


    public message(String user, String contact, String message, int size, String author) {
        this.user = user;
        this.contact = contact;
        this.message = message;
        this.size = size;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
