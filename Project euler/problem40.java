import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

class problem40{

	static int contarCifras(int n){
		return (n+"").length();
	}

	static int problem40(){
		int ent=0;
		int cont=0;
		String cadena="";
		while(cont<1000000){
			ent++;
			String p=ent+"";
			cadena=cadena+p;
			cont+=contarCifras(ent);
		}
		return Integer.parseInt(cadena.charAt(0)+"")*Integer.parseInt(cadena.charAt(9)+"")*Integer.parseInt(cadena.charAt(99)+"")*Integer.parseInt(cadena.charAt(999)+"")*Integer.parseInt(cadena.charAt(9999)+"")*Integer.parseInt(cadena.charAt(99999)+"")*Integer.parseInt(cadena.charAt(999999)+"")*Integer.parseInt(cadena.charAt(9999999)+"");
	}
	
	public static void main(String[] args) throws IOException{	    
		System.out.println(problem40());
	}
}