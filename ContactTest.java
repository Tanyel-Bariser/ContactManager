import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class ContactTest {
	private Contact contact;

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
}