package P2739;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static int numeroDeSumas(int n)
	{
		int [] criba = criba(n);
		int [] sumas = arregloDeSumas(criba);
		int numero =0;
		for (int i = 1; i < sumas.length; i++) 
		{
			int inicio = sumas[i-1];
			int j=1;
			while(j<sumas.length && sumas[j]-inicio<=n)
			{
				if(sumas[j]-inicio==n)
				{
					numero++;
					break;
				}
				j++;
			}
		}
		return numero;
	}
	
	public static int[] arregloDeSumas(int [] l)
	{
		int [] r= new int[l.length+1];
		r[0]=0;
		for(int i=0;i<l.length;i++)
			r[i+1]=l[i]+r[i];
		return r;
	}
	
	public static int[] criba(int n)
	{
		ArrayList<Integer> primos = new ArrayList<Integer>();
		primos.add(2);
		primos.add(3);
		ArrayList<ArrayList<Integer>> colaDeCompuestos = new ArrayList<ArrayList<Integer>>();
		boolean alternar = true;
		int indice = 5;
		while(indice<=n)
		{
			int i=-1;
			for (int j = 0; j < colaDeCompuestos.size(); j++) 
				if( colaDeCompuestos.get(j).size()>1 && colaDeCompuestos.get(j).get(0)==indice)
				{
					i=j;
					break;
				}
			if( i==-1 )
			{
				primos.add(indice);
				int mult = indice;
				ArrayList<Integer> temp = new ArrayList<Integer>();
				if( indice*mult<=n )
					temp.add(indice*mult);
				int j=0;
				while( j<primos.size() )
				{
					int calc = primos.get(j)*indice;
					if(primos.get(j)>indice && calc<=n )
					{
						temp.add(calc);
					}
					mult = primos.get(j)+1;
					j++;
				}
				int a = indice*mult;
				while(a<=n)
				{
					if(a%2!=0 && a%3!=0)
						temp.add(a);
					a+=indice;
				}
				if(temp.size()>0)
					colaDeCompuestos.add(temp);
			}
			else
				colaDeCompuestos.get(i).remove(0);
			indice+= alternar ? 2 : 4;
			alternar = !alternar;	
		}
		int [] temp = new int[primos.size()];
		for (int i = 0; i < temp.length; i++) {
			temp[i]=primos.get(i);
		}
		return temp;
	}
	
	public static void imprimir(int [] l)
	{
		System.out.print("[");
		for (int i = 0; i < l.length-1; i++) {
			System.out.print(l[i]+",");
		}
		System.out.print(l[l.length-1]+"]");
	}
	
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		int n;
		imprimir(criba(666));
		while((n=s.nextInt())!=0){
			System.out.println(numeroDeSumas(n));
		}
		s.close();
	}

}
