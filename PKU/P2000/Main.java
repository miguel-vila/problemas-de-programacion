package P2000;

import java.util.Scanner;

public class Main {
	
	public static int paga(int dia){
		int dAct=0;
		int resp=0;
		int paga=1;
		for(int i=0;i<dia;i++){
			resp+=paga;
			dAct++;
			if(paga==dAct){
				paga++;
				dAct=0;
			}
		}
		return resp;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i=1;
		int act=sc.nextInt();
		while(act!=0 && i<=22){
			System.out.println(act+" "+paga(act));
			act=sc.nextInt();
			i++;
		}
	}
}
