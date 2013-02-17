package P2935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	nodo[][] maze;
	
	public Main() {
		maze = new nodo[6][6];
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 6; j++)
				maze[i][j] = new nodo(i,j);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				maze[i][j].vec.add(maze[i+1][j]);//agrega norte
				maze[j][i].vec.add(maze[j][i+1]);//agrega este
				maze[5-i-1][j].vec.add(maze[5-i][j]);//agrega sur
				maze[j][5-i-1].vec.add(maze[j][5-j]);//agrega oeste
			}
		}
	}

	public void agregarParedHorizontal(int fila, int alto, int bajo){
		if(fila!=0 && fila!=6){
			for (int i = Math.min(alto, bajo); i < Math.max(alto, bajo); i++) {
				maze[fila-1][i].vec.remove(maze[fila][i]);
				maze[fila][i].vec.remove(maze[fila-1][i]);
			}
		}
	}

	public void agregarParedVertical(int columna, int izq, int der){
		if(columna!=0 && columna!=6){
			for (int i = Math.min(izq, der); i < Math.max(izq, der); i++) {
				maze[i][columna-1].vec.remove(maze[i][columna]);
				maze[i][columna].vec.remove(maze[i][columna-1]);
			}
		}
	}

	public char direc(nodo s, nodo d){
		if(s.x==d.x){
			if(s.y-d.y==1)
				return 'N';
			else
				return 'S';
		}
		else{
			if(s.x-d.x==1)
				return 'W';
			else
				return 'E';
		}
	}
	
	public nodo inv(char dir, nodo s){
		int x=s.x;int y=s.y;
		switch (dir) {
		case 'N':
			return maze[x+1][y];
		case 'S':
			return maze[x-1][y];
		case 'W':
			return maze[x][y-1];
		default:
			return maze[x][y+1];
		}
	}
	
	public String dfs(nodo s, nodo d){
		boolean [][] visitado = new boolean[6][6];
		char [][] dir = new char[6][6];
		Queue<nodo> Q=new LinkedList<nodo>();
		Q.add(s);
		boolean enc=false;
		while(!Q.isEmpty() && !enc){
			nodo u = Q.remove();
			visitado[u.x][u.y]=true;
			for(nodo v: u.vec){
				if(!visitado[v.x][v.y]) {
					dir[v.x][v.y] = direc(u,v);
					Q.add(v);
				}
			}
		}
		String salida="";
		nodo act = d;
		while(!act.equals(s)){
			salida=dir[act.x][act.y]+salida;
			act = inv(dir[act.x][act.y], act);
		}
		return salida;
	}

	public class nodo{
		int x,y;
		ArrayList<nodo> vec;
		public nodo(int x, int y) {
			super();
			this.x = x;
			this.vec=new ArrayList<nodo>();
			this.y = y;
		}
		public boolean equals(nodo o){return this.x==o.x&&this.y==o.y;}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			Main m = new Main();
			String[] spl = br.readLine().split(" ");
			int y0 = Integer.parseInt(spl[0])-1;
			int x0 = 6-Integer.parseInt(spl[1]);
			if(x0==0&&y0==0)break;
			nodo s = m.maze[x0][y0];
			spl = br.readLine().split(" ");
			int yf = Integer.parseInt(spl[0])-1;
			int xf = 6-Integer.parseInt(spl[1]);
			nodo f = m.maze[xf][yf];
			for (int i = 0; i < 3; i++) {	
				spl = br.readLine().split(" ");
				int a=Integer.parseInt(spl[0]);
				int b=Integer.parseInt(spl[1]);
				int c=Integer.parseInt(spl[2]);
				int d=Integer.parseInt(spl[3]);
				if(b==d)
					m.agregarParedHorizontal(b, a-1, c-1);
				else
					m.agregarParedVertical(c, b-1, d-1);
			}
			System.out.println(m.dfs(s, f));
		}

	}

}
