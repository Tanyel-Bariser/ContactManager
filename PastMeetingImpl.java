import java.util.Calendar;
import java.util.Set;

public class PastMeetingImpl extends MeetingImpl implements PastMeeting {
	private String notes = "";
	
	public PastMeetingImpl(int id, Set<Contact> contacts, Calendar date, String note) {
		super(id, contacts, date);
		notes += note + "\n";
	}
	public PastMeetingImpl(PastMeeting meeting) {
		this(meeting.getId(), meeting.getContacts(), meeting.getDate(), meeting.getNotes());
	}
	public String getNotes() {
		return notes;
	}
	public void addNotes(String note) {
		notes += note + "\n";
	}
	public boolean equals(PastMeeting otherMeeting) {
		boolean equal = false;
		Meeting meeting = new MeetingImpl(otherMeeting.getId(), otherMeeting.getContacts(), otherMeeting.getDate());
		equal = super.equals(meeting);
		equal = equal && getNotes().equals(otherMeeting.getNotes());
		return equal;
	}
}