package sample;

public class message {


    public String toJson()
// I might need to refactor a lot of this
    {
        return
                "{" +   symbol + "message" + symbol + ":" + symbol + getMessage() + symbol + "," +
                        symbol + "author" + symbol + ":" + symbol + getAuthor() + symbol +
                        symbol + "user" + symbol + ":" + symbol + getUser() + symbol +
                        symbol + "contact" + symbol + ":" + symbol + getContact() + symbol +
                        symbol + "media" + symbol + ":" + symbol + getMedia() + symbol +
                        symbol + "segments" + symbol + ":" + symbol + getSegments() + symbol +
                        "}";
    }


    String user;
    String contact;
    String message;

    String author;
    String media;
    int segments;

    private final String symbol = "\"";


    public message(String user, String contact, String message, String author, String media, int segments) {
        this.user = user;
        this.contact = contact;
        this.message = message;
        this.author = author;
        this.media = media;
        this.segments = segments;
    }

    public message() {}

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



    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public int getSegments() {
        return segments;
    }

    public void setSegments(int segments) {
        this.segments = segments;
    }

}
