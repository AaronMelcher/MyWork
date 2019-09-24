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
	 * Moves through the linked list to add element to the end of list 
	 * Time complexity = O(n)
	 * 
	 */
	public void insetLast(T element) {
		if (list == null) {
			this.add(element);
		} else {
			LLNode<T> node = new LLNode<T>(element);
			LLNode<T> deepest = list;
			while (deepest.getLink() != null)
				deepest = deepest.getLink();
			deepest.setLink(node);
		}
	}

	//
	public boolean equals(Object other) {
		return this.toString().equals(other.toString());
	}

}
