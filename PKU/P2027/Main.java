package P2027;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int casos=s.nextInt();
		for (int i = 0; i < casos; i++) {
			BigInteger a= s.nextBigInteger();
			BigInteger b= s.nextBigInteger();
			System.out.println(a.compareTo(b)>=0 ? "MMM BRAINS" : "NO BRAINS");
		}
		s.close();
	}
}
