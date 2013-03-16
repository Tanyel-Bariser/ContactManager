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
	private Meeting pastMeeting, futureMeeting;
	private Calendar futureDate, pastDate;
	private int id1;
	private int id2;
		
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
		//pastMeeting = new PastMeetingImpl(contacts, date, "MeetingNotes");
		//futureMeeting = new FutureMeetingImpl(contacts, date);
		manager.addNewContact("Jake", "");
		//manager.addNewContact(contact2.getName(), contact2.getNotes());
	}
	@After
	public void cleanUp() {
		manager = null;
		contact1 = null;
		contact2 = null;
		contacts = null;
		pastMeeting = null;
		futureMeeting = null;
		pastDate = null;
		futureDate = null;
	}
		/*************************************************************************
		*    TESTS FOR addFutureMeeting(Set<Contact> contacts, Calendar date)    *
		*************************************************************************/
	//Tests basic functionality of addFutureMeeting()
	@Test
	public void testsAddFutureMeeting() {
		int id = manager.addFutureMeeting(manager.getContacts("Jake"), futureDate);
		assertEquals(manager.getContacts("Jake").size(), 1);
		//ID number of THIRD contact added/created is 2... "Tanyel" = ID 0 & "John" = ID 1 were created in @Before buildUp()
		assertEquals(manager.getContacts(2).size(), 1);
		assertEquals(manager.getMeeting(id).getDate(), futureDate);
		assertEquals(manager.getFutureMeetingList(futureDate).size(), 1);
		assertEquals(manager.getFutureMeeting(id), manager.getMeeting(id));
	}
	//Test for null date
	@Test(expected = NullPointerException.class)
	public void testsAddFutureMeetingNullDate() {
		futureDate = null;
		manager.addFutureMeeting(manager.getContacts("Jake"), futureDate);
	}
	//Tests for past date
	@Test(expected = IllegalArgumentException.class)
	public void testsAddFutureMeetingPastDate() {
		manager.addFutureMeeting(manager.getContacts("Jake"), pastDate);
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
	public void testsAddFutureMeetingNonExistentContact() {
		manager.addFutureMeeting(contacts, futureDate);
	}
	
	
	
	
	
	
	
	
	
	
	
}