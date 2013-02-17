package P10001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int [] max;

	static int max(int i, int [] arr)
	{
		if(max[i]==-1)
		{
			ArrayList <Integer> a = new ArrayList<Integer>();
			for (int j = i+1 ; j < arr.length ; j++)
				if( arr[i] < arr[j] )
					a.add( max(j,arr) );
			int maxi=0;
			for (int j = 1; j < a.size(); j++)
				if(a.get(maxi) < a.get(j))
					maxi = j;
			max[i] = a.size()>0 ? 1 + a.get(maxi) : 1;
		}
		return max[i];
	}
	
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int length = s.nextInt();
		int [] arr = new int[length];
		for (int i = 0; i < arr.length; i++)
			arr[i] = s.nextInt();
		max = new int[arr.length];
		Arrays.fill(max, -1);
		int maximo = max(0,arr);
		for (int i = 1; i < arr.length; i++) {
			int act = max(i,arr);
			if(act>maximo)
				maximo = act;
		}
		System.out.println(maximo);
	}
}
