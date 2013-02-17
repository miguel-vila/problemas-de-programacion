package P2408;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {


	public static boolean sonAnagramas(String a,String b)
	{

		if(a.length()!=b.length())
			return false;
		for(int i = 0; i<a.length();i++)
			if(!b.contains(a.charAt(i)+""))
				return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		ArrayList <grupoPals> grupos = new ArrayList<grupoPals>();
		while(in.hasNextLine())
		{
			String line = in.nextLine();
			
			boolean nuevo= true;
			for(int i=0;i<grupos.size() && nuevo;i++)
				if(sonAnagramas(grupos.get(i).primera , line)){
					grupos.get(i).pals.add(line);
					nuevo = false;
				}
			if(nuevo)
			{
				grupoPals g=new grupoPals(line);
				g.pals.add(line);
				grupos.add(g);
			}
		}
		in.close();
		for (int i = 0; i < grupos.size(); i++) 
		{
			grupos.get(i).sort();
		}
		Collections.sort(grupos);
		
		for (int i = grupos.size() - 1; i > grupos.size() -6; i--) 
		{
			String ret="";
			for(int j=0;j<grupos.get(i).pals.size();j++){
				ret += grupos.get(i).pals.get(j)+" ";
			}
			ret +='.';
			System.out.println("Group of size "+grupos.get(i).pals.size()+": "+ret);
		}
	}
	
	public static class grupoPals implements Comparable
	{
		public String primera="";
		public ArrayList <String> pals = new ArrayList<String>();

		public grupoPals(String l){primera = l;}
		public int compareTo(Object a) {
			grupoPals o=(grupoPals)a;
			if(pals.size()>o.pals.size())
				return 1;
			if(pals.size()<o.pals.size())
				return -1;
			else
				return 0;
		}
		
		public void sort(){
			Collections.sort(pals);
		}
	}

}
