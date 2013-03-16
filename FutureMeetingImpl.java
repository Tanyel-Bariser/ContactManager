import java.util.Calendar;
import java.util.Set;
import java.io.Serializable;
//A class for future meetings
public class FutureMeetingImpl extends MeetingImpl implements FutureMeeting, Serializable {
	//This class is only necessary for type checking and/or downcasting
	
	//Constructor with no parameters as an attempt to make class serialisable
	public FutureMeetingImpl() {}
	public FutureMeetingImpl(Set<Contact> contacts, Calendar date) {
		super(contacts, date);
	}
}