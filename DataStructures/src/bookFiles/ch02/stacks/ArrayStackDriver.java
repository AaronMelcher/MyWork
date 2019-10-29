package bookFiles.ch02.stacks;

public class ArrayStackDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayBoundedStack<?> stack = new ArrayBoundedStack<Integer>();
		stack.push(null);
		stack.push(null);
		stack.push(null);
		
		stack.remove(2);
		System.out.println(stack.top());
		stack.clear();
		System.out.println(stack.top());
	}
}
