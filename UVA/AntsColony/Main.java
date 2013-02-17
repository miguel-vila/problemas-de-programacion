package AntsColony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Main {

	public static class arco{
		nodo nod;
		int longit;
		public arco(nodo nod, int longit) {
			this.nod = nod;
			this.longit = longit;
		}
	}
	
	public static class nodo extends NodoHeap<Long>{
		int id;
		ArrayList<arco> vec;
		long dist;
		int ind;
		public nodo(int id) {
			super(Long.MAX_VALUE);
			this.id = id;
			vec = new ArrayList<Main.arco>();
		}
		public void agregarArc(arco c){
			vec.add(c);
		}
		public boolean equals(nodo o){
			return this.id==o.id;
		}
	}
	
	public static abstract class NodoHeap<T extends Comparable<T>>{
		private T key;
		private int indice;
		public NodoHeap(T key){this.key = key;}
		public T getKey(){return key;}
		public int compareTo(NodoHeap<T> o){return this.key.compareTo(o.getKey());}
		public void changeKey(T key){this.key = key;}
		public void setIndice(int i){indice=i;}
		public int getIndice(){return indice;}
	}
	
	public static class MinHeap <N extends Comparable<N>,T extends NodoHeap<N>> {

		private ArrayList<T> A;
		
		private int heapSize;
		
		public MinHeap(T [] X) {
			A = new ArrayList<T>(X.length);
			for (int i = 0; i < X.length; i++){
				X[i].setIndice(i);
				A.add(i, X[i]);
			}
			heapSize = A.size();
			for (int i = (int)Math.floor(heapSize/2); i >=0; i--)
				minHeapify(i);
		}

		public int parent(int i){return (int)Math.floor(i/2);}
		
		public int left(int i){return 2*i;}
		
		private int right(int i){return 2*i+1;}
		
		private void minHeapify(int i){
			int l = left(i);
			int r = right(i);
			int smallest = (l< heapSize && A.get(l).getKey().compareTo(A.get(i).getKey())<0)? l : i; 
			if( r< heapSize && A.get(r).getKey().compareTo(A.get(smallest).getKey())<0)
				smallest = r;
			if( smallest!=i ){
				T temp = A.get(i);
				A.set(i, A.get(smallest));
				A.set(smallest, temp);
				A.get(smallest).setIndice(smallest);
				A.get(i).setIndice(i);
				minHeapify(smallest);
			}
		}
		
		//Quita el nodo de menor key y lo devuelve
		public T removeMin(){
			T temp = A.get(0);
			A.set(0, A.get(heapSize-1));
			A.get(0).setIndice(0);
			heapSize--;
			minHeapify(0);
			return temp;
		}
		
		//Al nodo i del heap le cambia el valor de su key (debe ser menor igual al anterior)
		public void changeKey(int i, N val){
			A.get(i).changeKey(val);
			for(int j=i; j>0 && A.get(j).getKey().compareTo(A.get(parent(j)).getKey())<0; j=parent(j)) {
				T temp = A.get(j);
				A.set(j, A.get(parent(j)));
				A.set(parent(j), temp);
				A.get(j).setIndice(j);
				A.get(parent(j)).setIndice(parent(j));
			}
		}	
	}
	
	//Cada nodo tiene un atributo de distancia que dice cual es la menor distancia hasta ese nodo
	public static long dijkstra(nodo[] nodos, int s, int d){
		int N = nodos.length;
		for (int i = 0; i < N; i++)
			nodos[i].dist = Long.MAX_VALUE;
		nodos[s].dist = 0L;
		MinHeap<Long, nodo> Q = new MinHeap<Long, nodo>(nodos);
		while(Q.heapSize>0){
			nodo min = Q.removeMin(); //Busca el nodo con menor distancia (y que no ha sido visitado)
			for (arco arc: min.vec) { //Entre sus vecinos actualiza la distancia en caso de ser necesario
				long alt = arc.longit + min.getKey();
				nodo vecino = nodos[arc.nod.id];
				if(alt<vecino.dist)
					Q.changeKey(vecino.ind, alt);
			}
		}
		return nodos[d].dist;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int N = Integer.parseInt(br.readLine());
			if(N==0)
				break;
			nodo [] nodos = new nodo[N];
			for (int i = 0; i < nodos.length; i++)
				nodos[i] = new nodo(i);
			for (int i = 0; i < N-1; i++) {
				String [] spl = br.readLine().split(" ");
				nodo nod = nodos[ Integer.parseInt(spl[0])];
				int longit = Integer.parseInt(spl[1]);
				nodos[i+1].agregarArc(new arco(nod, longit));
				nodos[nod.id].agregarArc(new arco(nodos[i+1], longit));
			}
			int Q = Integer.parseInt(br.readLine());
			String out = "";
			for (int i = 0; i < Q-1; i++) {
				String [] spl = br.readLine().split(" ");
				int s = Integer.parseInt(spl[0]);
				int d = Integer.parseInt(spl[1]);
				out+=dijkstra(nodos,s,d)+" ";
			}
			String [] spl = br.readLine().split(" ");
			int s = Integer.parseInt(spl[0]);
			int d = Integer.parseInt(spl[1]);
			out+=dijkstra(nodos,s,d);
			System.out.println(out);
		}
		br.close();
	}

}
