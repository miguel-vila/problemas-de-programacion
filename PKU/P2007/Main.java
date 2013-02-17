package P2007;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main 
{
	public static ArrayList<ArrayList <tupla>> plano;
	
	public static void imprimirPlano(int i)
	{
		for(int j=i;j<plano.size();j++)
			imprimirCuadrante(plano.get(j));
		for(int j=0;j<i;j++)
			imprimirCuadrante(plano.get(j));
	}
	
	public static void imprimirCuadrante(ArrayList <tupla> cuad)
	{
		for (int i = 0; i < cuad.size(); i++) 
			System.out.println(cuad.get(i));
	}
	
	public static void main(String[] args) throws IOException 
	{
		Main m=new Main();
	}
	
	public Main () throws IOException
	{
		BufferedReader in= new BufferedReader(new  InputStreamReader(System.in));
		ArrayList <tupla> cuadrante1=new ArrayList<tupla>();
		ArrayList <tupla> cuadrante2=new ArrayList<tupla>();
		ArrayList <tupla> cuadrante3=new ArrayList<tupla>();
		ArrayList <tupla> cuadrante4=new ArrayList<tupla>();
		
		plano=new ArrayList <ArrayList <tupla>>();
		plano.add(cuadrante1);
		plano.add(cuadrante2);
		plano.add(cuadrante3);
		plano.add(cuadrante4);
		
		in.readLine();
		String line = in.readLine();
		while(line!=null)
		{
			int x = Integer.parseInt(line.split(" ")[0]);
			int y = Integer.parseInt(line.split(" ")[1]);
			if(x>0 && y>0)
				cuadrante1.add(new tupla(x,y));
			if(x<0 && y>0)
				cuadrante2.add(new tupla(x,y));
			if(x<0 && y<0)
				cuadrante3.add(new tupla(x,y));
			if(x>0 && y<0)
				cuadrante4.add(new tupla(x,y));
			line=in.readLine();
		}
		in.close();
		Collections.sort(cuadrante1);
		Collections.sort(cuadrante2);
		Collections.sort(cuadrante3);
		Collections.sort(cuadrante4);
		
		System.out.println("(0,0)");
		if(cuadrante1.size()==0)
			imprimirPlano(1);
		else
		{
			if(cuadrante2.size()==0)
				imprimirPlano(2);
			else
			{
				if(cuadrante3.size()==0)
					imprimirPlano(3);
				else
					imprimirPlano(0);
			}
		}
		
		
	}
	
	public class tupla implements Comparable<tupla>
	{
		int x;
		int y;
		public tupla(int x, int y)
		 {
			 this.x = x;
			 this.y = y;
		 }
		
		public double division()
		{
			return (double)y/x;
		}
		
		public int compareTo(tupla o) 
		{
			
			if(o.division()>division())
			{
				return -1;
			}
			else if(o.division()<division())
			{
				return 1;
			}
			else 
				return 0;
		}
		
		public String toString()
		{
			return "("+x+","+y+")";
		}
	}

}
