package assign6;

import java.util.Iterator;

public class TestTree {

	public static void main(String[] args) {
		
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();

		
		tree.add(50);
		tree.add(40);
		tree.add(30);
		tree.add(45);
		tree.add(60);
		tree.add(90);
		tree.add(80);
		tree.add(100);
		tree.add(95);

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