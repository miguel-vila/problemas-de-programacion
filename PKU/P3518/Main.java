package P3518;

import java.util.Scanner;

public class Main {

	public static boolean esPrimo(int n)
	{
		if(n==1)
	        return false;
	    if(n<4 || n==5 || n==7)
	        return true;
	    if(n<10)
	        return false;
	    if(n%2==0 || n%3==0)
	        return false;
	    else{
	        int r=(int)Math.floor(Math.sqrt(n));
	        int f=5;
	        while(f<=r){
	            if(n%f==0 || n%(f+2)==0)
	                return false;
	            f+=6;
	        }
	        return true;
	    }
	}
	
	public static int gap(int n)
	{
		if(esPrimo(n))
			return 0;
		else
		{
			int i=n+1;
			while(!esPrimo(i))
				i++;
			int j=n-1;
			while(!esPrimo(j))
				j--;
			return i-j;
		}
	}
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		int n;
		while((n=s.nextInt())!=0){
			System.out.println(gap(n));
		}
		s.close();
	}
}
