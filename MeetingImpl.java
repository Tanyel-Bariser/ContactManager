import java.util.Calendar;
import java.util.Set;
import java.io.Serializable;
//Meetings have unique IDs, scheduled date and a list of participating contacts
public abstract class MeetingImpl implements Meeting, Serializable {
	private static int idStatic = 0;//Prevents more than one meeting having the same id
	private int id;
	private Calendar date;
	private Set<Contact> contacts;
	
	//Constructor with no parameters as an attempt to make class serialisable
	public MeetingImpl() {}
	public MeetingImpl(Set<Contact> contacts, Calendar date) {
		id = idStatic++;
		this.date = date;
		this.contacts = contacts;
	}
	//Only for PastMeetingImpl. Used by the ContactManager.addMeetingNotes() method to convert to PastMeeting type and keep same id
	public MeetingImpl(int id, Set<Contact> contacts, Calendar date) {
		this.id = id;
		this.date = date;
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