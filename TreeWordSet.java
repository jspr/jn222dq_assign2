package jn222dq_assign2;

import java.util.Iterator;

//based on the IntBST example from Moodle
public class TreeWordSet implements WordSet{

	private int size; //field for the size of the tree
	private BST root = null; //starting point of the root tree
	
	//constructor
	public TreeWordSet() {
		size = 0;
	}
	
	// Add word if not already added
	@Override
	public void add(Word word) {
		if (root==null) { //if this is the first element
			root = new BST(word,null);
			size++;
		}
		else
			root.add(word);	
	}

	// Return true if word contained
	@Override
	public boolean contains(Word word) {
		if (root==null) //if the tree is empty
			return false;
		else
			return root.contains(word);
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
		return new TreeIterator();
	}
	
	public class TreeIterator implements Iterator<Word>{
	    private BST next;

	    //based on:
	    //https://stackoverflow.com/questions/12850889/in-order-iterator-for-binary-tree
	    public TreeIterator() {
	        next = root;
	        if(next != null) { //if not empty
		        while (next.left != null) {
		        	next = next.left; //start all the way to the left
		        } 
	        }
	    }

	    public boolean hasNext(){
	        return next != null;
	    }

	    public Word next(){
	        
	        BST bst = next;

	        if(next.right != null) { //check if a subtree exists to the right
	            next = next.right;
	            while (next.left != null) { //walk all the way to the left
	                next = next.left;
	            }
	            return bst.word;
	        }

	        while(true) {
	            if(next.parent == null) { //the tree is traversed
	                next = null;
	                return bst.word;
	            }
	            if(next.parent.left == next) { //check if we have visited the parent
	                next = next.parent;
	               return bst.word;
	            }
	            next = next.parent;
	        }
	     }
	    
		public void remove() {
			throw new RuntimeException("remove() is not implemented");
		}
	 }
	
	//inner class for the binary tree
	private class BST {
		Word word;
		BST left = null;
		BST right = null;
		BST parent = null;
		
		BST(Word word, BST parent) {
			this.word = word;
			this.parent = parent;
		}
		
		void add(Word newWord) {
			if (newWord.compareTo(word) < 0) {  // add to left branch
				if (left == null) {
					left = new BST(newWord,this);
					size++;
				}			
				else
					left.add(newWord);
			}
			else if (newWord.compareTo(word) > 0) { // add to right branch
				if (right == null) {
					right = new BST(newWord,this);
					size++;
				}
				else
					right.add(newWord);
			}
		}
		
		boolean contains(Word newWord) {
			if (newWord.compareTo(word) < 0) {  // search left branch
				if (left == null)
					return false;
				else
					return left.contains(newWord);
			}
			else if (newWord.compareTo(word) > 0) { // search right branch
				if (right == null)
					return false;
				else
					return right.contains(newWord);
			}
			return true;   // Found!
		}
	}

}
