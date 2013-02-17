package P3070;

import java.math.BigInteger;

public class Main {

	public static BigInteger one= new BigInteger("1");
	
	public static BigInteger zero= new BigInteger("0");
	
	public static BigInteger[][] f0={{one,one},{one,zero}};
	
	public static BigInteger[][] id={{one,zero},{zero,one}};
	
	public static BigInteger[][] multMatrices(BigInteger [][] m,BigInteger[][] n)
	{
		BigInteger[][] o= {{(m[0][0].multiply(n[0][0])).add(m[0][1].multiply(n[1][0])) , (m[0][0].multiply(n[0][1])).add(m[0][1].multiply(n[1][1])) },
						{(m[1][0].multiply(n[0][0])).add(m[1][1].multiply(n[1][0])) , (m[1][0].multiply(n[0][1])).add(m[1][1].multiply(n[1][1]))}};
		return o;
	}
	
	public static BigInteger [][] pow(BigInteger [][] m,int p)
	{
		if(p==0)
			return id;
		if(p%2==0)
		{
			BigInteger[][] o = pow(m,p/2);
			return multMatrices(o, o);
		}
		else
			return multMatrices(pow(m,p-1), m);
	}
	
	public static String nFib(int n)
	{
		BigInteger[][] m = pow(f0,n);
		return m[0][1].mod(new BigInteger("10000")).toString();
	}
	
	public static void main(String[] args) {
		System.out.println(nFib(999999));
	}
}
