package P2492;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static nodo [] nodos;
	
	public static void reiniciarNodos()
	{
		for (int i = 0; i < nodos.length; i++) 
			nodos[i].reiniciar();	
	}
	
	
	public static class nodo{
		public int numero;
		public int color =0;
		public boolean visitado = false;
		public ArrayList <nodo> vecinos = new ArrayList<nodo>();
		
		public nodo(int n){
			numero = n;
		}
		
		public void imprimir()
		{
			for (int i = 0; i < vecinos.size(); i++) 
			{
				System.out.println(vecinos.get(i).numero);
			}
		}
		
		public boolean bipartito(int nColor){
			visitado = true;
			if(color != nColor && color!=0)
			{	
				return false;	
			}
			color = nColor;
			int nuevoColor = nColor == 1? -1 : 1;
			for (int i = 0; i < vecinos.size(); i++) {
				if(!vecinos.get(i).visitado)
				{ 
					boolean bipart = vecinos.get(i).bipartito(nuevoColor);
					if(!bipart)
						return false;
						
				}
				else
				{
					if(vecinos.get(i).color!=0 && vecinos.get(i).color != nuevoColor)
					{
						return false;
					}
				}
			}
			return true;
		}
		
		public void reiniciar(){
			visitado = false;
			color = 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	       
        int casos = sc.nextInt();
        for (int i = 0; i < casos; i++)
        {
            int bichos = sc.nextInt();
            
            nodos = new nodo[bichos];
            for (int j = 0; j < bichos; j++)
            {
                nodos[j]=new nodo(j+1);
            }
            
            int relaciones = sc.nextInt();
            
            
            for (int j = 0; j < relaciones; j++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                nodos[a-1].vecinos.add(nodos[b-1]);
                nodos[b-1].vecinos.add(nodos[a-1]);
            }
            
            boolean bip = true;
            for (int j = 0; j < bichos && bip; j++)
            {
            	bip = nodos[i].bipartito(1);
            	reiniciarNodos();
            }
            System.out.println("Scenario #"+(i+1)+":");
            String add = bip? "No suspicious bugs found!" : "Suspicious bugs found!";
            System.out.println(add);
            if(i!=casos-1)
            	System.out.println();
        }
        sc.close();
	}
}