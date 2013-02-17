package CLOPPAIR;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	point[] A;
	
	static class point implements Comparable<point>{
		
		int indice;
		int x;
		int y;
		
		public point(int i, int x, int y){
			indice = i;
			this.x = x;
			this.y = y;
		}
		
		public double dist(point p){
			double d=Math.sqrt(Math.pow(x-p.x,2)+Math.pow(y-p.y,2));
			return Math.round(d*Math.pow(10, 6))/Math.pow(10, 6);
		}

		public int compareTo(point o) {
			return x-o.x;
		}
	}
	
	static class pair {
		int a;
		int b;
		double d;
		public pair(int a, int b, double d){
			this.a = a;
			this.b = b;
			this.d = d;
		}
	}
	
	public pair min3(pair a, pair b, pair c)
	{
		if( a.d < b.d)
			return a.d < c.d? a : c;
		else
			return b.d < c.d? b : c;
	}
	
	public pair closest(int p, int q)
	{
		if(q-p==1)
			return new pair(p, q, A[p].dist(A[q]));
		else if(q-p==2)
		{
			pair a = new pair(p, p+1, A[p].dist(A[p+1]));
			pair b = new pair(p+1, p+2, A[p+1].dist(A[p+2]));
			pair c = new pair(p, p+2, A[p].dist(A[p+2]));
			return min3(a, b, c);
		}
		else{
			int r=(p+q)/2;
			pair left = closest(p,r);
			pair right = closest(r+1, q);
			
			int horDist = A[r+1].x-A[r].x;
			if(horDist>left.d && horDist>right.d)
				return left.d<right.d ? left: right;
			
			int leftPointsInic = r;
			int leftPointsFin = r;
			int xLeft = A[r].x;
			
			while(leftPointsInic-1>=p && A[leftPointsInic-1].x==xLeft)
				leftPointsInic--;
			
			int rightPointsInic = r+1;
			int rightPointsFin = r+1;
			int xRight = A[r+1].x;
			
			while(rightPointsFin+1<=q && A[rightPointsFin+1].x==xRight)
				rightPointsFin++;
			
			pair min = new pair(-1, -1, Double.MAX_VALUE);
			for (int j = leftPointsInic; j <= leftPointsFin; j++) {
				for (int k = rightPointsInic; k <= rightPointsFin; k++) {
					point actLeft = A[j];
					point actRight = A[k];
					double dist = actLeft.dist(actRight);
					if( dist < min.d )
						min = new pair(actLeft.indice, actRight.indice, dist);
				}
			}
			
			return min3(min, left, right);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main m = new Main();
		Scanner s = new Scanner(System.in);
		m.A = new point [s.nextInt()];
		for (int i = 0; i < m.A.length; i++) {
			m.A[i] = new point(i, s.nextInt(), s.nextInt());
		}
		Arrays.sort(m.A, 0, m.A.length, new Comparator<point>() {
			public int compare(point o1, point o2) {
				return o1.compareTo(o2);
			}
		});
		for (int i = 0; i < m.A.length; i++) {
			point p = m.A[i];
			System.out.println(p.x+" "+p.y);
		}
		pair c = m.closest(0, m.A.length-1);
		System.out.println(Math.min(c.a, c.b)+" "+Math.max(c.a, c.b)+" "+c.d);		
	}

}
