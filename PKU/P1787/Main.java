package P1787;

import java.util.Scanner;

public class Main {

	static int P;
	
	static int E1;
	
	static int E2;
	
	static int E3;
	
	static int E4;
	
	static int [][] m;
	
	static int [][] ks;
	
	static void max()
	{
		m = new int [5][P+1];
		ks = new int [5][P+1];
		
		int [] E = {E1,E2,E3,E4};
		int [] C = {1 ,5 ,10,25};
		
		for (int j = 1; j < P; j++) 
			m[0][j] = Integer.MIN_VALUE;
		
		for (int i = 0; i < 5; i++)
			m[i][0] = 0;
		
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < P + 1; j++) {
				m[i][j] = Integer.MIN_VALUE;
				ks[i][j] = -1;
				for (int k = 0; k <= E[i-1] && j-k*C[i-1]>=0; k++)
					if(m[i][j]<m[i-1][j-k*C[i-1]]+k)
					{
						m[i][j] = m[i-1][j-k*C[i-1]]+k;
						ks[i][j] = k;
					}
			}
		}

		int max= 0;
		for (int i = 1; i < 5; i++)
		{
			if(m[max][P] < m[i][P])
				max=i;
		}
		
		if(m[max][P]<=0)
			System.out.println("Charlie cannot buy coffee.");
		else
		{
			int [] output = {0,0,0,0};
			
			int i=max;
			int j=P;
			
			while(ks[i][j]!=0)
			{
				output[i-1] = ks[i][j];
				j-=ks[i][j]*C[i-1];
				i--;
			}	
			
			System.out.println("Throw in "+output[0]+" cents, "+output[1]+" nickels, "+output[2]+" dimes, and "+output[3]+" quarters.");
		}
	}
	
	
	
	public static void main(String[] args)
	{
		Scanner s= new Scanner(System.in);
		while(true)
		{
			P = s.nextInt();
			E1 = s.nextInt();
			E2 = s.nextInt();
			E3 = s.nextInt();
			E4 = s.nextInt();
			if(P==0 && E1==0 && E2==0 && E3==0 && E4==0)
				break;
			max();
		}
	}

}
