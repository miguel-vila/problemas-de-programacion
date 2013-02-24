import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

class problem22{

	public int valorNumerico(String pal){
		int num=0;
		for(int i=0;i<pal.length();i++)
			num+=Character.getNumericValue(pal.charAt(i))-9;
		return num;
	}
	
	public static int problem22() throws IOException{
		int suma=0;
		BufferedReader bf =new BufferedReader(new FileReader(new File("names.txt")));
		String [] lista= bf.readLine().split(" ");
		Arrays.sort(lista);
		for(int i=0;i<lista.length;i++)
			suma+=valorNumerico(lista[i])*(i+1);
		return suma;
	}
	
	public static void main(String[] args) throws IOException{	    
		System.out.println(problem22());
	}
}

