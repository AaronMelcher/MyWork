package assign4;

import bookFiles.ch04.queues.*;
import bookFiles.support.DLLNode;

public class DeQueDLL<T> implements DequeInterface<T> {

	protected DLLNode<T> front, rear; // reference to the front and rear of this deque
	protected int numElements = 0; // number of elements in this deque

	public DeQueDLL() {
		front = null;
		rear = null;
	}

	/**
	 * Adds elements to the front of the deque
	 */
	public void enqueueFront(T element) {
		DLLNode<T> newNode = new DLLNode(element);

		if (isEmpty()) {
			front = newNode;
			rear = newNode;
		} else {
			front.setBack(newNode);
			newNode.setForward(front);
			front = newNode;
		}
		numElements++;
	}

	/**
	 * Adds element to the rear of deque
	 */
	public void enqueueRear(T element) {
		DLLNode<T> newNode = new DLLNode(element);

		if (isEmpty()) {
			front = newNode;
			rear = newNode;
		} else {
			rear.setForward(newNode);
			newNode.setBack(rear);
			rear = newNode;
		}
		numElements++;
	}

	/**
	 * Removes the current front node of deque
	 */
	public T dequeueFront() throws QueueUnderflowException {
		DLLNode<T> temp = front;

		if (isEmpty())
			throw new QueueUnderflowException();
		if (front == rear) {
			front.setForward(null);
			front = null;
			rear.setBack(null);
			rear = null;
			numElements--;
			return temp.getInfo();
		} else {
			front = temp.getForward();
			temp.setForward(null);
			numElements--;
			return temp.getInfo();
		}
	}

	/**
	 * Removes the current rear node of deque
	 */
	public T dequeueRear() throws QueueUnderflowException {
		DLLNode<T> temp = rear;
		if (isEmpty())
			throw new QueueUnderflowException();
		if (front == rear) {
			front.setForward(null);
			front = null;
			rear.setBack(null);
			rear = null;
			numElements--;
			return temp.getInfo();
		} else {
			rear = temp.getBack();
			temp.setBack(null);
			numElements--;
			return temp.getInfo();
		}
	}

	/**
	 * Returns false, linked list has no limit
	 */
	public boolean isFull() {
		return false;
	}

	/**
	 * Returns true if front and rear equal null, else returns false
	 */
	public boolean isEmpty() {
		return numElements == 0;
	}

	/**
	 * Returns the number of elements in the deque
	 */
	public int size() {
		return numElements;
	}

	/**
	 * Returns a string representation of the deque
	 */
	public String toString() {
		if (isEmpty()) {
			return "";
		}
		DLLNode<T> node;
		if(front != null)
		node = front;
		else
		node = rear;
		String result = "";
		while (node != null) {
			result += node.getInfo();
			result += "<-->";
			node = (DLLNode<T>) node.getForward();
		}

		result = result.substring(0, result.length() - 4);
		return result;
	}
}
