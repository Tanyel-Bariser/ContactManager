import java.util.Calendar;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;

public class ContactManagerTest {
	private ContactManager manager;
	private Contact contact1, contact2;
	private Set<Contact> contacts;
	private Calendar futureDate, pastDate;
	private int futureId, pastId;
		
	@Before
	public void buildUp() {
		manager = new ContactManagerImpl();
		contact1 = new ContactImpl("Tanyel");
		contact2 = new ContactImpl("John");
		contacts = new HashSet<Contact>();
		contacts.add(contact1);
		contacts.add(contact2);
		pastDate = Calendar.getInstance();
		futureDate = Calendar.getInstance();
		pastDate.set(2000, 1, 1);
		futureDate.set(2020, 1, 1);
		manager.addNewContact("pastJake", "");
		manager.addNewContact("futureJake", "");
		manager.addNewPastMeeting(manager.getContacts("pastJake"), pastDate, "Notes");
		futureId = manager.addFutureMeeting(manager.getContacts("futureJake"), futureDate);
		pastId = getsMeetingId(pastDate);
	}
	@After
	public void cleanUp() {
		manager = null;
		contact1 = null;
		contact2 = null;
		contacts = null;
		pastDate = null;
		futureDate = null;
		futureId = -1;
		pastId = -1;
	}
	//Returns the ID number for int pastId in buildUp()
	private int getsMeetingId(Calendar pastDate) {
		List<Meeting> pastMeetingList = manager.getFutureMeetingList(pastDate);
		Meeting pastMeeting = null;
		for (Meeting m : pastMeetingList) {
			pastMeeting = m;
		}
		return pastMeeting.getId();
	}
	//Gets individual contact by name from ContactManager manager
	private Contact getContact(String name) {
		Set<Contact> contacts = manager.getContacts(name);
		Contact contact = null;
		for (Contact c : contacts) {
			contact = c;
		}
		return contact;
	}
	
		/*****************************************************************************
		*    TESTS FOR int addFutureMeeting(Set<Contact> contacts, Calendar date)    *
		*****************************************************************************/
	//Tests basic functionality of addFutureMeeting()
	@Test
	public void testsAddFutureMeeting() {
		int id = manager.addFutureMeeting(manager.getContacts("futureJake"), futureDate);
		//The line above just created the second meeting that takes place on futureDate
		assertEquals(manager.getFutureMeetingList(futureDate).size(), 2);
		//Only one contact in ContactManager manager with name "futureJake"
		assertEquals(manager.getContacts("futureJake").size(), 1);
		assertEquals(manager.getMeeting(id).getDate(), futureDate);
		assertEquals(manager.getFutureMeeting(id), manager.getMeeting(id));
	}
	//Test for null date
	@Test(expected = NullPointerException.class)
	public void testsAddFutureMeetingNullDate() {
		futureDate = null;
		manager.addFutureMeeting(manager.getContacts("futureJake"), futureDate);
	}
	//Tests for past date
	@Test(expected = IllegalArgumentException.class)
	public void testsAddFutureMeetingPastDate() {
		manager.addFutureMeeting(manager.getContacts("pastJake"), pastDate);
	}
	//Tests for null contacts
	@Test(expected = NullPointerException.class)
	public void testsAddFutureMeetingNullContacts() {
		contacts = null;
		manager.addFutureMeeting(contacts, futureDate);
	}
	//Tests for empty contacts set
	@Test(expected = IllegalArgumentException.class)
	public void testsAddFutureMeetingEmptyContacts() {
		contacts.remove(contacts);
		manager.addFutureMeeting(contacts, futureDate);
	}
	//Tests for unknown contact
	@Test(expected = IllegalArgumentException.class)
	public void testsAddFutureMeetingUnknownContact() {
		manager.addFutureMeeting(contacts, futureDate);
	}
	
		/*****************************************************
		*    TESTS FOR PastMeeting getPastMeeting(int id)    *
		*****************************************************/
	//Tests basic functionality of getPastMeeting()
	@Test
	public void testsGetPastMeeting() {
		PastMeeting pastMeeting = manager.getPastMeeting(pastId);
		assertEquals(pastMeeting.getNotes(), "Notes\n");
		assertEquals(pastMeeting.getDate(), pastDate);
		assertEquals(pastMeeting.getContacts().size(), 1);
		assertEquals(manager.getPastMeeting(-10), null);
	}
	//Tests for future date
	@Test (expected = IllegalArgumentException.class)
	public void testsGetPastMeetingFutureDate() {
		manager.getPastMeeting(futureId);
	}
		
		/********************************************************
		*	TESTS FOR FutureMeeting getFutureMeeting(int id)	*
		********************************************************/
	//Tests basic functionality of getFutureMeeting()
	@Test
	public void testsGetFutureMeeting() {
		FutureMeeting futureMeeting = manager.getFutureMeeting(futureId);
		assertEquals(futureMeeting.getDate(), futureDate);
		assertEquals(futureMeeting.getContacts().size(), 1);
		assertEquals(futureMeeting, manager.getMeeting(futureId));
	}
	//Tests for past date
	@Test(expected = IllegalArgumentException.class)
	public void testsGetFutureMeetingPastDate() {
		manager.getFutureMeeting(pastId);
	}
	
		/********************************************
		*	TESTS FOR Meeting getMeeting(int id)	*
		********************************************/
	//Tests basic functionality of getMeeting()
	@Test
	public void testsGetMeeting() {
		assertEquals(manager.getMeeting(-10), null);
		//Tests for future meetings
		FutureMeeting futureMeeting = (FutureMeeting) manager.getMeeting(futureId);
		assertEquals(futureMeeting.getDate(), futureDate);
		assertEquals(futureMeeting.getContacts().size(), 1);
		assertEquals(futureMeeting, manager.getFutureMeeting(futureId));
		
		//Tests for past meetings
		PastMeeting pastMeeting = (PastMeeting) manager.getMeeting(pastId);
		assertEquals(pastMeeting.getNotes(), "Notes\n");
		assertEquals(pastMeeting.getDate(), pastDate);
		assertEquals(pastMeeting.getContacts().size(), 1);
	}
	
		/********************************************************************
		*	TESTS FOR List<Meeting> getFutureMeetingList(Contact contact)	*
		********************************************************************/
	//Tests basic functionality of getFutureMeetingList()
	@Test
	public void testsGetFutureMeetingList() {
		assertEquals(manager.getFutureMeetingList(getContact("futureJake")).size(), 1); 
		assertEquals(manager.getFutureMeetingList(getContact("pastJake")).size(), 0);
	}
	//Tests for unknown contact
	@Test (expected = IllegalArgumentException.class)
	public void testsGetFutureMeetingListUnknownContact() {
		manager.getFutureMeetingList(contact1);
	}
}