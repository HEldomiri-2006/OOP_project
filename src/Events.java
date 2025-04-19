public class Events {
    private String event_name;
    private String event_organizer;
    private String event_category;
    private int event_id;
    private double price;

    public Events() {
    }

    public Events(String event_name, String event_organizer, String event_category, int event_id,double price) {
        this.event_name = event_name;
        this.event_organizer = event_organizer;
        this.event_category = event_category;
        this.event_id = event_id;
        this.price = price;
    }

    public String toString()
    {
        String Book= "event_name "+event_name +" event_organizer " + event_organizer + " event_category " + event_category+ " event_id "+ event_id;
        return Book;
    }

    public String getEvent_name() {
        return event_name;
    }

    public String getEvent_organizer() {
        return event_organizer;
    }

    public String getEvent_category() {
        return event_category;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_organizer(String event_organizer) {
        this.event_organizer = event_organizer;
    }

    public void setEvent_category(String event_category) {
        this.event_category = event_category;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
