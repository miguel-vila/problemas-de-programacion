package ROADS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	int [][]M;
	
	boolean [] visited; 
	
	ArrayList<edge> [] neig_inv;
	
	static class edge{
		short s,l,t;
		public edge(short s,short l,short t){ this.s=s; this.l=l; this.t=t;}
	}
	
	int M(short m, short t){
		if(M[m][t]==-1)
		{
			if(m==0)
				M[m][t]=0;
			else
			{
				int min=Short.MAX_VALUE;
				for(edge e: neig_inv[m]){
					if( t-e.t >=0 && !visited[e.s])
					{
						visited[e.s]=true;
						int d= e.l+M(e.s, (short)(t - e.t));
						if(d<min)
							min=d;
						visited[e.s]=false;
					}
				}
				M[m][t] = min;
			}
		}
		return M[m][t];
	}
	
	public static void main(String[] args) throws IllegalArgumentException, Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(br.readLine());
		for (int i = 0; i < casos; i++) {
			short k=Short.parseShort(br.readLine());
			short N=Short.parseShort(br.readLine());
			Main m=new Main();
			m.M = new int [N][k+1];
			for (int j = 0; j < N; j++)
				for (int j2 = 0; j2 < k+1; j2++)
					m.M[j][j2]=-1;
			m.neig_inv = new ArrayList [N];
			short R=Short.parseShort(br.readLine());
			for (int j = 0; j < N; j++)
				m.neig_inv[j]=new ArrayList<Main.edge>();
			for (int j = 0; j < R; j++) {
				String [] line = br.readLine().split(" ");
				short s=(short)(Short.parseShort(line[0])-1);
				short d=(short)(Short.parseShort(line[1])-1);
				short l=Short.parseShort(line[2]);
				short t=Short.parseShort(line[3]);
				edge e = new edge(s, l, t);
				m.neig_inv[d].add(e);
			}
			m.visited = new boolean[N];
			int resp = m.M((short)(N-1), k);
			System.out.println( resp==Short.MAX_VALUE ? -1 : resp);
		}
		br.close();
	}

}
