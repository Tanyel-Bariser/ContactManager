import java.util.Calendar;
import java.util.Set;
//A class for future meetings
public class FutureMeetingImpl extends MeetingImpl implements FutureMeeting {
	//This class is only necessary for type checking and/or downcasting
	public FutureMeetingImpl(Set<Contact> contacts, Calendar date) {
		super(contacts, date);
	}
}