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

	public T dequeueFront() throws QueueUnderflowException {
		DLLNode<T> temp = front;

		if (isEmpty())
			throw new QueueUnderflowException("Dequeue attempted on an empty deque");

		front = temp.getForward();
		temp.setForward(null);
		numElements--;
		return temp.getInfo();
	}

	public T dequeueRear() throws QueueUnderflowException {
		DLLNode<T> temp = rear;

		if (isEmpty())
			throw new QueueUnderflowException("Dequeue attempted on an empty deque");

		rear = temp.getBack();
		temp.setBack(null);
		numElements--;
		return temp.getInfo();
	}

	public boolean isFull() {
		return false;
	}

	public boolean isEmpty() {
		if (front == null && rear == null)
			return true;
		return false;
	}

	public int size() {
		return numElements;
	}

	public String toString() {
		if (isEmpty()) {
			return "";
		}
		DLLNode<T> node = front;
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
