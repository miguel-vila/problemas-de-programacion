package P2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	
	public static class nodo{
		public String nombre;
		
		public ArrayList<nodo> subordinados;
		
		public nodo(String nombre)
		{
			this.nombre = nombre;
			this.subordinados = new ArrayList<nodo>();
		}
		
		public nodo buscar(String s)
		{
			if(nombre.equals(s))
				return this;
			else
			{
				if(subordinados.size()==0)
					return null;
				else
				{
					for (int i = 0; i < subordinados.size(); i++)
					{
						nodo b= subordinados.get(i).buscar(s);
						if(b!=null)
							return b;
					}
					return null;
				}
			}
		}
		
		public void hire(String empleador, String s)
		{
			buscar(empleador).subordinados.add(new nodo(s));
		}
		
		public void fireCEO()
		{
			nombre = subordinados.get(0).nombre;
			fire(nombre);
		}
		
		public void fire(String s)
		{
			for (int i = 0; i < subordinados.size(); i++)
			{
				if(subordinados.get(i).nombre.equals(s))
				{
					if(subordinados.get(i).subordinados.size()==0)
					{
						subordinados.remove(i);
						break;
					}
					else
					{
						ArrayList<nodo> subord = subordinados.get(i).subordinados;
						String nombreAscendido = subord.get(0).nombre;
						subordinados.remove(i);
						subordinados.add(i,new nodo(nombreAscendido));
						subordinados.get(i).subordinados = subord;
						subordinados.get(i).fire(nombreAscendido);
						break;
					}
				}
				else
				{
					subordinados.get(i).fire(s);
				}
			}
		
		}
		
		public void print(String carry)
		{
			System.out.println(carry+nombre);
			for (int i = 0; i < subordinados.size(); i++)
			{
				subordinados.get(i).print(carry+'+');
			}
		}
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		nodo CEO = new nodo(br.readLine());
		String line=br.readLine();
		while(line!=null)
		{
			String[] spl = line.split(" ");
			if(spl.length>=2)
			{
				if(spl[1].equals("hires"))
				{
					CEO.hire(spl[0], spl[2]);
				}
				else
				{
					if(CEO.nombre.equals(spl[1]))
						CEO.fireCEO();
					else
						CEO.fire(spl[1]);
				}
			}
			else
			{
				CEO.print("");
				System.out.println("------------------------------------------------------------");
			}
			line = br.readLine();
		}
		br.close();	
	}
}
