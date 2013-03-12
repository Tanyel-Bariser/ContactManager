import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
//A class to test the methods of ContactImpl
public class ContactTest {
	private Contact contact, contactNext;

	@Before
	public void buildUp() {
		contact = new ContactImpl("Tanyel", "TestNote");
		contactNext = new ContactImpl("John", "Notes");
	}
	@After
	public void cleanUp() {
		contact = null;
		contactNext = null;
	}
	@Test
	public void testsGetId() {//Each time an instance of contact is created the id is incremented by 1
		assertEquals(contact.getId(), contactNext.getId()-1);
	}
	@Test
	public void testsGetName() {
		assertEquals(contact.getName(), "Tanyel");
	}
	@Test
	public void testsGetNotes() {//Adds "\n" at end of each new note is that is added
		assertEquals(contact.getNotes(), "TestNote\n");
	}
	@Test
	public void testsAddNotes() {
		contact.addNotes("&MoreNotes");
		assertEquals(contact.getNotes(), "TestNote\n&MoreNotes\n");
	}
}