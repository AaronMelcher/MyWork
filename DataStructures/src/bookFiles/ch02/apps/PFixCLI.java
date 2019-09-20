//----------------------------------------------------------------------
// PFixCLI.java           by Dale/Joyce/Weems                  Chapter 2
//
// Evaluates postfix expressions entered by the user.
// Uses a command line interface.
//----------------------------------------------------------------------
package bookFiles.ch02.apps;

import java.util.Scanner;

import bookFiles.ch02.postfix.PostFixEvaluator;
import bookFiles.ch02.postfix.*;

public class PFixCLI {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Scanner inputs;

		String expression = null; // expression to be evaluated
		final String STOP = "X"; // indicates end of input
		int result; // result of evaluation
		int smallest, largest, count = 0, total = 0, num;

		while (!STOP.equals(expression)) {
			// Get next expression to be processed.
			System.out.print("\nPostfix Expression (" + STOP + " to stop): ");
			expression = scan.nextLine();

			if (!STOP.equals(expression)) {
				// Obtain and output result of expression evaluation.
				try {
					result = PostFixEvaluator.evaluate(expression);
					inputs = new Scanner(expression);
					largest = inputs.nextInt();
					smallest = largest;
					count++;
					total += largest;
					while (inputs.hasNext()) {
						if (inputs.hasNextInt()) {
							num = inputs.nextInt();
							if (num > largest)
								largest = num;
							else if (num < smallest)
								smallest = num;
							total += num;
							count++;
						}
					}

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
				}
			}
		}
		scan.close();
	}
}
