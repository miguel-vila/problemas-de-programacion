package P3842;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	int n;
	short [][]equals;
	public class nodo{
		String c;
		nodo izq,der;
		int n,i;
		boolean apunt;
		public nodo(String c, int x) {
			this.c = c;
			this.i = x;
			apunt = false;
		}
		public String toString(){
			if(izq==null && der==null)
				return apunt? n+"" : c;
			else if(!apunt)
				return c+"("+izq.toString()+","+der.toString()+")";
			else
				return n+"";
		}
		public boolean equals(nodo o){
			if(equals[i-1][o.i-1]==0)
			{
				if(equals[o.i-1][i-1]==0){
					if(!this.c.equals(o.c))
						equals[i-1][o.i-1]=-1;
					else{
						boolean izq = false;
						if(this.izq==null)
							izq=o.izq==null;
						else
							izq = o.izq!=null && this.izq.equals(o.izq);
						if(!izq)
							equals[i-1][o.i-1]=-1;
						else{
							boolean der = false;
							if(this.der==null)
								der=o.der==null;
							else
								der = o.der!=null && this.der.equals(o.der);
							equals[i-1][o.i-1]= der? (short)1 : (short)-1;
						}	
					}
				}
				else
					equals[i-1][o.i-1]=equals[o.i-1][i-1];
			}
			equals[o.i-1][i-1]=equals[i-1][o.i-1];
			return equals[i-1][o.i-1]==1;
		}
				
	}
	String s;
	
	nodo raiz;
	
	public int coso(nodo[] nodos,int i, nodo raiz){
		nodos[i]= raiz;
		i++;
		if(raiz.izq!=null) {
			i = coso(nodos,i,raiz.izq);
			i = coso(nodos,i,raiz.der);
		}
		return i;
	}
	
	
	public String reducir(){
		nodo[] nodos = new nodo[n];
		equals = new short[n][n];
		int apuntados = 0;
		coso(nodos,0,raiz);
		for (int i = 1; i < nodos.length; i++) {
			for (int j = 0; j < i; j++) {
				if(nodos[j].equals(nodos[i])){
					nodos[i].n = nodos[j].i;
					apuntados++;
					nodos[i].apunt = true;
					break;
				}
			}
			nodos[i].i=  i+1 -apuntados;
		}
		return raiz.toString();
	}
	
	public Main(String s){
		this.s=s;
		this.n=0;
		raiz = construirArbol(0, s.length()-1);
	}
	
	public nodo construirArbol(int p, int r){
		int i = p;
		n++;
		while(i<=r && 'a'<=s.charAt(i) && s.charAt(i)<='z')i++;
		nodo raiz = new nodo(s.substring(p, i), n);
		if(i-1!=r){
			int q=i+1;
			Stack<Boolean> stack = new Stack<Boolean>();
			while((s.charAt(q)!=',' || stack.size()!=0)){
				q++;
				if(s.charAt(q)=='(')
					stack.push(true);
				if(s.charAt(q)==')')
					stack.pop();
			}
			raiz.izq = construirArbol(i+1, q-1);
			raiz.der = construirArbol(q+1, r-1);
		}
		return raiz;
	}
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(br.readLine());
		for (int i = 0; i < casos; i++) {
			String s = br.readLine().trim();
			Main m = new Main(s);
			System.out.println(m.reducir());
		}
		br.close();
	}
}