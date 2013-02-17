package HopelessCoach;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	static int N;

	static int P;

	static double P_W;
	
	static double P_D;
	
	static double P_L;
	
	static class pair implements Comparable<pair>{
		int x;
		int y;

		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(pair o) {
			return (int)Math.sqrt(Math.pow(x-o.x,2)+Math.pow(y-o.y,2));
		}
	}
	
	static ArrayList<pair> parejas()
	{
		ArrayList<pair> parejas = new ArrayList<Main.pair>();
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				if(3*i+j>=P && i+j<=N)
					parejas.add(new pair(i,j));
			}
		}
		return parejas;
	}

	static long [][] combinaciones;

	static void producirCombinaciones() {
		combinaciones = new long[N + 1][(N/2)+2];
		combinaciones[0][0] = 1L;
		combinaciones[1][0] = 1L;
		combinaciones[1][1] = 1L;
		for (int i = 2; i < N + 1; i++) {
			combinaciones[i][0] = 1;
			for (int j = 1; j <= (int)(i/2)+1; j++) {
				combinaciones[i][j] = combinaciones[i - 1][j - 1] + combinaciones[i - 1][j];
			}
		}
	}
	
	static double probabilidad(int x, int y)
	{
		return Math.pow(P_W, x)*Math.pow(P_D,y)*Math.pow(P_L,N-x-y)*darCombinacion(N, x)*darCombinacion(N-x, y);
	}
	
	static double probabilidad(int n, int p, int w, int d, int l)
	{
		double total = w+d+l;
		N=n;
		P=p;
		P_W=w/total;
		P_D=d/total;
		P_L=l/total;
		
		producirCombinaciones();
		
		double prob=0.0;
		ArrayList<pair> pairs = parejas();
		for(pair a: pairs)
		{
			prob+= probabilidad(a.x, a.y);
		}
		return prob;
	}

	public static long darCombinacion(int n, int k) {
		if (k > n / 2)
			return combinaciones[n][n - k];
		return combinaciones[n][k];
	}

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		while(true)
		{
			int a=s.nextInt();
			int b=s.nextInt();
			if(a==0&&b==0)
				break;
			System.out.println(probabilidad(a,b,s.nextInt(),s.nextInt(),s.nextInt())*100);
		}
		s.close();
		
	}
}