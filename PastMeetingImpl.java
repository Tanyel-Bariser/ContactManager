import java.util.Calendar;
import java.util.Set;

public class PastMeetingImpl extends MeetingImpl implements PastMeeting {
	private String notes = "";
	
	public PastMeetingImpl(int id, Calendar date, Set<Contact> contacts, String note) {
		super(id, date, contacts);
		notes += note;
	}
	public PastMeetingImpl(Meeting meeting, String note) {
		super(meeting.getId(), meeting.getDate(), meeting.getContacts());
		notes += note;
	}
	public String getNotes() {
		return notes;
	}
}