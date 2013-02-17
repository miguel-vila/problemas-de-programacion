package P1696;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	static class punto{
		int x;
		int y;
		boolean visitado;
		public punto(int xp,int yp){
			x=xp;
			y=yp;
			visitado = false;
		}
	}
	
	static double pendiente(punto p1,punto p2)
	{
		return p2.x!=p1.x ? (p2.y-p1.y)/(p2.x-p1.x) : p2.y>p1.y ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int casos = s.nextInt();
		for (int i = 0; i < casos; i++) {
			HashMap<Integer, punto> puntos = new HashMap<Integer, punto>();
			int id = s.nextInt()-1;
			puntos.put(id, new punto(s.nextInt(),s.nextInt()));
			int menorY = id;
			int mayorX = id;
			for (int j = 0; j < puntos.size()-1; j++){
				id = s.nextInt()-1;
				puntos.put(id, new punto(s.nextInt(),s.nextInt()));
				if(puntos.get(id).y<puntos.get(menorY).y)
					menorY = id;
				if(puntos.get(id).x>puntos.get(menorY).x)
					mayorX = id;
			}
			puntos.get(menorY).visitado = true;
			String recorrido = menorY+"";
			punto p1= puntos.get(menorY);
			punto actual = new punto(0, p1.y);
			
		}
	}

}
