import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

class problem9{

	static int problem9(){
		int x=0;
		for(int a=2;a<1000&&x==0;a++)
			for(int b=2;b<1000&&x==0;b++){
				double c=Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
				if(a+b+c==1000.0){
					x=a*b*(int)c;
				}
		}
		return x;
	}
	
	public static void main(String[] args) throws IOException{	    
		System.out.println(problem9());
	}
}