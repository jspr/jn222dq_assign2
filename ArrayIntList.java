package jn222dq_assign2;

public class ArrayIntList extends AbstractIntCollection implements IntList {

	/* Add integer n to the end of the list. */
	@Override
	public void add(int n) {
		values[size] = n; //add value to the list
		size++; //increment size
		if (size == values.length){ //if the list is full expand it
			resize();
		}
	}

	/* Inserts integer n at position index. Shifts the element currently at that 
	 * position (if any) and any subsequent elements to the right.  */
	@Override
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		if(checkIndex(index, size+1)) { //check if index is valid
			for (int i=size; i>index; i--) {
				values[i] = values[i-1]; //move every value one step right until index
			}
			values[index] = n; //place the new value at index
			size++; //increment size
			if (size == values.length) { //if the list is full expand it
				resize();
			}			
		}else {
			throw new IndexOutOfBoundsException("Highest index: " + size);
		}	
	}

	/* Remove integer at position index. */
	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		if(checkIndex(index, size)) { //check if index is valid
			for (int i=index; i<size; i++) {
				values[i] = values[i+1]; //move every value one step left until index (which is overwritten)
			}
			size--; //decrement size			
		}else {
			throw new IndexOutOfBoundsException("Highest index: " + size);
		}	
	}
	
	/* Get integer at position index. */
	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		if(checkIndex(index, size)) { //check if index is valid
			return values[index]; //return the value at index
		}else {
			throw new IndexOutOfBoundsException("Highest index: " + size);
		}	
	}

	/* Find position of integer n, otherwise return -1 */
	@Override
	public int indexOf(int n) {
		int returnInt = -1;
		for (int i=0; i<size; i++) {
			if(values[i] == n)
				returnInt = i;
		}
		return returnInt;
	}
	
}
