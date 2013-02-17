package P1654;
import java.util.Scanner;

public class Main {

	static point p1;
	
	static class point
	{
		short x;
		short y;
		public point(int x,int y)
		{
			this.x=(short)x;
			this.y=(short)y;
		}
	}
	
	static point N8()
	{
		return new point(p1.x, p1.y +1);
	}
	
	static point S2()
	{
		return new point(p1.x, p1.y -1);
	}
	
	static point W4()
	{
		return new point(p1.x-1, p1.y);
	}
	
	static point E6()
	{
		return new point(p1.x+1, p1.y);
	}
	
	static point NW7()
	{
		return new point(p1.x-1, p1.y -1);
	}
	
	static point NE9()
	{
		return new point(p1.x+1, p1.y -1);
	}
	
	static point SW1()
	{
		return new point(p1.x-1, p1.y +1);
	}
	
	static point SE3()
	{
		return new point(p1.x+1, p1.y +1);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int casos= s.nextInt();
		for (int i = 0; i < casos; i++) {
			p1=new point(0,0);
			double area=0.0;
			String caso=s.next();
			for (int j = 0; j < caso.length()-1; j++) {
				point p2=null;
				switch(caso.charAt(j))
				{
					case '8':
						p2 = N8();
						break;
					case '2':
						p2 = S2();
						break;
					case '4':
						p2 = W4();
						break;
					case '6':
						p2 = E6();
						break;
					case '7':
						p2 = NW7();
						break;
					case '9':
						p2 = NE9();
						break;
					case '1':
						p2 = SW1();
						break;
					case '3':
						p2 = SE3();
						break;
				}
				short x1=p1.x;
				short y1=p1.y;
				short x2=p2.x;
				short y2=p2.y;
				area+=x1*y2-x2*y1;
				p1=p2;
			}
			System.out.println(area==0.0? "0" : Math.abs(area/2));
		}
	}

}
