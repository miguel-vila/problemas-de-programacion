package AMR10G;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException{
		Scanner s = new Scanner(System.in);
		int casos = s.nextInt();
		for (int i = 0; i < casos; i++) {
			int n = s.nextInt();
			int k = s.nextInt();
			int [] arr = new int[n];
			for (int j = 0; j < n; j++)
				arr[j] = s.nextInt();
			Arrays.sort(arr);
			int min = Integer.MAX_VALUE;
			for (int j = 0; j <= n-k; j++) {
				min = Math.min(min, arr[j+k-1]-arr[j]);
			}
			System.out.println(min == Integer.MAX_VALUE ? 0 : min);
		}
		s.close();
	}
}
