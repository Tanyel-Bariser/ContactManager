import java.util.Calendar;
import java.util.Set;

public class PastMeetingImpl extends MeetingImpl implements PastMeeting {
	private String notes = "";
	
	public PastMeetingImpl(Set<Contact> contacts, Calendar date, String note) {
		super(contacts, date);
		notes += note + "\n";
	}
	public String getNotes() {
		return notes;
	}
	public void addNotes(String note) {
		notes += note + "\n";
	}
}