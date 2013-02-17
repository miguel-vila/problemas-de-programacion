package P1083;

import java.util.Scanner;

public class Main {

	public static class traslado
	{
		int o;
		int d;
		boolean trasladado=false;
		public traslado(int o, int d) {
			this.o = o;
			this.d = d;
		}
		boolean posible(traslado cmp)
		{
			int inicCmp=Math.min(cmp.o, cmp.d);
			int finaCmp=Math.max(cmp.o, cmp.d);
			int inic=Math.min(o, d);
			int fina=Math.max(o, d);
			if((fina>inicCmp && fina<finaCmp)||(fina%2!=0 && inicCmp==fina+1))
				return false;
			else if((inic>inicCmp && inic<finaCmp)||(finaCmp%2!=0 && inic==finaCmp+1))
				return false;
			else if(inicCmp<inic && finaCmp>fina)
				return false;
			else if(inic<inicCmp && fina>finaCmp)
				return false;
			else
				return true;
		}
					
			
	}
	
	

	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int casos = s.nextInt();
		for (int i = 0; i < casos; i++) 
		{
			int tiempo=0;
			int traslados=s.nextInt();
			traslado [] ltraslados = new traslado[traslados];
			for (int j = 0; j < traslados; j++) 
				ltraslados[j]=new traslado(s.nextInt(),s.nextInt());
			for (int j = 0; j < ltraslados.length; j++) {
				traslado or= ltraslados[j];
				if(!or.trasladado)
				{
					or.trasladado=true;
					tiempo++;
					for (int k = i+1; k < ltraslados.length; k++) {
						if(or.posible(ltraslados[k]))
							ltraslados[k].trasladado=true;
					}
				}
			}
			System.out.println(tiempo*10);
		}
		s.close();
	}

}
