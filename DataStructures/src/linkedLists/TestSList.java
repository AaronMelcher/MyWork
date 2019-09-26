package linkedLists;

public class TestSList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SList<String> myList = new SList<String>();
		myList.add("A");
		myList.add("B");
		myList.add("C");
		myList.add("D");
		myList.add("E");
		System.out.println(myList.toString());
		myList.removeFirst();
		System.out.println(myList.toString());
		myList.remove("C");
		System.out.println(myList.toString());
	}
}
