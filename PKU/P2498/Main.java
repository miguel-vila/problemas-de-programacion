package P2498;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int coeficiente(int x, int s)
	{
		int multiplo =1;
		while(true)
		{
			if((x*multiplo+s)%10==0)
				return multiplo;
			multiplo++;
		}
	}
	
	public static void caso(String codigo, int i)
	{
		int r =0;
		int suma =0;
		int coefIncognita=-1;
		int pos=0;
		for(int j=codigo.length()-1;j>=0;j--)
		{
			int coeficienteActual;
			if(r == 0)
				coeficienteActual = 9;
			else{
				if(r == 1)
					coeficienteActual = 3;
				else
					coeficienteActual = 7;
			}
			if(codigo.charAt(j)=='?')
			{
				coefIncognita = coeficienteActual;
				pos =j;
			}
			else
				suma+=coeficienteActual * Integer.parseInt(""+codigo.charAt(j));
			r=(r+1)%3;
		}
		System.out.println("Scenario #"+(i+1)+":");
		int numero = coeficiente(coefIncognita, suma);
		if(pos == codigo.length()-1)
			System.out.println(codigo.substring(0,codigo.length()-1)+numero);
		else
			System.out.println(codigo.substring(0,pos)+numero+codigo.substring(pos+1));
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int casos = Integer.parseInt(br.readLine());
		for (int i = 0; i < casos-1; i++) 
		{
			String codigo=br.readLine();
			caso(codigo,i);
			System.out.println();
		}
		caso(br.readLine(),casos-1);
		br.close();
	}

}
