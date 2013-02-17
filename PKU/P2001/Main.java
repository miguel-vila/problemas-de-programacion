package P2001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static NodoTrie trie;
	
	static void agregarPalabra(String s)
	{
		if(trie==null){
			trie = new NodoTrie(s.charAt(0), s.length()==1);
			if(s.length()>1)
				trie.agregarPal(s);
		}
		else
			trie.agregarPal(s);
	}
	
	public static class NodoTrie
	{
		NodoTrie hermano;
		NodoTrie hijo;
		
		char c;
		boolean finPal;
		int prefijoDeCuantas;
		
		public NodoTrie(char c, boolean finPal) {
			this.c = c;
			this.finPal = finPal;
			this.prefijoDeCuantas = 1;
		}
		
		void agregarPal(String pal)
		{
			if(pal.charAt(0)==c)
			{
				if(pal.length()>1)
				{
					if(hijo==null)
					{	
						hijo=new NodoTrie(pal.charAt(1), pal.length()==2);
						hijo.agregarPal(pal.substring(1));
					}
					else
					{
						hijo.agregarPal(pal.substring(1));
						prefijoDeCuantas++;
					}
				}
			}
			else
			{
				if(hermano==null)
					hermano = new NodoTrie(pal.charAt(0), pal.length()==1);
				hermano.agregarPal(pal);
			}
		}
		
		String shortestPreffix(String s,String carry)
		{
			if(s.length()==0)
				return carry;
			if(s.charAt(0)==c)
			{
				carry+=c;
				if(prefijoDeCuantas==1)
					return carry;
				else
					return hijo.shortestPreffix(s.substring(1), carry);
				
			}
			else
			{
				return hermano.shortestPreffix(s, carry);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> pals = new ArrayList<String>();
		while(true)
		{
			String line = br.readLine();
			if(line==null)
				break;
			pals.add(line);
			agregarPalabra(line);
		}
		br.close();
		for(String s: pals)
			System.out.println(s+" "+trie.shortestPreffix(s, ""));
	}
	
}
