import java.util.Calendar;
import java.util.Set;
import java.io.Serializable;
/**
* A meeting to be held in the future
*/
public class FutureMeetingImpl extends MeetingImpl implements FutureMeeting, Serializable {
    //This class is only necessary for type checking and/or downcasting
	
    /**
    * Constructor with no parameters to make class serialisable
    */
    public FutureMeetingImpl() {}
    /**
    * Constructor for FutureMeetinImpl
    *
    * @param contacts set to be added to the future meeting
    * @param date for the future meeting to take place on
    */
    public FutureMeetingImpl(Set<Contact> contacts, Calendar date) {
        super(contacts, date);
    }
}