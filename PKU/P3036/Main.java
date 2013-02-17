package P3036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long [] f = {1,0,6,12,90,360,2040,10080,54810,290640,1588356,8676360,47977776,266378112,1488801600};
	
	/** Precalculos:
	static short d[][] = {{-1,1},{1,1},{-2,0},{2,0},{-1,-1},{1,-1}};
	
	static long f(int x, int y, int p){
		if(p==0)
			return x==0 && y==0 ? 1 : 0;
		else{
			long f = 0L;
			for (int i = 0; i < 6; i++) {
				int xp = x+d[i][0];
				int yp = y+d[i][1];
				f+=f(xp,yp,p-1);
			}
			return f;
		}
	}
	**/
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		for (int i = 0; i < c; i++) {
			int p = Integer.parseInt(br.readLine());
			System.out.println(f[p]);
		}
		br.close();
	}
	
}
