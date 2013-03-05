import java.util.Calendar;
import java.util.Set;

public class FutureMeetingImpl extends MeetingImpl implements FutureMeeting {
	
	public FutureMeetingImpl(int id, Calendar date, Set<Contact> contacts) {
		super(id, date, contacts);
	}
	public FutureMeetingImpl(Meeting meeting) {
		super(meeting.getId(), meeting.getDate(), meeting.getContacts());
	}
}