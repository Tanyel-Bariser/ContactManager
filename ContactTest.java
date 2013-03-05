import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class ContactTest {
	private Contact c;

	@Before
	public void buildUp() {
		c = new ContactImpl(4, "Tanyel", "TestNote");
	}
	@Test
	public void testsGetId() {
		assertEquals(c.getId(), 4);
	}
	@Test
	public void testsGetName() {
		assertEquals(c.getName(), "Tanyel");
	}
	@Test
	public void testsGetNotes() {
		assertEquals(c.getNotes(), "TestNote");
	}
	@Test
	public void testsAddNotes() {
		c.addNotes("&MoreNotes");
		assertEquals(c.getNotes(), "TestNote&MoreNotes");
	}
}