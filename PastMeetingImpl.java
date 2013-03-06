import java.util.Calendar;
import java.util.Set;

public class PastMeetingImpl extends MeetingImpl implements PastMeeting {
	private String notes = "";
	
	public PastMeetingImpl(int id, Calendar date, Set<Contact> contacts, String note) {
		super(id, date, contacts);
		notes += note + "\n";
	}
	public PastMeetingImpl(PastMeeting meeting) {
		this(meeting.getId(), meeting.getDate(), meeting.getContacts(), meeting.getNotes());
	}
	public String getNotes() {
		return notes;
	}
	public void addNotes(String note) {
		notes += note + "\n";
	}
	public boolean equals(PastMeeting otherMeeting) {
		boolean equal = false;
		Meeting meeting = new MeetingImpl(otherMeeting.getId(), otherMeeting.getDate(), otherMeeting.getContacts());
		equal = super.equals(meeting);
		equal = equal && getNotes().equals(otherMeeting.getNotes());
		return equal;
	}
}