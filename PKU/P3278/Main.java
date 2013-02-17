package P3278;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int longitud;
	static boolean[] recorridos;
	
	static int[] menoresRecorridos;
	
	public static int menor(int N, int K)
	{
		if(menoresRecorridos[N]==-1)
		{
			if(N==K)
				menoresRecorridos[N] = 0;
			else
			{
				int d1 = N>0 && N>K ? menor(N-1,K) : Integer.MAX_VALUE ;
				int d2 = N<menoresRecorridos.length && N<K ? menor(N+1,K) : Integer.MAX_VALUE ;
				int d3 = 2*N<menoresRecorridos.length && N<K ? menor(2*N,K) : Integer.MAX_VALUE;
				int min=Math.min(Math.min(d1, d2), d3);
				System.out.print(N+" :");
				if(min==d1)
					System.out.println(N-1);
				if(min==d2)
					System.out.println(N+1);
				if(min==d3)
					System.out.println(2*N);
				menoresRecorridos[N] = 1+min;
			}
		}
		return menoresRecorridos[N];
	}
	
	public static ArrayList<Integer> vecinos(int N)
	{
		ArrayList<Integer> vecinos = new ArrayList<Integer>();
		if(2*N <longitud && !recorridos[2*N])
			vecinos.add(2*N);
		if(N>0 && !recorridos[N-1])
			vecinos.add(N-1);
		if(N<longitud-1 && !recorridos[N+1])
			vecinos.add(N+1);
		return vecinos;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int N= s.nextInt();
		int K= s.nextInt();
		menoresRecorridos = new int [2*Math.max(N,K)];
		Arrays.fill(menoresRecorridos, -1);
		System.out.println(menor(N,K));
		/**
		longitud = 2*Math.max(N, K);
		recorridos = new boolean[longitud];
		int[] tiempos = new int[longitud];
		boolean enc = false;
		tiempos[N] = 0;
		Queue<Integer> q= new LinkedList<Integer>();
		q.add(N);
		while(q.size()>0 && !enc)
		{
			int act = q.remove();
			recorridos[act] = true;
			ArrayList<Integer> vecinos = vecinos(act);
			for (int j = 0; j < vecinos.size() && !enc; j++) 
			{
				int i= vecinos.get(j);
				q.add(i);
				if(i==K)
					enc=true;
				tiempos[i] = tiempos[act] +1;
			}
		}
		System.out.println(tiempos[K]-1);
		**/
		s.close();
	}
}
