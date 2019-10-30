//----------------------------------------------------------------------
// PostFixEvaluator.java       by Dale/Joyce/Weems             Chapter 2
//
// Provides a postfix expression evaluation.
//----------------------------------------------------------------------

package bookFiles.ch02.postfix;

import bookFiles.ch02.stacks.*;
import java.util.*;

public class PostFixEvaluator {
	public static int evaluate(String expression) {
		@SuppressWarnings("resource")
		Scanner tokenizer = new Scanner(expression);
		StackInterface<Integer> stack = new ArrayListStack<Integer>();

		int value;
		String operator;
		int operand1, operand2;
		int result = 0;

		while (tokenizer.hasNext()) {
			if (tokenizer.hasNextInt()) {
				// Process operand.
				value = tokenizer.nextInt();
				if (stack.isFull())
					throw new PostFixException("Too many operands-stack overflow");
				stack.push(value);
			} else {
				// Process operator.
				operator = tokenizer.next();

				// Check for illegal symbol
				if (!(operator.equals("/") || operator.equals("*") || operator.equals("+") || operator.equals("-")
						|| operator.equals("^")))
					throw new PostFixException("Illegal symbol: " + operator);

				// Obtain second operand from stack.
				if (stack.isEmpty())
					throw new PostFixException("Not enough operands-stack underflow");
				operand2 = stack.top();
				stack.pop();

				// Obtain first operand from stack.
				if (stack.isEmpty())
					throw new PostFixException("Not enough operands-stack underflow");
				operand1 = stack.top();
				stack.pop();

				// Perform operation.
				if (operator.equals("/") && operand2 == 0) // Test for divide by 0 error -> will not end the program
					throw new PostFixException("Illegal divide by 0");
				else if (operator.equals("/"))
					result = operand1 / operand2;
				else if (operator.equals("*"))
					result = operand1 * operand2;
				else if (operator.equals("+"))
					result = operand1 + operand2;
				else if (operator.equals("-"))
					result = operand1 - operand2;
				else if (operator.equals("^")) // Returns the greater of the 2 numbers, return operand1 if they're equal
					if (operand1 > operand2)
						result = operand1;
					else if (operand2 > operand1)
						result = operand2;
					else if (operand2 == operand1)
						result = operand1;

				// Push result of operation onto stack.
				stack.push(result);
			}
		}

		// Obtain final result from stack.
		if (stack.isEmpty())
			throw new PostFixException("Not enough operands-stack underflow");
		result = stack.top();
		stack.pop();

		// Stack should now be empty.
		if (!stack.isEmpty())
			throw new PostFixException("Too many operands-operands left over");

		// Return the final.
		return result;
	}
}