package sample;

public class message {


    public String toJson()
// I might need to refactor a lot of this
    {
        return
                "{" +   symbol + "Text"      +    symbol + ":" + symbol + getText()      + symbol + "," +
                        symbol + "Author"    +    symbol + ":" + symbol + getAuthor()    + symbol + "," +
                   //   symbol + "user"      +    symbol + ":" + symbol + getUser()      + symbol + "," +
                   //   symbol + "contact"   +    symbol + ":" + symbol + getContact()   + symbol + "," +
                   //   symbol + "media"     +    symbol + ":" + symbol + getMedia()     + symbol + "," +
                        symbol + "Segment"   +    symbol + ":" + symbol + getSegments()  + symbol + "," +
                        symbol + "date"      +    symbol + ":" + symbol + getDate()      + symbol + "," +
                        symbol + "time"      +    symbol + ":" + symbol + getTime()      + symbol + "," +
                        symbol + "alignment" +    symbol + ":" + symbol + getAlignment() + symbol +   "}";
    }

    String alignment;
    String date;
    String time;

    String user;
    String contact;
    String text;

    String author;
    String media;
    int segments;

    private final String symbol = "\"";


    public message(String user, String contact,
                   String message, String author,
                   String media, int segments, String date
            , String alignment, String time) {


        this.user = user;
        this.contact = contact;
        this.text = message;
        this.author = author;
        this.media = media;
        this.segments = segments;
        this.date = date;
        this.time = time;
        this.alignment = alignment;
    }

    public message() {
    }


    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
