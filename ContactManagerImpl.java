import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class ContactManagerImpl implements ContactManager {
	private Map<Integer, Contact> idContactsMap;
	private Map<Integer, Meeting> idMeetingsMap;
	private int meetingId;
	
	public ContactManagerImpl() {
		idContactsMap = new HashMap();
		idMeetingsMap = new HashMap();
		meetingId = 0;
	}
	public int addFutureMeeting(Set<Contact> contacts, Calendar date) {
		if (date.compareTo(Calendar.getInstance()) < 0) {
			throw new IllegalArgumentException("Date of meeting to be added cannot be in past.");
		}
		for (Contact contact : contacts) {
			boolean unknownContact = !idContactsMap.containsValue(contact);
			if (unknownContact) {
				throw new IllegalArgumentException("Set of contacts contains unknown contact(s)");
			}
		}
		meetingId++;
		idMeetingMap.put(meetingId, new FutureMeetingImpl(meetingId, contacts, date));
		return meetingId;
	}
	public PastMeeting getPastMeeting(int id) {
		 
	}
	public FutureMeeting getFutureMeeting(int id) {
		
	}
	public Meeting getMeeting(int id) {
		
	}
	public List<Meeting> getFutureMeetingList(Contact contact) {
		
	}
	public List<Meeting> getFutureMeetingList(Calendar date) {
		
	}
	public List<PastMeeting> getPastMeetingList(Contact contact) {
		
	}
	public void addNewPastMeeting(Set<Contact> contacts, Calendar date, String text) {
		
	}
	public void addMeetingNotes(int id, String text) {
		
	}
	public void addNewContact(String name, String notes) {
		
	}
	public Set<Contact> getContacts(int... ids) {
		
	}
	public Set<Contact> getContacts(String name) {
		
	}
	public void flush() {
	
	}
}