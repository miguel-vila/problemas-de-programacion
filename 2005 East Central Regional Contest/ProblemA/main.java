package ProblemA;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	static String[] insig;
	
	static boolean contains(String s)
	{
		for (int i = 0; i < insig.length; i++) 
			if(insig[i].equals(s))
				return true;
		return false;
	}
	
	static int count(char c,String s)
	{
		int v=0;
		for (int i = 0; i < s.length(); i++)
			if(s.charAt(i)==c)
				v++;
		return v;
	}
	
	static int cuantos(String acro, String orac)
	{
		ArrayList<String> split = new ArrayList<String>();
		String [] temp = orac.split(" ");
		for (int i = 0; i < temp.length; i++) 
			if(!contains(temp[i]))
				split.add(temp[i]);
		if(acro.length()!=split.size())
			return 0;
		else
		{
			int sal = 1;
			for (int i = 0; i < acro.length(); i++) {
				char c= acro.charAt(i);
				int cuantos = count(c, split.get(i)); 
				if(cuantos==0)
					return 0;
				else
					sal*=cuantos;
			}
			return sal;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
	}

}
