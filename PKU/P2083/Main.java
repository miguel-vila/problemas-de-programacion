package P2083;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static char[] add(char [] a, char [] b)
	{
		char [] c= new char [a.length+b.length];
		for (int i = 0; i < a.length; i++) 
			c[i] = a[i];
		for (int i = 0; i < b.length; i++)
			c[a.length+i]=b[i];
		return c;               
	}
	
	static char [][] ant;
	
	static char[][] next()
	{
		char[][] next = new char[3*ant.length][1];
		
		char[] vac = new char[ant.length];
		
		for (int i = 0; i < vac.length; i++)
			vac[i]=' ';
		
		for (int i = 0; i < ant.length; i++) {
			char [] b= add(vac,ant[i]);
			char [] a= new char[ant.length];
			
			for (int j = 0; j < ant[i].length; j++)
				a[j]=ant[i][j];
			
			for (int j = ant[i].length; j < a.length; j++) 
				a[j]=' ';
			
			char [] c = add(a,b); 
			next[i] = c;
			next[i+ant.length] = b;
			next[i+2*ant.length] = c;
		}
		
		return next;
	}
	
	static void print()
	{
		for (int i = 0; i < ant.length; i++){
			System.out.println(ant[i]);
		}
	}
	public static void main(String[] args) throws IOException {
		/**
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> casos = new ArrayList<Integer>();
		int max = Integer.MIN_VALUE;
		while(true)
		{
			String c= br.readLine();
			int n=Integer.parseInt(c);
			if(n==-1)
				break;
			casos.add(n);
			if(n>max)
				max=n;
		}
		
		**/
		
		
		char [][] a={{'X'}};
		ant = a;
		for (int i = 0; i < 7; i++) {
			ant = next();
		}

		System.out.println();
		
		print();
	}

}
