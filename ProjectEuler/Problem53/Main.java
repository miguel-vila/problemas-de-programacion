package Problem53;

import java.math.BigInteger;
import java.util.Arrays;

public class Main {
	
	static BigInteger[][] m;
	static BigInteger one=new BigInteger("1");
	static BigInteger minusOne=new BigInteger("-1");
	
	static BigInteger c(int n,int k)
	{
		if(m[n][k].equals(minusOne))
		{
			if(!m[n][Math.abs(n-k)].equals(minusOne))
				m[n][k]= m[n][Math.abs(n-k)];
			if(k==0 || n==k)
				m[n][k]=one;
			else if(k==n-1)
				m[n][k]=new BigInteger(n+"");
			else
				m[n][k]=c(n-1,k-1).add(c(n-1,k));
		}
		return m[n][k];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		m= new BigInteger[101][101];
		for (int i = 0; i < 101; i++)
			Arrays.fill(m[i],minusOne);
		for(int i = 0; i < 101; i++)
			c(100,i);
		int cuantos =0;
		for(int n=0;n<101;n++){
			for(int k=0;k<=n;k++)
				if(c(n,k).compareTo(new BigInteger("0"))>0)
				{
					System.out.print(c(n,k)+" ");
					if(c(n,k).compareTo(new BigInteger("1000000"))>0)
						cuantos++;
				}
			System.out.println();
		}
		System.out.println(cuantos);
	}

}
