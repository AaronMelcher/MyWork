package assign6;

import java.util.Iterator;

public class TestTree {

	public static void main(String[] args) {
		
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
	    Iterator<Integer> iter;

		
		tree.add(50);
		tree.add(40);
		tree.add(30);
		tree.add(45);
		tree.add(60);
		tree.add(90);
		tree.add(80);
		tree.add(100);
		
        tree.printSideways();
        
        tree.printLeaves();
		
		 iter = tree.getIterator(BSTInterface.Traversal.Inorder);
		 while (iter.hasNext())
			 System.out.print(iter.next()+" ");
    }
}