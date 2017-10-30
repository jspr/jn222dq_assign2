package jn222dq_assign2;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {

	/* Add integer at top of stack. */
	@Override
	public void push(int n) {
		for (int i=size; i>0; i--) {
			values[i] = values[i-1]; //move every value one step right
		}
		values[0] = n; //place the new value at the top
		size++; //increment size
		if (size == values.length) { //if the stack is full expand it
			resize();
		}
	}

	/* Returns and removes integer at top of stack  */
	@Override
	public int pop() throws IndexOutOfBoundsException {
		if(size > 0) { //check if the stack is empty
			int returnInt = values[0]; //the value to return
			for (int i=0; i<size; i++) {
				values[i] = values[i+1]; //move every value one step left
			}
			size--; //decrement size		
			return returnInt; //return the value at top
		}else {
			throw new IndexOutOfBoundsException("The stack is empty.");
		}
	}

	/* Returns without removing integer at top of stack */
	@Override
	public int peek() throws IndexOutOfBoundsException {
		if(size > 0) { //check if the stack is empty		
			return values[0]; //return the value at top
		}else {
			throw new IndexOutOfBoundsException("The stack is empty.");
		}
	}

}
