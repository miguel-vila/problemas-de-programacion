package P10050;


import java.io.IOException;
import java.util.Scanner;

public class Main {

	static boolean jolly(long []a)
	{
		boolean[] listos = new boolean[a.length-1];
		for (int i = 0; i < a.length-1; i++) {
			if(Math.abs(a[i]-a[i+1])<a.length)
			{
				if(listos[(int)(Math.abs(a[i]-a[i+1])-1)])
					return false;
				else
					listos[(int)(Math.abs(a[i]-a[i+1])-1)]=true;
			}
			else
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner s= new Scanner(System.in);
		while(s.hasNextInt())
		{
			long[] arr= new long[s.nextInt()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] =s.nextLong();
			}
			System.out.println(jolly(arr)? "Jolly": "Not jolly");
		}
		s.close();
	}
}
