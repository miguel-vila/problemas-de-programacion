import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

class problem12{
	
	static int problem12(){
		int a=1;
		boolean encontro=false;
		while(!encontro){
			a+=a;
			int i=2;
			int cont=2;
			while(i<a){
				if(i%a==0)
					cont++;
				i++;
			}
			if(cont>500)
						encontro=true;
		}
		return a;
	}	
	public static void main(String[] args) throws IOException{	    
		System.out.println(problem12());
	}
}

