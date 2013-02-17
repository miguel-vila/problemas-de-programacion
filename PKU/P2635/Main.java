package P2635;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

	static ArrayList<Integer> primos;
	
	static void generar(int L){
		primos = new ArrayList<Integer>();
		boolean [] marc = new boolean[L+1];
		for (int i = 2; i <= L; i++) {
			if(!marc[i]){
				primos.add(i);
				int mult = 2;
				while(mult*i<=L){
					marc[mult++*i]=true;
				}
			}
		}
	}
	
	static String calc(BigInteger K, int L){
		generar(L);
		for (int i = 0; i<primos.size() && primos.get(i) < L; i++) {
			int p = primos.get(i);
			if(K.mod(new BigInteger(p+"")).equals(new BigInteger("0")))
				return "BAD "+p;
		}
		return "GOOD";
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String[] spl = br.readLine().split(" ");
			BigInteger K = new BigInteger(spl[0]);
			int L = Integer.parseInt(spl[1]);
			if(L==0)
				break;
			System.out.println(calc(K,L));
		}
	}
}
