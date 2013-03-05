import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ContactTest {
	private ContactImpl contact, contactSame;

	@Before
	public void buildUp() {
		contact = new ContactImpl(4, "Tanyel", "TestNote");
	}
	@Test
	public void testsGetId() {
		assertEquals(contact.getId(), 4);
	}
	@Test
	public void testsGetName() {
		assertEquals(contact.getName(), "Tanyel");
	}
	@Test
	public void testsGetNotes() {
		assertEquals(contact.getNotes(), "TestNote");
	}
	@Test
	public void testsAddNotes() {
		contact.addNotes("&MoreNotes");
		assertEquals(contact.getNotes(), "TestNote&MoreNotes");
	}
	@Test
	public void testsEquals() {
		contactSame = new ContactImpl(contact);
		assertTrue(contact.equals(contactSame));
	}
}