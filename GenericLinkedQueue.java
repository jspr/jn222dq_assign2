package jn222dq_assign2;

import java.util.Iterator;

public class GenericLinkedQueue<T> implements Queue<T>, Iterable<T>{
	
	private int size = 0; //Current size
	private Node head = null; //First node/element
	private Node tail = null; //Last node/element
	
	private class Node { // Private inner Node class
		T value; //value contained
		Node next = null; //the next node
		Node previous = null; //the previous node
		Node(T value){ //constructor
			this.value = value;
		}
	}

	// current queue size 
	@Override
	public int size() {
		return size;
	}

	// true if queue is empty 
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	// add element at end of queue 
	@Override
	public void enqueue(T element) {
		Node node = new Node(element);
		if(size == 0) { //this is the first node
			head = node;
			tail = node;
		}else { //this is not the first node so the current tail must be changed
			tail.next = node;
			node.previous = tail;
			tail = node;	
		}
		size++;	
	}

	// return and remove first element
	@Override
	public T dequeue() throws IndexOutOfBoundsException {
		Node returnNode = null;
		if(size == 0) { //if the queue is empty
			throw new IndexOutOfBoundsException("The queue is empty.");
		}else {
			returnNode = head;
			if(size == 1) { //the last node is removed
				head = null;
				tail = null;
			}else { //if more nodes exist another node will be the first in the queue
				head = returnNode.next;
				returnNode.next.previous = null;
			}
			size--;
		}
		return returnNode.value;
	}

	// return (without removing) first element 
	@Override
	public T first() throws IndexOutOfBoundsException {
		Node returnNode = null;
		if(size == 0)
			throw new IndexOutOfBoundsException("The queue is empty.");
		else
			returnNode = head;
		return returnNode.value;
	}

	// return (without removing) last element 
	@Override
	public T last() throws IndexOutOfBoundsException {
		Node returnNode = null;
		if(size == 0)
			throw new IndexOutOfBoundsException("The queue is empty.");
		else
			returnNode = tail;
		return returnNode.value;
	}
	
	//we should be able to iterate over the queue
	@Override
	public Iterator<T> iterator() {return new QueueIterator();}
	
	private class QueueIterator implements Iterator<T> {	
		private Node currentNode = head;
		public T next() {
				if(currentNode != null) {
				Node returnNode = currentNode;
				currentNode = currentNode.next;
				return returnNode.value;
			}
			else
				throw new IndexOutOfBoundsException("The queue is empty.");
		}	
		public boolean hasNext() {return currentNode != null;}		
		public void remove() {throw new RuntimeException("remove() is not implemented");}
	}

}
