package TREE;

import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
	public static class nodo
	{
		int key;
		nodo izq;
		nodo der;
		public nodo(int key)
		{
			this.key=key;
		}
		public void agregar(int key)
		{
			if(this.key>key)
			{
				if(izq==null)
					izq = new nodo(key);
				else
					izq.agregar(key);
			}
			else
			{
				if(der==null)
					der = new nodo(key);
				else
					der.agregar(key);
			}
		}
		public boolean hoja()
		{
			return izq==null && der==null;
		}
	}
	
	
	public static class cola
	{
		public ArrayList<nodo> cola = new ArrayList<nodo>();
		public int cuantos=1;
		
		public cola(nodo n)
		{
			cola.add(n);
			if(n==null)
				cuantos=0;
		}
		
		public cola eliminarRaiz()
		{
			if(cola.size()<=1)
			{
				if(cola.get(0).izq==null)
				{
					if(cola.get(0).der==null)
						return colaVacia;
					else
						return new cola(cola.get(0).der);
				}
				else
				{
					if(cola.get(0).der==null)
						return new cola(cola.get(0).izq);
					else
					{
						cola t= new cola(cola.get(0).izq);
						t.cola.add(cola.get(0).der);
						t.cuantos=2;
						return t;
					}
				}
				
			}
			else
			{
				cola t= new cola(cola.get(0));
				t=t.eliminarRaiz();
				for (int i = 1; i < cola.size(); i++) {
					t.cola.add(cola.get(i));
				}
				t.cuantos = t.cola.size();
				return t;
			}
		}
		
		
		public boolean todosHojas()
		{
			if(cuantos==0)
				return true;
			else
			{
				for (int i = 0; i < cola.size(); i++) {
					if(!cola.get(i).hoja())
						return false;
				}
				return true;
			}
				
		}
	}
	
	public cola darColaA(nodo raiz)
	{
		if(raiz.izq==null)
			return colaVacia;
		return new cola(raiz.izq);
	}
	
	public cola darColaB(nodo raiz)
	{
		if(raiz.der==null)
			return colaVacia;
		return new cola(raiz.der);
	}
	
	public static int fact(int n)
	{
		return n==0? 1 : n*fact(n-1);
	}
	
	public static final cola colaVacia= new cola(null);
	
	
	public static int f(nodo raiz)
	{
		cola a=new cola(raiz.izq);
		cola b=new cola(raiz.der);
		return formas(a,b);
	}
	
	public static int formas(cola a, cola b)
	{
		if(a.todosHojas())
		{
			if(b.todosHojas())
				return fact(a.cuantos+b.cuantos);
			else
			{
				if(b.cola.size()>1)
				{
					return a.cuantos + formas(new cola(b.cola.get(0)),new cola(b.cola.get(1)));
				}
				else
				{
					return formas(a,b.eliminarRaiz());
				}
			}
				
		}
		else
		{
			if(b.todosHojas())
			{
				if(a.cola.size()>1)
					return b.cuantos + formas(new cola(a.cola.get(0)),new cola(a.cola.get(1)));
				else
				{
					return formas(a.eliminarRaiz(),b);
				}
			}
			else
			{
				int fA= formas(a.eliminarRaiz(),b);
				int fB= formas(a,b.eliminarRaiz());
				return fA+fB;
			}
		}
	}
	
	public static void main(String[] args) 
	{
		nodo raiz;
		Scanner s=new Scanner(System.in);
		int nodos = s.nextInt();
		raiz = new nodo(s.nextInt());
		for (int i = 0; i < nodos-1; i++) 
		{
			raiz.agregar(s.nextInt());
		}
		s.close();
		System.out.println(f(raiz));
	}
}
