import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

class problem4{
	
	static boolean esPalindromo(int n){
		StringBuffer sb=new StringBuffer(""+n);
		String rev=sb.reverse().toString();
		if(rev.equals(n+""))
			return true;
		else
			return false;
	}
	
	static int problem4(){
    	int n=0;
    	int max=0;
    	for(int i=100;i<1000;i++)
    		for(int j=100;j<1000;j++)
    			if(esPalindromo(i*j)){
    				n=i*j;
    				if(n>max)
    					max=n;
    			}
    	return max;
    }
	
	public static void main(String[] args) throws IOException{	    
		System.out.println(problem4());
	}
}

