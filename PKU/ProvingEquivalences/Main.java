package ProvingEquivalences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	static class nodo implements Comparable<nodo>{
		ArrayList<nodo> vecinos= new ArrayList<nodo>();
		int ti;
		int tf;
		int numero;
		boolean visitado=false;
		nodo(int n)
		{
			numero = n;
		}
		@Override
		public int compareTo(nodo o) {
			return o.tf - tf;
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int casos = s.nextInt();
		
		for (int i = 0; i < casos; i++) {
			int statements = s.nextInt();
			int alreadyProved = s.nextInt();
			ArrayList <nodo> nodos = new ArrayList<nodo>(statements);
			for (int j = 0; j < nodos.size(); j++) {
				nodos.set(i,new nodo(i+1));
			}
			int t=0;
			for (int j = 0; j < alreadyProved; j++) {
				int source= s.nextInt();
				int dest=s.nextInt();
				nodos.get(source-1).vecinos.add(nodos.get(dest-1));
			}
			
			//DFS
			
			Stack<nodo> pila1= new Stack<nodo>();
			Stack<nodo> pila2= new Stack<nodo>();
			
			
			for (int j = 0; j < nodos.size(); j++) {
				if(!nodos.get(i).visitado){
					pila1.add(nodos.get(j));
					while(!pila1.isEmpty())
					{
						nodo act=pila1.pop();
						act.visitado = true;
						act.ti=t;
						pila2.push(act);
						t++;
						for(nodo n: act.vecinos)
						{
							if(!n.visitado)
								pila1.push(n);
						}
					}
						
					while(!pila2.isEmpty())
					{
						nodo act=pila1.pop();
						act.tf=t;
						t++;
					}
				}
			}
			
					
			ArrayList <nodo> copia = new ArrayList<nodo>(nodos.size());
			for (int j = 0; j < nodos.size(); j++) {
				for (int j2 = 0; j2 < nodos.get(i).vecinos.size(); j2++) {
					int nuevoOrigen = nodos.get(i).numero;
					
					
					if(copia.get(nuevoOrigen)==null)
						copia.set(nuevoOrigen, new nodo(nuevoOrigen));
					if(copia.get(i)==null)
						copia.set(i, new nodo(i+1));
					
					copia.get(nuevoOrigen).vecinos.add(copia.get(i));
				}
			}
			Collections.sort(nodos);
			
			int componentes = 0;
			
			pila2= new Stack<nodo>();
			
			for(int j=0;j<nodos.size();j++)
			{
				int ind = nodos.get(i).numero - 1;
				if(!copia.get(ind).visitado)
				{
					componentes++;
					pila1= new Stack<nodo>();
					pila1.push(copia.get(ind));
					while(!pila1.isEmpty())
					{
						nodo act=pila1.pop();
						act.visitado = true;
						pila2.push(act);
						for(nodo n: act.vecinos)
						{
							if(!n.visitado)
								pila1.push(n);
						}
					}
				}
			}
			
			pila1.add(copia.get( nodos.get(0).numero-1 ));
			
			
			
			
		}
	}

}
