package assign6;

public class TestTree {

	public static void main(String[] args) {
		
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();

		tree.add(50);
		tree.add(20);
		tree.add(25);
		tree.add(26);

		tree.printSideways();
		System.out.println();
		System.out.println("*****Testing printLeaves*****");
		tree.printLeaves();
		System.out.println();
		System.out.println("*****Testing printPaths*****");
		tree.printPaths();
		System.out.println();
		System.out.println("*****Testing getSecondLargest*****");
		System.out.println(tree.getSecondLargest());
	
    }
}