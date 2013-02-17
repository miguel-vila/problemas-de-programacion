package P3637;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		int casos=s.nextInt();
		for (int i = 0; i < casos; i++) 
		{
			int nItems=s.nextInt();
			int [] precios = new int [nItems];
			for (int j = 0; j < precios.length; j++) 
			{
				precios[j] =s.nextInt();
			}
			Arrays.sort(precios);
			int max=0;
			for (int j = precios.length-3; j >= 0 ; j-=3) 
			{
				max+=precios[j];
			}
			System.out.println(max);
		}
		s.close();
	}
}