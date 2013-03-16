import java.util.Calendar;
import java.util.Set;
import java.io.Serializable;
//A class for past meetings including notes about what happened and what was agreed
public class PastMeetingImpl extends MeetingImpl implements PastMeeting {
	private String notes = "";
	
	//Constructor with no parameters as an attempt to make class serialisable
	public PastMeetingImpl() {}
	public PastMeetingImpl(Set<Contact> contacts, Calendar date, String note) {
		super(contacts, date);
		notes += note + "\n";
	}
	//Used by the ContactManager.addMeetingNotes() method to convert to PastMeeting type and keep same id
	public PastMeetingImpl(int id, Set<Contact> contacts, Calendar date, String note) {
		super(id, contacts, date);
		notes += note + "\n";
	}
	public String getNotes() {
		return notes;
	}
	public void addNotes(String note) {
		notes += note + "\n";
	}
}