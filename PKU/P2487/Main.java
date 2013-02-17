package P2487;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k=1;
		int casos = Integer.parseInt(br.readLine());
		while(k<=casos)
		{
			String [] linea = br.readLine().split(" ");
			int min = Integer.parseInt(linea[0]);
			int n = Integer.parseInt(linea[1]);
			linea = br.readLine().split(" ");
			int [] A= new int[n];
			for (int i = 0; i < n; i++)
				A[i]= Integer.parseInt(linea[i]);
			Arrays.sort(A);
			int i=n-1;
			while(i>=0 && min>0)
			{
				min-=A[i];
				i--;
			}
			System.out.println("Scenario #"+k+":");
			if(min<=0)
				System.out.println(n-1-i);
			else
				System.out.println("impossible");
			if(k!=casos)
				System.out.println();
			k++;
		}
		br.close();
	}
}
