package P10008;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static char mat [][][];
	
	static int longitud(int n)
	{
		return (int)Math.pow(3, n-1);
	}
	
	static char [][] fractal(int n)
	{
		if(mat[n-1][0][0]=='0')
		{
			int lAnt = longitud(n-1);
			int longitudAct = 3*lAnt;
			char [][] fracAct = new char[longitudAct][longitudAct];
			char [][] fracAnt = fractal(n-1);
			for (int i = 0; i < lAnt; i++) {
				for (int j = 0; j < lAnt; j++) {
					char c = fracAnt[i][j];
					fracAct[i][j] = c;
					
					fracAct[i+lAnt][j+lAnt] = c;
					fracAct[i+2*lAnt][j] = c;
					fracAct[i][j+2*lAnt] = c;
					fracAct[i+2*lAnt][j+2*lAnt] = c;
				
					fracAct[i][j+lAnt] = ' ';
					fracAct[i+lAnt][j] = ' ';
					fracAct[i+lAnt][j+2*lAnt] = ' ';
					fracAct[i+2*lAnt][j+lAnt] = ' ';
				
				}
			}
			mat[n-1] = fracAct;
		}
		return mat[n-1];
	}
	
	static void imp(char [][] m,int longit)
	{
		for (int i = 0; i < longit; i++) {
			int max = -1;
			for (int j = longit-1; j >=0 && max==-1; j--) {
				if(m[i][j]=='X')
					max=j;
			}
			for (int j = 0; j <= max; j++) {
				System.out.print(m[i][j]);
			}
			System.out.println();
		}
		System.out.println('-');
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n = s.nextInt();
		ArrayList <Integer> ns = new ArrayList<Integer>();
		int i=0;
		int max = n;
		while(n!=-1)
		{
			ns.add(n);
			n = s.nextInt();
			if(max<n)
				max=n;
			i++;
		}
		s.close();
		mat = new char [max][longitud(max)][longitud(max)];
		for (int j = 0; j < max; j++) {
			mat[j][0][0]='0';
		}
		mat[0][0][0]='X';
		fractal(max);
		for (int j = 0; j < ns.size(); j++) {
			imp(fractal(ns.get(j)),longitud(ns.get(j)));
		}
	}
}
