package P2062;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static class carta implements Comparable<carta>
	{
		int val;
		int palo;
		boolean jug=false;
		public carta(char v, char p)
		{
			if(p=='C')
				palo=0;
			else if(p=='D')
				palo=1;
			else if(p=='S')
				palo=2;
			else
				palo=3;
			if(v>=48 && v<=57)
				val=v-48;
			else
			{
				if(v=='T')
					val=10;
				else if(v=='J')
					val=11;
				else if(v=='Q')
					val=12;
				else if(v=='K')
					val=13;
				else
					val=14;
			}
		}
		@Override
		public int compareTo(carta o) {
			if(val-o.val!=0)
				return val-o.val;
			else
				return palo-o.palo;
		}
		
	}

	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int casos= s.nextInt();
		for (int i = 0; i < casos; i++) 
		{
			int k=s.nextInt();
			carta [] eve=new carta[k];
			carta [] adam=new carta[k];
			for(int j=0;j<k;j++)
			{
				String st=s.next();
				adam[j]=new carta(st.charAt(0),st.charAt(1));
			}
			for(int j=0;j<k;j++)
			{
				String st=s.next();
				eve[j]=new carta(st.charAt(0),st.charAt(1));
			}
			Arrays.sort(adam);
			Arrays.sort(eve);
			int points=0;
			for(int l=0;l<k;l++)
			{
				for(int j=0;j<k;j++)
					if(eve[l].compareTo(adam[j])>0&&!adam[j].jug)
					{
						points++;
						adam[j].jug=true;
					}
			}
			System.out.println(points);
		}
		s.close();
	}

}
