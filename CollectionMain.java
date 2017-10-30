package jn222dq_assign2;

public class CollectionMain {

	public static void main(String[] args) {
		
		System.out.println("Creating an ArrayIntList object");
		ArrayIntList arrayIntList = new ArrayIntList();
		System.out.println("Adding 1-5 to the ArrayIntList");
		for (int i=1; i<=5; i++) {
			arrayIntList.add(i);
		}
		System.out.println("String representation of the ArrayIntList: " + arrayIntList);
		System.out.println("The element at index 3: " + arrayIntList.get(3));
		System.out.println("Find index of element 66 (-1 means it doesn't exist): " + arrayIntList.indexOf(66));
		System.out.println("Add 66 to index 2.");
		arrayIntList.addAt(66, 2);
		System.out.println("String representation of the ArrayIntList: " + arrayIntList);
		System.out.println("Find index of element 66: " + arrayIntList.indexOf(66));
		System.out.println("Remove element at index 1.");
		arrayIntList.remove(1);
		System.out.println("Find index of element 66: " + arrayIntList.indexOf(66));
		System.out.println("String representation of the ArrayIntList: " + arrayIntList);
		System.out.println("Trying to get element at index 42 (which does not exist)");
		try {
			arrayIntList.get(42);
		}catch(IndexOutOfBoundsException e) {
			System.out.println("IndexOutOfBoundsException caught: " + e.getMessage());
		}
		
		System.out.println();
		System.out.println();
		
		
		System.out.println("Creating an ArrayIntStack object");
		ArrayIntStack arrayIntStack = new ArrayIntStack();
		System.out.println("Adding 1-5 to the ArrayIntStack");
		for (int i=1; i<=5; i++) {
			arrayIntStack.push(i);
		}
		System.out.println("String representation of the ArrayIntStack: " + arrayIntStack);	
		System.out.println("Peeking at top element: " + arrayIntStack.peek());
		System.out.println("String representation of the ArrayIntStack: " + arrayIntStack);
		System.out.println("Popping top element: " + arrayIntStack.pop());
		System.out.println("String representation of the ArrayIntStack: " + arrayIntStack);
		System.out.println("Popping all elements:");
		while(!arrayIntStack.isEmpty()) {
			System.out.println(arrayIntStack.pop());
		}
		System.out.println("String representation of the ArrayIntStack: " + arrayIntStack);
		System.out.println("Trying to get pop an element from the empty stack");
		try {
			arrayIntStack.pop();
		}catch(IndexOutOfBoundsException e) {
			System.out.println("IndexOutOfBoundsException caught: " + e.getMessage());
		}
	}

}
