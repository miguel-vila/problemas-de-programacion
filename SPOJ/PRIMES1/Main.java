package PRIMES1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int mapear(int i)
	{
		int residuo = i%4;
		int a = (int)Math.floor(i/4.0);
		int b = residuo==0 ? 1 : residuo==1? 3 : residuo==2? 7 : 9;
		return Integer.parseInt(a+""+b);
	}
	
	static int inversa(int i)
	{
		int residuo = i%10;
		int a = 4*(int)Math.floor(i/10.0);
		int b = residuo==1 ? 0 : residuo==3? 1 : residuo==7? 2 : 3;
		return a+b;
	}
	
	static void criba(int p, int q)
	{
		boolean [] criba = new boolean[(int)Math.ceil(q/10.0)*4];
		
		int cuantos = 3;
		int n= mapear(1);
		for (int i = 1; n <= q; i++) {
			if(!criba[i])
			{
				cuantos++;
				for (int j = 2*n; j <= q; j+=n) {
					int residuo= j%10;
					if(residuo==1 || residuo==3 || residuo==7 || residuo==9)
						criba[inversa(j)] = true;
				}
			}
			n=mapear(i+1);
		}
		if(q>=2 && p<=2)
			System.out.println(2);
		if(q>=3 && p<=3)
			System.out.println(3);
		if(q>=5 && p<=5)
			System.out.println(5);
		
		int m=mapear(2);
		for (int i = 2; i < criba.length && m<=q; i++) 
		{
			if(!criba[i] && m>=p)
				System.out.println(m);
			m = mapear(i+1);
		}
	}

	static int buscarApenasMayor(int [] arr, int a)
	{
		if(a<=arr[0])
			return 0;
		
		int q=0,p=0;
		int r=arr.length-1;
		
		while(p!=r)
		{
			q=(int)Math.ceil((p+r)/2.0);
			if(arr[q]>=a && arr[q-1]<a)
				p=r;
			else if(arr[q]>a)
				r = q-1;
			else
				p = q;
		}
		if(arr[q]>=a && arr[q-1]<a)
			return q;
		else
			return -1;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		criba(99990,1000000);
		System.out.println("!");
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		boolean[] b = new boolean[40000];
		int casos = Integer.parseInt(br.readLine());
		for (int i = 0; i < casos; i++) {
			String[] spl = br.readLine().split(" ");
			int p=Integer.parseInt(spl[0]);
			int q=Integer.parseInt(spl[1]);
			criba(p,q);
			System.out.println();
		}
		br.close();
	}

}
