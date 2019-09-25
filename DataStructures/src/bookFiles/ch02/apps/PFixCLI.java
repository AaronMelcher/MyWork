//----------------------------------------------------------------------
// PFixCLI.java           by Dale/Joyce/Weems                  Chapter 2
//
// Evaluates postfix expressions entered by the user.
// Uses a command line interface.
//----------------------------------------------------------------------
package bookFiles.ch02.apps;

import java.util.*;

import bookFiles.ch02.postfix.PostFixEvaluator;
import bookFiles.ch02.postfix.*;

public class PFixCLI {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String expression = null; // expression to be evaluated
		final String STOP = "X"; // indicates end of input
		int result; // result of evaluation
		int smallest, largest, count = 0, total = 0;

		while (!STOP.equals(expression)) {
			// Get next expression to be processed.
			System.out.print("\nPostfix Expression (" + STOP + " to stop): ");
			expression = scan.nextLine();

			if (!STOP.equals(expression)) {
				// Obtain and output result of expression evaluation.
				String[] tokens = expression.split(" ");
				ArrayList<Integer> numbers = new ArrayList<Integer>();
				for (String token : tokens) {
					if (token.matches("-?\\d+"))
						numbers.add(Integer.parseInt(token));
				}
				largest = Integer.MIN_VALUE; //Sets largest to min int value
				smallest = Integer.MAX_VALUE; //Sets smallest to max int value

				for (int i : numbers) {
					if (i > largest)
						largest = i;
					if (i < smallest)
						smallest = i;
					total += i;
					count++;
				}

				try {
					result = PostFixEvaluator.evaluate(expression);
					// Output result.
					System.out.println("Result = " + result);
					System.out.println("****STATISTICS****");
					System.out.println("Largest: " + largest);
					System.out.println("Smallest: " + smallest);
					System.out.println("Count: " + count);
					System.out.println("Average: " + total / count);
					count = 0;
					total = 0;

				} catch (PostFixException error) {
					// Output error message.
					System.out.println("Error in expression - " + error.getMessage());
					System.out.println("****STATISTICS****");
					System.out.println("Largest: " + largest);
					System.out.println("Smallest: " + smallest);
					System.out.println("Count: " + count);
					try {  //Accounts for other exceptions with illegal symbols
						System.out.println("Average: " + total / count);
					} catch (ArithmeticException e) { 
						System.out.println("Average: 0.0" );
					}
					count = 0;
					total = 0;
				}
			}
		}
		scan.close();
	}
}
