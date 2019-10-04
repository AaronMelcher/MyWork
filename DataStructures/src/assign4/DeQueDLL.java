package assign4;

import bookFiles.ch04.queues.*;
import bookFiles.support.DLLNode;

public class DeQueDLL<T> implements DequeInterface<T> {
	
	protected DLLNode<T> front, rear;      // reference to the front and rear of this deque
	protected int numElements = 0; 			// number of elements in this deque

	public DeQueDLL() {
		front = null;
		rear = null;
	}

	public void enqueueFront(T element) {
		// TODO Auto-generated method stub
		
	}

	public void enqueueRear(T element) {
		// TODO Auto-generated method stub
		
	}

	public T dequeueFront() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		return null;
	}

	public T dequeueRear() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
