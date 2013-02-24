import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

class Problem14{

	static int collatzProblem(int n){
		int length=0;
		while(n!=1){
			if(n%2==0)
				n=n/2;
			else
				n=3*n+1;
			length+=n;	
		}
		return length;
	}

	static int problem14(){
		int mayor=1;
		int cont=1;
		while(cont<1000000){
			if(collatzProblem(cont)>collatzProblem(mayor))
				mayor=cont;
			cont++;
		}
		return mayor;
	}
	
	public static void main(String[] args) throws IOException{	    
		System.out.println(problem14());
	}
}

