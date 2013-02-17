package WordLadder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int distEdic(String A, String B){
		int [][] M= new int[A.length()+1][B.length()+1];
		for (int i = 0; i <= B.length(); i++) 
			M[0][i] = i;
		for (int i = 0; i <= A.length(); i++) 
			M[i][0] = i;
		for (int i = 1; i <= A.length(); i++) {
			for (int j = 1; j <= B.length(); j++) {
				if(A.charAt(i-1)==B.charAt(j-1))
					M[i][j]=M[i-1][j-1];
				else
					M[i][j]=Math.min(M[i-1][j-1], Math.min(M[i-1][j], M[i][j-1]))+1;
			}	
		}
		return M[A.length()][B.length()];
	}
	
	static int maxEscal(String [] dicc){
		int n=dicc.length;
		boolean[][] aUnPaso = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				int difLong = Math.abs( dicc[i].length() - dicc[j].length() );
				if( difLong< 2 )
					aUnPaso[i][j] = distEdic(dicc[i], dicc[j])==1;
			}
		}
		int [] C= new int[n];
		C[n-1]=1;
		for (int i = n-2; i >= 0 ; i--) {
 			int noIncluir = C[i+1];
			int incluir = Integer.MIN_VALUE;
			for (int j = i+1; j < n; j++)
				if(aUnPaso[i][j] && C[j]>incluir)
					incluir = C[j];
			C[i]=Math.max(noIncluir, incluir+1);
		}
		return C[0];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int n= Integer.parseInt(br.readLine().trim());
			if(n==0)
				break;
			String [] dicc = new String[n];
			for (int i = 0; i < n; i++)
				dicc[i] = br.readLine().trim();
			System.out.println(maxEscal(dicc));
		}
		br.close();
	}

}
