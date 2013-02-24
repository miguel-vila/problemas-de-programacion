import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

class problem10{

	static long problem10(){
		BigInteger i=new BigInteger(""+2);
		long suma=2;
		while(i.nextProbablePrime().intValue()<2000000){
			i=i.nextProbablePrime();
			suma+=i.longValue();
		}
			return suma;
	}
	
	public static void main(String[] args) throws IOException{	    
		System.out.println(problem10());
	}
}

