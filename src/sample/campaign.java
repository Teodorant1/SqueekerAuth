package sample;

public class campaign {



    public String toJson ()

    { return
            "{" + symbol + "creator" + symbol +":" + symbol + getCreator() + symbol + "," +
                    symbol + "contact" + symbol + ":" + symbol + getContact() + symbol + "," +
                    symbol + "schedule" + symbol + ":" + symbol + getSchedule() + symbol + "," +
                    symbol + "datetime" + symbol + ":" + symbol + getDatetime() + symbol + "," +
                    symbol + "template"+ symbol + ":" +symbol+ getTemplate() + symbol + "}";  }

    String creator;
    String contact;
    String schedule;
    String datetime;
    String template;
    private final String symbol = "\"";

    public campaign() {
    }
    public campaign(String creator, String contact, String schedule, String datetime, String template) {
        this.creator = creator;
        this.contact = contact;
        this.schedule = schedule;
        this.datetime = datetime;
        this.template = template;
    }
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
