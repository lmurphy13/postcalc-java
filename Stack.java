/**
 * Stack implementation in Java
 * @author Liam M. Murphy
 */

public class Stack {
	public final int MAXSIZE = 20;				/* Maximum size of stack */
	public char[] data;						/* Char array representing stack */
	public int top;							/* Index of top of stack */

	public Stack() {
		this.data = new char[MAXSIZE];		/* data initalized to MAXSIZE */
		this.top = -1;						/* top is -1 by default */
	}

	public void push(char element) {
		if(!this.isFull()) {
			this.top++;
			this.data[this.top] = element;
		} else {
			System.err.println("Cannot push onto full stack!");
		}
	}

	public char pop() {
		if(!this.isEmpty()) {
			char temp = this.data[this.top];
			this.top--;
			return temp;
		} else {
			System.err.println("Cannot pop from empty stack!");
		}
		return '~';
	}

	public char peek() {
		if(!this.isEmpty())
			return this.data[top];
		else
			System.err.println("Cannot peek at empty stack!");
		return '~';
	}

	public boolean isFull() {
		if(this.top == MAXSIZE - 1)
			return true;
		return false;
	}

	public boolean isEmpty() {
		if(this.top == -1)
			return true;
		return false;
	}


	public static void main(String[] args) {

		/* Testing Stack methods */

		Stack s = new Stack();
		Stack ns = new Stack();
		s.push('h');
		s.push('e');
		s.push('l');
		s.push('l');
		s.push('o');

		while(!s.isEmpty()) {
			ns.push(s.pop());
		}

		System.out.println(ns.peek());

		System.out.println(ns.data);

		while(!ns.isEmpty()) {
			ns.push('a');
		}
	}





}
