package P10014;

import java.util.Scanner;

public class Main {

	public static int max(int[][] T,int n)
	{
		for (int i = n-2; i>=0 ; i--) 
			for(int j=0 ; j<i+1 ;j++)
				T[i][j]+= T[i+1][j]>T[i+1][j+1]? T[i+1][j] : T[i+1][j+1] ;
		return T[0][0];
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int casos = s.nextInt();
		for (int i = 0; i < casos; i++) {
			int n= s.nextInt();
			int [][] T = new int[n][n];
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < j+1; j2++) {
					T[j][j2] = s.nextInt();
				}
			}
			System.out.println(max(T,n));
		}
		s.close();
	}

}
