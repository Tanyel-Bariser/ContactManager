import java.util.Calendar;
import java.util.Set;

public class PastMeetingImpl extends MeetingImpl implements PastMeeting {
	private String notes = "";
	
	public PastMeetingImpl(int id, Calendar date, Set<Contact> contacts, String note) {
		super(id, date, contacts);
		notes += note + "\n";
	}
	public PastMeetingImpl(Meeting meeting) {
		super(meeting.getId(), meeting.getDate(), meeting.getContacts());
	}
	public String getNotes() {
		return notes;
	}
}