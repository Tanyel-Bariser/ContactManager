import java.util.Calendar;
import java.util.Set;

public class MeetingImpl implements Meeting {
	private static int idStatic = 0;
	private int id;
	private Calendar date;
	private Set<Contact> contacts;
	
	public MeetingImpl(Set<Contact> contacts, Calendar date) {
		id = idStatic++;
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
}