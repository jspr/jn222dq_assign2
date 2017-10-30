package jn222dq_assign2;

public class Word implements Comparable<Word> {
	private String word;

	//constructor
	public Word(String str) {
		word = str;
	}
	
	//returns a string representation of the object
	@Override
	public String toString() {
		return word;
	}
	
	/* Override Object methods */
	@Override
	public int hashCode() {
		return word.toUpperCase().hashCode();
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof Word) {
			return other.toString().toUpperCase().equals(word.toUpperCase());
		}else {
			return false;
		}
	}
	
	/* Implement Comparable */
	@Override
	public int compareTo(Word w) {
		return word.toUpperCase().compareTo(w.toString().toUpperCase());
	}
}
