package P2731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

	static String [] insig;
	static ArrayList<String> acron;
	static String acronym;
	/**
	 * @param args
	 */
	
	static boolean insignificante(String s)
	{
		for (int i = 0; i < insig.length; i++)
			if(insig[i].equals(s))
				return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		while(n!=0)
		{
			insig = new String[n];
			for (int i = 0; i < insig.length; i++)
				insig[i]= br.readLine();
			acron = new ArrayList<String>();
			String [] palabras = br.readLine().split(" ");
			acronym = palabras[0].toLowerCase();
			for (int i = 1; i < palabras.length; i++)
				if(!insignificante(palabras[i]))
					acron.add(palabras[i]);
			
		}
	}

}
