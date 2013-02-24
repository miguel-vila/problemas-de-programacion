import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

class problem52{
	
	public boolean mismosDigitos(int a){
		String numA=a+"";
		String numB=2*a+"";
		String numC=3*a+"";
		String numD=4*a+"";
		String numE=5*a+"";
		String numF=6*a+"";
		if(numA.length()==numB.length()&&numA.length()==numC.length()&&numA.length()==numD.length()&&numA.length()==numE.length()&&numA.length()==numF.length()){
			Character [] nA=new Character[numA.length()];
			Character [] nB=new Character[numB.length()];
			Character [] nC=new Character[numC.length()];
			Character [] nD=new Character[numD.length()];
			Character [] nE=new Character[numE.length()];
			Character [] nF=new Character[numF.length()];
			for(int i=0;i<numA.length();i++){
				nA[i]=numA.charAt(i);
				nB[i]=numB.charAt(i);
				nC[i]=numC.charAt(i);
				nD[i]=numD.charAt(i);
				nE[i]=numE.charAt(i);
				nF[i]=numF.charAt(i);
			}
			Arrays.sort(nA);
			Arrays.sort(nB);
			Arrays.sort(nC);
			Arrays.sort(nD);
			Arrays.sort(nE);
			Arrays.sort(nF);
			return Arrays.equals(nA,nB)&&Arrays.equals(nA,nC)&&Arrays.equals(nA,nD)&&Arrays.equals(nA,nE)&&Arrays.equals(nA,nF);
			}
		else
			return false;
	}
	
	public int problem52(){
		boolean encontro=false;
		int i=99999;
		while(!encontro)
			i++;
			if(mismosDigitos(i))
				encontro=true;
		return i;
	}
	
	public static void main(String[] args) throws IOException{	    
		System.out.println(problem52());
	}
}

