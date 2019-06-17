import java.util.Scanner;
import java.util.Arrays;

public class Calc {
	public static Stack stack = new Stack();


	public static void main(String[] args) {
		char[] expression = inputExp();		/* Get expression input and parse into array */

		int answer = evaluate(expression);

		System.out.printf("Answer: %f\n", answer);

	}

	public static char[] inputExp() {
		Scanner in = new Scanner(System.in);
		ExpParser pars = new ExpParser();
		
		System.out.print("Enter expression: ");
		String exp = in.next();

		return pars.splitString(exp);
	}

	public static int evaluate(char[] exp) {
		int total;
		int result;
		char[] operators = {'+', '-', '*', '/', '%'};

		for (char token : exp) {
			if (contains(operators, token)) {
				int op2 = Integer.parseInt(stack.pop()).charAt(0);
				int op1 = Integer.parseInt(stack.pop());
				switch (token) {
					case '+':	result = (op1 + op2);	break;
					case '-':	result = (op1 - op2);	break;
					case '*':	result = (op1 * op2);	break;
					case '/':	result = (op1 / op2);	break;
					case '%':	result = (op1 % op2);	break;
				}
				stack.push(Integer.toString(result).charAt(0));
			} else {
				stack.push(token);
			}
		}

		total = stack.pop();
		return total;
	}

	public static boolean contains(char[] array, char value) {
		for (char v : array) {
			if (v == value)
				return true;
		}
		return false;
	}
}
