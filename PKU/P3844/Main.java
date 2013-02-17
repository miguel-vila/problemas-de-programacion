package P3844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long divSub(int[] A, int d){
		long[] mod = new long[d];
		mod[0]=1;
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum=(sum+A[i])%d;
			mod[sum]++;
		}
		long formas = 0L;
		for (int i = 0; i < mod.length; i++)
			formas+=mod[i]*(mod[i]-1)/2;
		return formas;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		for (int m = 0; m < c; m++) {
			String [] spl = br.readLine().split(" ");
			int d = Integer.parseInt(spl[0]);
			int l = Integer.parseInt(spl[1]);
			int [] A = new int [l];
			spl = br.readLine().split(" ");
			for (int i = 0; i < spl.length; i++)
				A[i] = Integer.parseInt(spl[i]);
			System.out.println(divSub(A, d));
		}
	}

}
