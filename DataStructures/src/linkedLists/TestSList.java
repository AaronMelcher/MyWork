package linkedLists;

public class TestSList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SList<String> myList = new SList<String>();
		myList.add("A");
		myList.add("B");
		myList.add("C");
		myList.add("E");
		myList.insetLast("D");
		System.out.println(myList);
		System.out.println(myList.equals(myList));
	}
}
