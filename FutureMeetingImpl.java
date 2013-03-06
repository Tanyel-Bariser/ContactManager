import java.util.Calendar;
import java.util.Set;

public class FutureMeetingImpl extends MeetingImpl implements FutureMeeting {
	
	public FutureMeetingImpl(int id, Set<Contact> contacts, Calendar date) {
		super(id, contacts, date);
	}
	public FutureMeetingImpl(Meeting meeting) {
		super(meeting.getId(), meeting.getContacts(), meeting.getDate());
	}
}