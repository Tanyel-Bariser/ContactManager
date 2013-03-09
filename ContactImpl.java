//A contact is a person we are making business with or may do in the future.
public class ContactImpl implements Contact {
	private static int idStatic = 0;
	private int id;
	private String name;
	private String notes;
	
	public ContactImpl(String name, String newNote) {
		id = idStatic++;//Prevents more than one contact having the same id
		this.name = name;
		notes = newNote + "\n";
	}
	public ContactImpl(String name) {
		this(name, "");
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getNotes() {
		return notes;
	}
	public void addNotes(String newNote) {
		notes += newNote + "\n";
	}		
}