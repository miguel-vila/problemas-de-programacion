package P2245;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

	public static void comb(char [] e, char [] s)
	{
		if(e.length==3)
			imprimir(e);
		else
		{
			for(int i=0;i<s.length;i++)
			{
				char [] c1=Arrays.copyOfRange(s, i+1 , s.length);
				char [] c2=Arrays.copyOf(e, e.length+1);
				c2[e.length] =s[i];
				comb(c2,c1);
			}
			
		}
	}
	
	
	public static void imprimir(char []l){
		for(int i=0;i<l.length-1;i++)
			System.out.print(l[i]);
		System.out.print(l[l.length-1]+"\n");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		char [] A={};
		char [] B={'a','b','c'};
		comb(A,B);

	}

}
