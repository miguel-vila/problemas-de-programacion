package P2002;

import java.util.Scanner;

public class Main {

	public static double distancia(int x1,int y1,int x2,int y2){
		return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		while(n!=0){
			if(n>3){
				int [][] arr=new int [n][2];
				for(int i=0;i<n*2;i++)
				{
					int j = (i%2==0) ? 0 : 1;
					arr[i][j] = sc.nextInt();
				}
				int nCuad=0;
				for(int i =0; i< n-1;i++){
					int x1=arr[i][0];
					int y1=arr[i][1];
					boolean aMismaDist=false;
					int d=0;
					for(int j=i+1;j<n;j++){
						int x2=arr[j][0];
						int y2=arr[j][1];
						d=(int)distancia(x1,y1,x2,y2);
						for(int k=j+2;k<n;k++){
							
						}
					}
					
				}
			}
			
			}
		
	}

}
