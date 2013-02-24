import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

class problem43{

	static long problem43(){
		long suma=0;
		for(long i=1000000000;i<999999999;i++)
			if(esPandigital(i)){
				String a=""+i;
				if(Integer.parseInt(""+a.charAt(3))%2==0
					&&Integer.parseInt(a.charAt(2)+""+a.charAt(3)+""+a.charAt(4))%3==0
					&&Integer.parseInt(a.charAt(5)+"")==5&&Integer.parseInt(a.charAt(5)+"")==0
					&&Integer.parseInt(a.charAt(4)+""+a.charAt(5)+""+a.charAt(6))%7==0
					&&Integer.parseInt(a.charAt(5)+""+a.charAt(6)+""+a.charAt(7))%11==0
					&&Integer.parseInt(a.charAt(6)+""+a.charAt(7)+""+a.charAt(8))%13==0
					&&Integer.parseInt(a.charAt(7)+""+a.charAt(8)+""+a.charAt(9))%17==0)
					suma+=i;
			}
		return suma;
	}
	
	public static void main(String[] args) throws IOException{	    
		System.out.println(problem43());
	}
}