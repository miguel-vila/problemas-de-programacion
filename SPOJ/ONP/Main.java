package ONP;

import java.util.ArrayList;
import java.util.Stack;

public class Main {

	static int value(char c){
		switch (c) {
			case '+':
				return 0;
			case '-':
				return 1;
			case '*':
				return 2;
			case '/':
				return 3;
		}
		return 4;
	}
	
	static boolean mayor(char a, char b)
	{
		return value(a)-value(b)>0;
	}
	
	static String postfix(String s){
		String out ="";
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c!='(' && c!=')')
			{
				if('a'<=c && c<='z')
				{
					out+=c;
				}
				else
				{
					if(stack.empty())
						stack.push(c);
					else{
						if(mayor(c,stack.lastElement()))
						{
							out+=stack.pop();
							stack.push(c);
						}
						else
						{
							while(!mayor(c,stack.lastElement()))
							stack.push(c);
						}
					}
				}
			}
		}
		while(!stack.empty())
			out+=stack.pop();
		return out;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(postfix("(a+t)*((b+(a+c))^(c+d))"));
	}

}
