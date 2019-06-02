/**
 * Expression Parser for easier use with Stack
 * @author Liam M. Murphy
 */

public class ExpParser {
	
	public char[] splitString(String exp) {
		char[] chars = new char[exp.length()];
		int counter = 0;
		
		for(int i = 0; i < exp.length(); i++) {
			if(exp.charAt(i) !=  ' ') {
				chars[counter] = exp.charAt(i);
				counter++;
			}
		}

		return chars;
	}

	public char[] extractOperators(char[] exp) {
		char[] operators = new char[exp.length];
		int counter = 0;

		for(int i = 0; i < exp.length; i++) {
			if(exp[i] == '+' || exp[i] == '-' || exp[i] == '*' || exp[i] == '/') {
				operators[counter] = exp[i];
				counter++;
			}
		}

		return operators;
	}

	public char[] extractOperands(char[] exp) {
		char[] operands = new char[exp.length];
		int counter = 0;

		for(int i = 0; i < exp.length; i++) {
			if(exp[i] != '+' && exp[i] != '-' && exp[i] != '*' && exp[i] != '/') {
				operands[counter] = exp[i];
				counter++;
			}
		}

		return operands;
	}


	public static void main(String[] args) {

		/* Testing ExpParser methods */
		
		ExpParser p = new ExpParser();

		System.out.println(p.splitString("Hello world!"));

		char[] exp = p.splitString("2 2 +");

		System.out.println(p.extractOperands(exp));
		System.out.println(p.extractOperators(exp));


	}
}