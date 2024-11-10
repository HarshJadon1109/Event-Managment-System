import java.util.Date;

public class Event {
    private int eventId;
    private String eventName;
    private Date eventDate;
    private String eventLocation;
    private String eventDescription;

    public Event(int eventId, String eventName, Date eventDate, String eventLocation, String eventDescription) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
    }

    // Getters and Setters
}

