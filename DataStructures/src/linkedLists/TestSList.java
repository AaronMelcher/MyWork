package linkedLists;

public class TestSList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SList<String> myList = new SList<String>();
		myList.add("A");
		myList.add("B");
		myList.insertLast("C");
		myList.add("D");
		myList.insertLast("E");
		System.out.println(myList);
		SList<String> newList = new SList<String>();
		newList.add("E");
		newList.add("D");
		newList.insertLast("C");
		newList.add("B");
		newList.insertLast("A");
		System.out.println(newList.toString());
		System.out.println(myList.equals(newList));
	}
}
