package P2700;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static class pair implements Comparable<pair>
	{
		int x;
		int y;
		long suma;
		public pair(int x, int y)
		{
			this.x=x;
			this.y=y;
			this.suma=x+y;
		}
		public int compareTo(pair o) {
			return suma!=o.suma? (int)(suma-o.suma) : (int)(x-o.x);
		}
	}
	
	static int[] extGCD(int a, int b)
	{
		if(b==0){ 
			int [] resp = {a,1,0};
			return resp;
		}
		int [] rp= extGCD(b, a%b);
		int resp[] = {rp[0], rp[2], rp[1] - (int)Math.floor(a/b)*rp[2]};
		return resp;
	}
	
	public static ArrayList<pair> soluciones(int a, int b, long c)
	{
		int [] ext = extGCD(a, b);
		int d=ext[0];
		int xp=ext[1]*(int)(c/d);
		int yp=ext[2]*(int)(c/d);
		if(c%d==0)
		{
			ArrayList<pair> parejas= new ArrayList<Main.pair>();
			int dx= b/d;
			int dy= a/d;
			if(xp<0)
			{
				int i =xp+(int)((Math.ceil(-(double)(xp)/dx))*dx);
				long menor=-1;
				
				while(i<=Math.ceil((double)(c)/a))
				{
					if(menor==-1 || menor>=i + (int)(c/b)-(int)(a*i/b))
					{	
						if(menor > i + (int)(c/b)-(int)(a*i/b))
						{	
							parejas.clear();
						}
						menor=i + (int)(c/b)-(int)(a*i/b);
						parejas.add(new pair(i, (int)(c/b)-(int)(a*i/b)));
					}
					i+=dx;
					System.out.println(parejas.get(0).x);
					System.out.println(parejas.get(0).y);
					
				}
			}
			else
			{
				int j = yp+(int)(Math.ceil(-(double)(yp)/dy))*dy;
				while(j<=Math.ceil((double)(c)/b))
				{
					parejas.add(new pair((int)(c/a)-(int)(b*j/a), j));
					j+=dy;
				}
			}
			Collections.sort(parejas);
			return parejas;
		}
		else
			return null;
	}
	/*
	public static ArrayList<pair> sols(int a, int b, long c)
	{
		
		ArrayList<pair> parejas= new ArrayList<pair>();
		long menorS=-1;
		int limite = (int)Math.min(Math.floor(c/a),Math.floor(c/b));
		System.out.println("lim="+limite);
		int cuantos=0;
		for(int x=0;x<=limite;x++)
		{	
			int min=Math.min(a,b);
			int max=Math.max(a,b);
			if((c-max*x)%min==0)
			{	
				cuantos++;
				if(menorS==-1)
					menorS=x+(c-max*x)/min;
				else if(x+(c-max*x)/min<menorS)
				{
					menorS=x+(c-max*x)/min;
					parejas.clear();
				}
				parejas.add(new pair(x,(c-max*x)/min));
			}
		}
		System.out.println(cuantos);
		if(parejas.size()==0)
			return null;
		else
		{
			Collections.sort(parejas);
			return parejas;
		}
	}*/
	
	static void print(int [] a)
	{
		String r=a[0]+" ";
		for (int i = 1; i < a.length; i++) {
			r+=a[i]+" ";
		}
		System.out.println(r);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long n=(long)sc.nextInt();
		while(n!=0)
		{
			int a=sc.nextInt();
			int b=sc.nextInt();
			long s=(long)sc.nextInt();
			long t=(long)sc.nextInt();
			long c=n+t-s;
			System.out.println(c);
			ArrayList<pair> sols= soluciones(a,b,c);
			if(sols==null)
				System.out.println("no solution");
			else
				for(pair p: sols)
					System.out.println(p.x+" "+p.y);
			n=(long)sc.nextInt();
		}
	}

}
