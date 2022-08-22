package sample;

public class tenantdomain {



    String name;
    String author;
    private final String symbol = "\"";

    public String toJSON()
    { return
            "{" + symbol + "name" + symbol +":" + symbol + this.getName() + symbol + "," +
             symbol + "author" + symbol + ":" + symbol + this.getAuthor() + symbol + "}";}

    public tenantdomain(){}

    public tenantdomain(String name, String author) {
        this.name = name;
        this.author = author;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
