package jn222dq_assign2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSizeAndIsEmpty() {
		GenericLinkedQueue<Integer> genericLinkedQueue = new GenericLinkedQueue<Integer>();
		
		assertEquals(0,genericLinkedQueue.size()); //checking the size
		assertTrue(genericLinkedQueue.isEmpty()); //checking isEmpty
		
		genericLinkedQueue.enqueue(1);//adding a single integer
		assertEquals(1,genericLinkedQueue.size()); //checking the size
		assertTrue(!genericLinkedQueue.isEmpty()); //checking isEmpty
		
		genericLinkedQueue = addIntegersToQueue(1,10);//adding 10 integers
		assertEquals(10,genericLinkedQueue.size()); //checking the size
		assertTrue(!genericLinkedQueue.isEmpty()); //checking isEmpty
	}
	
	@Test
	public void testEnqueue() {
		GenericLinkedQueue<Integer> genericLinkedQueue = new GenericLinkedQueue<Integer>();
		
		genericLinkedQueue.enqueue(1);//adding a single integer
		assertEquals(1,genericLinkedQueue.size()); //checking the size
		assertEquals(new Integer(1),genericLinkedQueue.first()); //checking the first element
		assertEquals(new Integer(1),genericLinkedQueue.last()); //checking the last element

		genericLinkedQueue = addIntegersToQueue(1,10);//adding 10 integers
		assertEquals(10,genericLinkedQueue.size()); //checking the size
		assertEquals(new Integer(1),genericLinkedQueue.first()); //checking the first element
		assertEquals(new Integer(10),genericLinkedQueue.last()); //checking the last element
		
		genericLinkedQueue = addIntegersToQueue(1,100000);//adding 100 000 integers
		assertEquals(100000,genericLinkedQueue.size()); //checking the size
		assertEquals(new Integer(1),genericLinkedQueue.first()); //checking the first element
		assertEquals(new Integer(100000),genericLinkedQueue.last()); //checking the last element
	}
	
	@Test
	public void testDequeueAndFirst() {
		GenericLinkedQueue<Integer> genericLinkedQueue = new GenericLinkedQueue<Integer>();

		genericLinkedQueue = addIntegersToQueue(1,10);//adding 10 integers
		for(int i=1,j=9; i<=10; i++,j--) {
			assertEquals(new Integer(i),genericLinkedQueue.first()); //checking first
			assertEquals(new Integer(i),genericLinkedQueue.dequeue()); //checking dequeue
			assertEquals(j,genericLinkedQueue.size()); //checking size
		}
		
		//test first exception with and empty queue
		boolean res = false;
		try {genericLinkedQueue.first();}
		catch(IndexOutOfBoundsException e) {res = true;}
		assertTrue(res);
		
		//test dequeue exception with and empty queue
		res = false;
		try {genericLinkedQueue.dequeue();}
		catch(IndexOutOfBoundsException e) {res = true;}
		assertTrue(res);		
	}
	
	@Test
	public void testLast() {
		GenericLinkedQueue<Integer> genericLinkedQueue = new GenericLinkedQueue<Integer>();

		genericLinkedQueue.enqueue(1);//adding a single integer
		assertEquals(new Integer(1),genericLinkedQueue.last()); //checking last
		
		genericLinkedQueue.enqueue(2);//adding another integer
		assertEquals(new Integer(2),genericLinkedQueue.last()); //checking last
		
		genericLinkedQueue.dequeue();//removing an integer
		assertEquals(new Integer(2),genericLinkedQueue.last()); //checking last
		
		genericLinkedQueue.dequeue();//removing an integer
		
		//test last exception with and empty queue
		boolean res = false;
		try {genericLinkedQueue.last();}
		catch(IndexOutOfBoundsException e) {res = true;}
		assertTrue(res);		
	}
	
	@Test
	public void testIterator() {
		GenericLinkedQueue<Integer> genericLinkedQueue = new GenericLinkedQueue<Integer>();

		//iterating over an empty queue
		int numberOfIterations = 0;
		for(Integer element : genericLinkedQueue) {
			assertEquals(new Integer(numberOfIterations+1),element);
			numberOfIterations++;
		}
		assertEquals(0,numberOfIterations);
		
		genericLinkedQueue = addIntegersToQueue(1,10);//adding 10 integers
		//iterating over a queue with 10 elements
		numberOfIterations = 0;
		for(Integer element : genericLinkedQueue) {
			assertEquals(new Integer(numberOfIterations+1),element);
			numberOfIterations++;
		}
		assertEquals(10,numberOfIterations);
		
		genericLinkedQueue = addIntegersToQueue(1,100000);//adding 100 000 integers
		//iterating over a queue with 100 000 elements
		numberOfIterations = 0;
		for(Integer element : genericLinkedQueue) {
			assertEquals(new Integer(numberOfIterations+1),element);
			numberOfIterations++;
		}
		assertEquals(100000,numberOfIterations);		
	}
	
	private GenericLinkedQueue<Integer> addIntegersToQueue(int min, int max) {
		GenericLinkedQueue<Integer> genericLinkedQueue = new GenericLinkedQueue<Integer>();
		for(int i=min; i<=max; i++ ) {
			genericLinkedQueue.enqueue(i);
		}
		return genericLinkedQueue;
	}

}
