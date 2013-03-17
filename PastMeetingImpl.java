import java.util.Calendar;
import java.util.Set;
import java.io.Serializable;
/**
* A meeting that was held in the past.
*
* It includes your notes about what happened and what was agreed.
*/
public class PastMeetingImpl extends MeetingImpl implements PastMeeting {
    private String notes = "";
	
    /**
    * Constructor with no parameters to make class serialisable
    */
    public PastMeetingImpl() {}
    /**
    * Constructor for PastMeetingImpl
    *
    * @param contacts who took part in past meeting
    * @param date the past meeting took place
    * @param note recorded for past meeting
    */
    public PastMeetingImpl(Set<Contact> contacts, Calendar date, String note) {
        super(contacts, date);
        notes += note + "\n";
    }
    /**
    * Constructor which takes ID as argument
    *
    * Used by the ContactManager.addMeetingNotes() method to convert to PastMeeting type and keep same id
    *
    * @param id for meeting to be able to keep same ID when converted from FutureMeeting type to PastMeeting type
    * @param contacts who took part in past meeting
    * @param date the past meeting took place
    * @param note recorded for past meeting
    */
    public PastMeetingImpl(int id, Set<Contact> contacts, Calendar date, String note) {
        super(id, contacts, date);
        notes += note + "\n";
    }
    /**
    * Returns the notes from the meeting.
    *
    * If there are no notes, the empty string is returned.
    *
    * @return the notes from the meeting.
    */
    public String getNotes() {
        return notes;
    }
    /**
    * Adds notes to past meeting
    *
    * @param note for past meeting
    */
    public void addNotes(String note) {
        notes += note + "\n";
    }
}