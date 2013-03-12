import java.util.Calendar;
import java.util.Set;
//Meetings have unique IDs, scheduled date and a list of participating contacts
public abstract class MeetingImpl implements Meeting {
	private static int idStatic = 0;//Prevents more than one meeting having the same id
	private int id;
	private Calendar date;
	private Set<Contact> contacts;
	
	public MeetingImpl(Set<Contact> contacts, Calendar date) {
		id = idStatic++;
		this.date = date;
		this.contacts = contacts;
	}
	public MeetingImpl(int id, Set<Contact> contacts, Calendar date) {//Only used for past meetings
		this.id = id;//Only used by ContactManager.addMeetingNotes() to convert from future
		this.date = date;//to past meeting otherwise id is give by idStatic in MeetingImpl
		this.contacts = contacts;
	}
	public int getId() {
		return id;
	}
	public Calendar getDate() {
		return date;
	}
	//Return the details of people that attended the meeting.
	public Set<Contact> getContacts() {
		return contacts;
	}
}