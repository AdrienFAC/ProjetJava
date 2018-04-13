package Vue;

public class Note {
	
	public int note;
	
	public Note(int n) {
		this.note=n;
	}
	
	public String toString() {
		return String.valueOf(note) + " /20" ;
	

}
	
	@Override
	public int hashCode() {
		return this.note;
	}
	
	@Override
	public boolean equals(Object o) {
		Note t = (Note)o;
		return t.note==this.note; 
	}
}
