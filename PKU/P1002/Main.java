package P1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class Main {

	public static class pair implements Comparable<pair>
	{
		String s;
		int v;
		public pair(String s, int v) {
			this.s = s;
			this.v = v;
		}
	
		public int compareTo(pair o) {
			return s.compareTo(o.s);
		}
		
	}
	
	public static int map(char c)
	{
		switch(c)
		{
		case('A'):
		case('B'):
		case('C'):
			return 2;
		case('D'):
		case('E'):
		case('F'):
			return 3;
		case('G'):
		case('H'):
		case('I'):
			return 4;
		case('J'):
		case('K'):
		case('L'):
			return 5;
		case('M'):
		case('N'):
		case('O'):
			return 6;
		case('P'):
		case('R'):
		case('S'):
			return 7;
		case('T'):
		case('U'):
		case('V'):
			return 8;
		}
		return 9;	
	}
	
	public static String standard(String s)
	{
		String standard ="";
		for (int i = 0; i < s.length(); i++) 
		{
			if(standard.length()==3)
				standard+='-';
			if(s.charAt(i)!='-' && s.charAt(i)!='Q' && s.charAt(i)!='Z')
			{
				if(s.charAt(i)>='0' && s.charAt(i)<='9')
					standard+=s.charAt(i);
				if(s.charAt(i)>='A' && s.charAt(i)<='Y')
					standard+=map(s.charAt(i));
			}
		}
		return standard;
	}
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
		int casos=Integer.parseInt(b.readLine());
		Hashtable<String, Integer> h= new Hashtable<String, Integer>();
		for (int i = 0; i < casos; i++) 
		{
			String pal=standard(b.readLine());
			if(!h.containsKey(pal))
				h.put(pal, 1);
			else
			{
				int vec=h.get(pal)+1;
				h.remove(pal);
				h.put(pal, vec);
			}
		}
		b.close();
		
		ArrayList<pair> pals= new ArrayList<pair>();
		
		for(String s: h.keySet())
			if(h.get(s)>1)
				pals.add(new pair(s, h.get(s)));
		
		if(pals.size()==0)
			System.out.println("No duplicates. ");
		else
		{
			Collections.sort(pals);
			for (int i = 0; i <pals.size(); i++) 
			{
				if(pals.get(i).v>1)
						System.out.print(pals.get(i).s+' '+pals.get(i).v+'\n');
			}
		}
	}

}
