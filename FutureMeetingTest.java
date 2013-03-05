import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;
import java.util.HashSet;
import java.util.Calendar;

public class FutureMeetingTest {
	private Contact contact1, contact2;
	private Set<Contact> contacts;
	private FutureMeetingImpl meeting, meetingSame;
	private Calendar date;
	
	@Before
	public void buildUp() {
		contact1 = new ContactImpl(27, "Tanyel");
		contact2 = new ContactImpl(21, "John");
		contacts = new HashSet<Contact>();
		contacts.add(contact1);
		contacts.add(contact2);
		date = Calendar.getInstance();
		meeting = new FutureMeetingImpl(1, date, contacts);
		meetingSame = new FutureMeetingImpl(1, date, contacts);
	}
	@Test
	public void testsGetId() {
		assertEquals(1, meeting.getId());
	}
	@Test
	public void testsGetDate() {
		assertEquals(date, meeting.getDate());
	}
	@Test
	public void testsGetContacts() {
		assertEquals(contacts, meeting.getContacts());
	}
	@Test
	public void testsEquals() {
		assertTrue(meeting.equals(meetingSame));
	}
}