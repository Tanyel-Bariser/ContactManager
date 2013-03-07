public class ContactImpl implements Contact {
	private static int idStatic = 0;
	private int id;
	private String name;
	private String notes;
	
	public ContactImpl(String name, String notes) {
		id = idStatic++;
		this.name = name;
		this.notes = notes + "\n";
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
	public void addNotes(String note) {
		notes += note + "\n";
	}		
}