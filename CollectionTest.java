package jn222dq_assign2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CollectionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddAndGet() {
		ArrayIntList arrayIntList = new ArrayIntList();
		
		arrayIntList.add(42); //adding a single integer
		assertEquals(1,arrayIntList.size()); //checking the size
		assertEquals(42,arrayIntList.get(0)); //checking the value
		
		arrayIntList = addIntegersToList(4,13); //adding 10 integers
		assertEquals(10,arrayIntList.size()); //checking the size
		//checking the values
		for(int i=0; i<10; i++) {
			assertEquals(i+4,arrayIntList.get(i));
		}
		
		arrayIntList = addIntegersToList(1,100000); //adding 100 000 integers
		assertEquals(100000,arrayIntList.size()); //checking the size
		//checking the values
		for(int i=0; i<100000; i++) {
			assertEquals(i+1,arrayIntList.get(i));
		}
		
		//test exception with negative value
		boolean res = false;
		try {arrayIntList.get(-1);}
		catch(IndexOutOfBoundsException e) {res = true;}
		assertTrue(res);
		
		//test exception with to large value
		res = false;
		try {arrayIntList.get(100000);}
		catch(IndexOutOfBoundsException e) {res = true;}
		assertTrue(res);
	}
	
	@Test
	public void testAddAt() {
		ArrayIntList arrayIntList = new ArrayIntList();
		arrayIntList = addIntegersToList(1,10); //adding 10 integers
		
		//testing to add at the start of the list
		arrayIntList.addAt(20,0);
		assertEquals(11,arrayIntList.size()); //checking the size
		assertEquals(20,arrayIntList.get(0)); //checking the value of the added element
		assertEquals(1,arrayIntList.get(0+1)); //checking the value of the element to the right
		assertEquals(10,arrayIntList.get(9+1)); //checking the value of the last element
		
		//testing to add at the middle of the list
		arrayIntList.addAt(30,5);
		assertEquals(12,arrayIntList.size()); //checking the size
		assertEquals(30,arrayIntList.get(5)); //checking the value of the added element
		assertEquals(5,arrayIntList.get(5+1)); //checking the value of the element to the right
		assertEquals(10,arrayIntList.get(9+2)); //checking the value of the last element
		
		//testing to add at the end of the list
		arrayIntList.addAt(40,12);
		assertEquals(13,arrayIntList.size()); //checking the size
		assertEquals(40,arrayIntList.get(12)); //checking the value of the added element
		assertEquals(10,arrayIntList.get(11)); //checking the value of the element to the left
		
		//test exception with negative value
		boolean res = false;
		try {arrayIntList.addAt(50,-1);}
		catch(IndexOutOfBoundsException e) {res = true;}
		assertTrue(res);
		
		//test exception with to large value
		res = false;
		try {arrayIntList.addAt(50,14);}
		catch(IndexOutOfBoundsException e) {res = true;}
		assertTrue(res);
	}
	
	@Test
	public void testRemove() {
		ArrayIntList arrayIntList = new ArrayIntList();
		arrayIntList = addIntegersToList(1,10); //adding 10 integers
		
		//testing to remove at the start of the list
		arrayIntList.remove(0);
		assertEquals(9,arrayIntList.size()); //checking the size
		assertEquals(2,arrayIntList.get(0)); //checking the value of the first element
	
		//testing to remove at the middle of the list
		arrayIntList.remove(4);
		assertEquals(8,arrayIntList.size()); //checking the size
		assertEquals(7,arrayIntList.get(4)); //checking the value of the element at the remove index
		
		//removing all elements
		for(int i=7; i>=0; i--) {
			arrayIntList.remove(0);
			assertEquals(i,arrayIntList.size()); //checking the size
		}
		
		//test exception with negative value
		boolean res = false;
		try {arrayIntList.remove(-1);}
		catch(IndexOutOfBoundsException e) {res = true;}
		assertTrue(res);
		
		//test exception with an empty list
		res = false;
		try {arrayIntList.remove(0);}
		catch(IndexOutOfBoundsException e) {res = true;}
		assertTrue(res);
	}
	
	@Test
	public void testIndexOf() {
		ArrayIntList arrayIntList = new ArrayIntList();
		arrayIntList = addIntegersToList(1,10); //adding 10 integers
		
		assertEquals(0,arrayIntList.indexOf(1)); //testing with the first value
		assertEquals(4,arrayIntList.indexOf(5)); //testing with a value in the middle
		assertEquals(9,arrayIntList.indexOf(10)); //testing with the last value
		assertEquals(-1,arrayIntList.indexOf(11)); //testing with a value that doesn't exist
	}
	
	@Test
	public void testPush() {
		ArrayIntStack arrayIntStack = new ArrayIntStack();
		
		arrayIntStack.push(42); //adding a single integer
		assertEquals(1,arrayIntStack.size()); //checking the size
		assertEquals(42,arrayIntStack.peek()); //checking the value
			
		arrayIntStack = addIntegersToStack(1,10); //adding 10 integers
		assertEquals(10,arrayIntStack.size()); //checking the size	
	}
	
	@Test
	public void testPopAndPeek() {
		ArrayIntStack arrayIntStack = new ArrayIntStack();
			
		arrayIntStack = addIntegersToStack(1,10); //adding 10 integers
		//peeking at and popping all elements
		for(int i=10; i>0; i--) {
			assertEquals(i,arrayIntStack.peek()); //peeking
			assertEquals(i,arrayIntStack.pop()); //popping
			assertEquals(i-1,arrayIntStack.size()); //checking the size
		}
		
		//test peeking exception with and empty stack
		boolean res = false;
		try {arrayIntStack.peek();}
		catch(IndexOutOfBoundsException e) {res = true;}
		assertTrue(res);
		
		//test popping exception with and empty stack
		res = false;
		try {arrayIntStack.pop();}
		catch(IndexOutOfBoundsException e) {res = true;}
		assertTrue(res);
	}
	
	private ArrayIntList addIntegersToList(int min, int max) {
		ArrayIntList arrayIntList = new ArrayIntList();
		for(int i=min; i<=max; i++ ) {
			arrayIntList.add(i);
		}
		return arrayIntList;
	}
	
	private ArrayIntStack addIntegersToStack(int min, int max) {
		ArrayIntStack arrayIntStack = new ArrayIntStack();
		for(int i=min; i<=max; i++ ) {
			arrayIntStack.push(i);
		}
		return arrayIntStack;
	}

}
