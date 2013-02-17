package P1575;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static boolean valida(String p)
	{
		int nVow=0;
		int nConsecVow =0;
		int nConsecCon =0;
		char last=' ';
		for(int i=0;i<p.length();i++)
		{
			if(last == p.charAt(i) && p.charAt(i)!='e' && p.charAt(i)!='o')
				return false;
			last = p.charAt(i);
			if(p.charAt(i) == 'a' || p.charAt(i) == 'e' || p.charAt(i) == 'i' || p.charAt(i) == 'o' || p.charAt(i) == 'u' )
			{
				nVow++;
				nConsecVow++;
				if(nConsecVow==3)
					return false;
				nConsecCon=0;
			}
			else
			{
				nConsecCon++;
				if(nConsecCon==3)
					return false;
				nConsecVow=0;
			}
		}
		return nVow >=1;
	}
	
	public static void main(String[] args) throws IOException 
	{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		String line=bf.readLine();
		while(!line.equals("end"))
		{
			String pal=line.trim();
			String add = valida(pal) ? "> is acceptable." : "> is not acceptable.";
			System.out.println("<"+pal+add);
			line =bf.readLine();
		}
		bf.close();
	}
}
