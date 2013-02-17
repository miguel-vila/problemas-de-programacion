package P2005;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static String deck = "23456789TAQKJ";

	public static int puntaje(char a, char b)
	{
		if(a == 'A')
		{
			if(b == 'A')
				return 12;
			if( b == 'K' || b == 'Q' || b == 'J' || b == 'T')
				return 21;
			return 11 + (b-48);
		}
		else
		{
			if(b == 'A')
				return puntaje(b, a);
			if(a == 'K' || a == 'Q' || a == 'J' || a == 'T')
			{
				if(b == 'K' || b == 'Q' || b == 'J' || b == 'T')
					return 20;
				return 10 + (b-48);
			}
			if(b == 'K' || b == 'Q' || b == 'J' || b == 'T')
				return 10 + (a-48);
			return a + b -96;
		}
	}
	
	
	
	public static int wins(char a, char b, char c , int n)
	{
		int wins = 0;
		
		int miPuntaje = puntaje(b, c);
		
		
		
		for( int i = 0; i < deck.length();i++)
		{
			char d = deck.charAt(i);
			wins += puntaje(a,d)<miPuntaje ? 4 : 0;
		}
		
		wins*=n;
				
		if(puntaje(a,a)<miPuntaje)
			wins --;
		
		if(puntaje(a,b)<miPuntaje)
			wins --;
		
		if(puntaje(a,c)<miPuntaje)
			wins --;
		
		return wins;
	}
	
	
	public static double probabilidad(char a,char b,char c,int n)
	{
		double casosTotales = 52*n - 3;
		double casosFavorables = wins(a,b,c,n);
		return 100 * casosFavorables / casosTotales ;
	}
	
	public static double redondear(double d)
	{
		double red = d*1000;
		return Math.round(red)/1000.0;
	}
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(new File("./test.txt"))));

		int n =Integer.parseInt(br.readLine().trim());
		
		while(n!=0)
		{
			String [] chars=br.readLine().split(" ");
			
			char a = chars[0].charAt(0);
			char b = chars[1].charAt(0);
			char c = chars[2].charAt(0);
			
			System.out.println(redondear(probabilidad(a, b, c, n))+"%");
			
			n=Integer.parseInt(br.readLine().trim());
			
			if(n!=0)
			{
				System.out.println(n);
			}
		}	
		br.close();
	}

}
