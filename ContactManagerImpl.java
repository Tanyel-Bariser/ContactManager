import java.util.Calendar;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
//A class to manage your contacts and meetings
public class ContactManagerImpl implements ContactManager {
	private Map<Integer, Contact> idContactsMap;
	private Map<Integer, Meeting> idMeetingsMap;
	
	public ContactManagerImpl() {
		idContactsMap = new HashMap<>();
		idMeetingsMap = new HashMap<>();
	}
	//Takes a set of contacts and complains if one or more contact(s) is unknown.
	private void checkContactsAreKnown(Set<Contact> contacts) {
		for (Contact contact : contacts) {
			boolean unknownContact = !idContactsMap.containsValue(contact);
			if (unknownContact) {
				throw new IllegalArgumentException(contact.getName() + " is an unknown contact");
			}
		}
	}
	//Takes one contact and complains if contact is unknown.
	private void checkContactIsKnown(Contact contact) {
		if (!idContactsMap.containsValue(contact)) {
			throw new IllegalArgumentException(contact.getName() + "is an unknown contact");
		}
	}
	//Adds a new meeting to be held in the future. Complains if a contact is unknown or if the date is in the past.
	public int addFutureMeeting(Set<Contact> contacts, Calendar date) {
		checkContactsAreKnown(contacts);
		if (date == null || date.compareTo(Calendar.getInstance()) < 0) {
			throw new IllegalArgumentException("Date of meeting to be added should be in the future NOT the past.");
		}
		Meeting futureMeeting = new FutureMeetingImpl(contacts, date);
		int meetingId = futureMeeting.getId();
		idMeetingsMap.put(meetingId, futureMeeting);
		return meetingId;
	}
	//Returns the PAST meeting with the requested ID, or null. Complains if the meeting is in the future.
	public PastMeeting getPastMeeting(int id) {
		Meeting pastMeeting = idMeetingsMap.get(id);
		if (pastMeeting == null || pastMeeting.getDate().compareTo(Calendar.getInstance()) < 0) {
			return (PastMeeting) pastMeeting;
		} else {
			throw new IllegalArgumentException("Date of meeting is in the future.");
		}
	}
	//Returns the FUTURE meeting with the requested ID, or null. Complains if the meeting is in the past.
	public FutureMeeting getFutureMeeting(int id) {
		Meeting futureMeeting = idMeetingsMap.get(id);
		if (futureMeeting == null || futureMeeting.getDate().compareTo(Calendar.getInstance()) > 0) {
			return (FutureMeeting) futureMeeting;
		} else {
			throw new IllegalArgumentException("Date of meeting is in the past.");
		}
	}
	//Returns the meeting with the requested ID, or null if it there is none.
	public Meeting getMeeting(int id) {
		return idMeetingsMap.get(id);
	}
	//Returns the list of sorted future meetings scheduled with this contact. Complains if contact is unknown.
	public List<Meeting> getFutureMeetingList(Contact contact) {
		checkContactIsKnown(contact);
		List<Meeting> contactFutureMeetings = new LinkedList<>();
		for (Meeting meeting : idMeetingsMap.values()) {
			if (meeting.getContacts().contains(contact) && meeting.getDate().compareTo(Calendar.getInstance()) > 0) {
				contactFutureMeetings.add(meeting);
			}
		}
		Collections.sort(contactFutureMeetings, new DateMeetingComparator());
		return contactFutureMeetings;
	}
	//Returns the list of sorted meetings that are scheduled for, OR THAT TOOK PLACE ON, the specified date.
	public List<Meeting> getFutureMeetingList(Calendar date) {
		List<Meeting> futureMeetingsList = new LinkedList<>();
		for (Meeting meeting : idMeetingsMap.values()) {
			if (meeting.getDate().equals(date)) {
				futureMeetingsList.add(meeting);
			}
		}
		Collections.sort(futureMeetingsList, new DateMeetingComparator());
		return futureMeetingsList;
	}
	//Returns the list of past meetings in which this contact has participated. Complains if contact is unknown.
	public List<PastMeeting> getPastMeetingList(Contact contact) {
		checkContactIsKnown(contact);
		List<PastMeeting> contactPastMeetings = new LinkedList<>();
		for (Meeting meeting : idMeetingsMap.values()) {
			if (meeting.getContacts().contains(contact) && meeting.getDate().compareTo(Calendar.getInstance()) < 0) {
				if (!meeting instanceof PastMeeting) {
//FOUND MISTAKE... NEED TO MAKE SURE ONLY INSTANCES OF PASTMEETING ARE ADDED TO LIST
				contactPastMeetings.add(meeting);
			}
		}
		Collections.sort(contactPastMeetings, new DateMeetingComparator());
		return contactPastMeetings;
	}
	public void addNewPastMeeting(Set<Contact> contacts, Calendar date, String text) {
		checkContactsAreKnown(contacts);
		if (date == null || date.compareTo(Calendar.getInstance()) > 0) {
			throw new IllegalArgumentException("Date of meeting to be added should be in the past NOT the future.");
		}
		Meeting pastMeeting = new PastMeetingImpl(contacts, date, text);
		int meetingId = pastMeeting.getId();
		idMeetingsMap.put(meetingId, pastMeeting);
		return meetingId;
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