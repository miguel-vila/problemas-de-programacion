package P2251;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static class tupla{
		short x;
		short y;
		short z;
		short tiempo;
		
		public tupla(short x, short y, short z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		public String toString()
		{
			return "("+x+","+y+","+z+")";
		}
	}
	
	static short L,R,C;
	
	static char [][][] maze;
		
	static boolean arriba(tupla t)
	{
		return t.x!=0 && maze[t.x-1][t.y][t.z]!='#';
	}
	
	static boolean abajo(tupla t)
	{
		return t.x!=L-1 && maze[t.x+1][t.y][t.z]!='#';
	}
	
	static boolean north(tupla t)
	{
		return t.y!=0 && maze[t.x][t.y-1][t.z]!='#';
	}
	
	static boolean south(tupla t)
	{
		return t.y!=R-1 && maze[t.x][t.y+1][t.z]!='#';
	}
	
	static boolean west(tupla t) //izquierda
	{
		return t.z!=0 && maze[t.x][t.y][t.z-1]!='#';
	}
	
	static boolean est(tupla t) //derecha
	{
		return t.z!=C-1 && maze[t.x][t.y][t.z+1]!='#';
	}
	
	public static ArrayList<tupla> vecinos(tupla t)
	{
		ArrayList<tupla> vecinos= new ArrayList<tupla>();
		if(arriba(t))
			vecinos.add(new tupla((short)(t.x-1),t.y,t.z));
		if(abajo(t))
			vecinos.add(new tupla((short)(t.x+1),t.y,t.z));
		if(north(t))
			vecinos.add(new tupla(t.x,(short)(t.y-1),t.z));
		if(south(t))
			vecinos.add(new tupla(t.x,(short)(t.y+1),t.z));
		if(west(t))
			vecinos.add(new tupla(t.x,t.y,(short)(t.z-1)));
		if(est(t))
			vecinos.add(new tupla(t.x,t.y,(short)(t.z+1)));
		return vecinos;		
	}
	
	public static boolean salida(tupla t)
	{
		return maze[t.x][t.y][t.z]=='E';
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		L=s.nextShort();
		R=s.nextShort();
		C=s.nextShort();
		while(L!=0 && R!=0 && C!=0)
		{
			short xs=0;
			short ys=0;
			short zs=0;
			maze=new char[L][R][C];
			for (short i = 0; i < L; i++) 
				for (short j = 0; j < R; j++) {
					String cadena = s.next();
					if(cadena.indexOf('S')!=-1)
					{
						xs=i;
						ys=j;
						zs=(short)cadena.indexOf('S');
					}
					maze[i][j] = cadena.toCharArray();
				}
			
			tupla origen = new tupla(xs, ys, zs);
			origen.tiempo = 0;
			Queue<tupla> q= new LinkedList<tupla>();
			q.add(origen);
			short tiempo=-1;
			while(q.size()>0 && tiempo==-1)
			{
				tupla t = q.remove();
				ArrayList<tupla> vecinos = vecinos(t);
				maze[t.x][t.y][t.z] = '#';
				for (short i = 0; i < vecinos.size() && tiempo==-1; i++) {
					tupla v = vecinos.get(i);
					v.tiempo = (short)(t.tiempo + 1);
					q.add(v);
					if(salida(vecinos.get(i)))
						tiempo = v.tiempo;
				}
			}
			
			if( tiempo!=-1)
				System.out.println("Escaped in "+tiempo+" minute(s).");
			else
				System.out.println("Trapped!");
			L=s.nextShort();
			R=s.nextShort();
			C=s.nextShort();
		}
		
	}
}