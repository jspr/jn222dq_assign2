package jn222dq_assign2;

import java.util.Iterator;

//based on the StringHashSet example from Moodle
public class HashWordSet implements WordSet{
	
	private int size; //field for the size of the hash
	private Node[] buckets; //field for the storing of values
	
	//constructor
	public HashWordSet() {
		size = 0;
		buckets = new Node[3];
	}

	// Add word if not already added
	@Override
	public void add(Word word) {
		int bucketNumber = getBucketNumber(word); //get the appropriate bucket number
		Node node = buckets[bucketNumber];
		
		while (node != null) {
			if (node.word.equals(word))   					
				return;
			else 
				node = node.next;
		}
		
		/* Not found, add new node as first entry */
		node = new Node(word);
		node.next = buckets[bucketNumber];
		buckets[bucketNumber] = node;
		size++;
	
		if (size == buckets.length)
			rehash();	
	}
	
	// Return true if word contained
	@Override
	public boolean contains(Word word) {
		boolean found = false;
		int bucketNumber = getBucketNumber(word);
		Node node = buckets[bucketNumber];	
		while (node != null && !found) {
			if (node.word.equals(word))   					
				found = true;
			else 
				node = node.next;
		}
		return found;
	}
	
	// Return current set size
	@Override
	public int size() {
		return size;
	}
	
	// Print contained words
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(Word word : this) {
			if(sb.length()>1)
				sb.append(", ");
			sb.append(word);
		}
		sb.append("]");
		return sb.toString();
	}
	
	@Override
	public Iterator<Word> iterator() {
		return new SetIterator();
	}
	
	private class SetIterator implements Iterator<Word> {
		int pos = 0;
		Word[] words;
		
		public SetIterator() {
			/* Collect all words */
			words = new Word[size];
			int n = 0;
			for (int i=0;i<buckets.length;i++) {
				Node node = buckets[i];
				while (node != null) {
					words[n++] = node.word;
					node = node.next;
				}
			}
		}
		public boolean hasNext() {			
			return pos < words.length;
		}		
		public Word next() {
			return words[pos++];
		}	
		public void remove() {
			throw new RuntimeException("remove() is not implemented");
		}
	}
	
	//returns which bucket a word belongs to
	private int getBucketNumber(Word word) {
		int hashCode = word.hashCode();
		hashCode = Math.abs(hashCode); //if the hash code is negative it must be transformed to a positive number
		int bucketNo = hashCode % buckets.length; //the hash code modulus the number of buckets gives the bucket number
		return bucketNo;	
	}
	
	//rehashes
	private void rehash() {
		Node[] temp = buckets;  // Copy of old buckets
		buckets = new Node[2*temp.length];  // New empty buckets
		size = 0;
		for (Node n : temp) {   // Insert old values into new buckets
			if (n == null) continue;
			while (n != null) {
				add(n.word);
				n = n.next;
			}
		}
	}
	
	//inner class for the Node
	private class Node {
		Word word;
		Node next = null;
		public Node(Word word){
			this.word = word;
		}
		@Override
		public String toString(){
			return word.toString();
		}		
	}

}
