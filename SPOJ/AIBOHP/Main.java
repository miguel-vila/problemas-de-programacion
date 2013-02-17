package AIBOHP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int min(String s){
		int n= s.length();
		int [][] M= new int [n][n];
		for (int j = 1; j < n; j++)
			for (int i = 0; i < j; i++)
			{
				if(s.charAt(i)==s.charAt(j))
					M[i][j]=M[i+1][j-1];
				else
					M[i][j]=Math.min( M[i][j-1] , M[i+1][j] )+1;
			}
		return M[0][n-1];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(br.readLine());
		for (int i = 0; i < casos; i++) {
			System.out.println(Main.min(br.readLine()));
		}
		br.close();
	}
}
