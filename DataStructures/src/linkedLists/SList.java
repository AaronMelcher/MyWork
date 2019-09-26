package linkedLists;

import bookFiles.support.LLNode;

public class SList<T> {
	protected LLNode<T> list;
	protected int numElements;

	public SList() {
		numElements = 0;
		list = null;
	}

	public LLNode<T> getList() {
		return list;
	}

	public void setList(LLNode<T> list) {
		this.list = list;
	}

	public int getNumElements() {
		return numElements;
	}

	public void setNumElements(int numElements) {
		this.numElements = numElements;
	}

	// adds the element to the front of the list
	public void add(T element) {
		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(list);
		list = newNode;
		numElements++;
	}

	public String toString() {
		LLNode<T> node = list;
		String result = "";
		while (node != null) {
			result += node.getInfo();
			result += "-->";
			node = node.getLink();
		}
		result = result.substring(0, result.length() - 3);
		return result;
	}

	/*
	 * Moves through the linked list to add element to the end of list and adds the
	 * LLNode newNode to the end of the linked list Time complexity = O(n)
	 * 
	 */
	public void insertLast(T element) {
		if (list == null) {
			this.add(element);
		} else {
			LLNode<T> newNode = new LLNode<T>(element);
			LLNode<T> last = list;
			while (last.getLink() != null) { // Goes through the entire linked list until the link is equal to null
				last = last.getLink();
			}
			last.setLink(newNode);
			numElements++;
		}
	}

	public boolean equals(Object other) {
		if (other == null)
			return false;
		return this.toString().equals(other.toString());

	}

	public void removeFirst() {
		list = list.getLink();
		numElements++;
	}

	public void remove(T element) {
		LLNode<T> currentNode = list;
		if (currentNode.getInfo().equals(element)) {
			list = currentNode.getLink();
			return;
		}
		while (!(currentNode.getLink().getInfo().equals(element))) {
			currentNode = currentNode.getLink();
		}
		LLNode<T> nodeToRemove = currentNode.getLink();
		currentNode.setLink(nodeToRemove.getLink());
	}

}
