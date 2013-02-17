package CuttingSticks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	int [] C;
	
	int l;
	
	int n;
	
	int C(int i){
		if(i==0)
			return 0;
		else if(i==n+1)
			return l;
		else
			return C[i-1];
	}
	
	int min(int n, int [] C, int l){
		this.n= n;
		this.C=C;
		this.l=l;
		int [][] M= new int[n+1][n+2];
		for (int i = 0; i <= n; i++) 
			M[i][i+1]=0;
		for (int j = 2; j <= n+1; j++)
			for (int i = j-2; i >= 0; i--) {
				M[i][j] = Integer.MAX_VALUE;
				for (int k = i+1; k <= j-1; k++) {
					int c= M[i][k]+M[k][j]+C(j)-C(i);
					if( M[i][j]>c )
						M[i][j] = c;
				}
			}
		return M[0][n+1];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int l=Integer.parseInt(br.readLine());
			if(l==0)
				break;
			int n=Integer.parseInt(br.readLine());
			String[] numeros = br.readLine().split(" ");
			int [] C= new int[n];
			for (int i = 0; i < n; i++)
				C[i]=Integer.parseInt(numeros[i]);
			Main m= new Main();
			System.out.println("The minimum cutting is "+m.min(n, C, l)+".");
		}
		br.close();
	}

}
