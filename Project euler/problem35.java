import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

class problem35{

	static Boolean esPrimo(long n){
        if(n==2 || n==3) return true;
        if(n%2 == 0) return false;
        if(n<2) return false;
        for(double a=3;a<=(n/2);a+=2)
            if(n%a==0)
				return false;
		return true;
    }

	static String [] darNumerosCirculares(int n){
		String cad=""+n;
		String []num=new String[contarCifras(n)-1];
		for(int i=0;i<num.length;i++)
			num[i]="";
		for(int i=0;i<num.length;i++){
			for(int j=i;j<num.length;j++)
				num[i]+=cad.charAt(j+1);
			int a=(int)Math.floor(n/(Math.pow(10,num.length-i)));
			num[i]+=a+"";
		}
		return num;
	}

	static boolean esPrimoCircular(int n){
		if(esPrimo(n)){
			boolean esCircular=true;
			String[]lista=darNumerosCirculares(n);
			for(int i=0;i<lista.length&&esCircular;i++)
				if(!esPrimo(Integer.parseInt(lista[i])))
					esCircular=false;
			return esCircular;
		}else
			return false;
	}

	static ArrayList problem35(){
		ArrayList lista=new ArrayList();
		for(int i=2;i<1000000;i++)
			if(esPrimoCircular(i))
				lista.add(i);
		return lista;
	}
	
	public static void main(String[] args) throws IOException{	    
		System.out.println(problem35());
	}
}