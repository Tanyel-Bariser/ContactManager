import java.util.Calendar;
import java.util.Set;

public class MeetingImpl implements Meeting {
	private int id;
	private Calendar date;
	private Set<Contact> contacts;
	
	public MeetingImpl(int id, Calendar date, Set<Contact> contacts) {
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
	public Set<Contact> getContacts() {
		return contacts;
	}
	public boolean equals(Meeting otherMeeting) {
		boolean equal = false;
		equal = getId() == otherMeeting.getId();
		equal = equal && getDate().equals(otherMeeting.getDate());
		equal = equal && getContacts().equals(otherMeeting.getContacts());
		return equal;
	}
}