import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;
import java.util.HashSet;
import java.util.Calendar;

public class MeetingTest {
	private Contact contact1, contact2;
	private Set<Contact> contacts;
	private Meeting meeting, meetingNext;
	private Calendar date;
	
	@Before
	public void buildUp() {
		contact1 = new ContactImpl("Tanyel");
		contact2 = new ContactImpl("John");
		contacts = new HashSet<Contact>();
		contacts.add(contact1);
		contacts.add(contact2);
		date = Calendar.getInstance();
		meeting = new MeetingImpl(contacts, date);
		meetingNext = new MeetingImpl(contacts, date);
	}
	@After
	public void cleanUp() {
		contact1 = null;
		contact2 = null;
		contacts = null;
		meeting = null;
		meetingNext = null;
		date = null;
	}
	@Test
	public void testsGetId() {//Each time an instance of meeting is created the id is incremented by 1
		assertEquals(meeting.getId(), meetingNext.getId()-1);
	}
	@Test
	public void testsGetDate() {
		assertEquals(date, meeting.getDate());
	}
	@Test
	public void testsGetContacts() {
		assertEquals(contacts, meeting.getContacts());
	}
}