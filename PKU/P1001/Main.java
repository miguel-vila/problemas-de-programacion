package P1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		while(line!=null)
		{
			String [] split = line.split(" ");
			BigDecimal R = new BigDecimal(split[0]);
			short n = Short.parseShort(split[split.length-1]);
			
			R=R.pow(n);
			String cad = R.toString();
			if(cad.equals("0"))
				System.out.println(cad);
			else
			{
				int inicio = 0;
				while(cad.charAt(inicio)=='0')
					inicio++;
				cad=cad.substring(inicio, cad.length());
				
				if(cad.endsWith(".0"))
					System.out.println(cad.substring(0,cad.length()-2));
				else{
					int E=cad.indexOf("E");
					if(E!=-1)
					{
						if(cad.charAt(E+1)=='-')
						{
							int exp = Integer.parseInt(cad.substring(E+2))-1;
							String pre=".";
							for (int i = 0; i < exp; i++)
								pre+='0';
							int p=cad.indexOf('.');
							if(p!=-1)
								cad=pre+cad.substring(0,p)+cad.substring(2,E);
							else
								cad=pre+cad.substring(0,E);
						}
						/**
						else
						{
							int exp = Integer.parseInt(cad.substring(E+1))-1;
							cad=cad.charAt(0)+cad.substring(2,2+exp)+'.'+cad.substring(3+exp);
						}
						**/
					}
					
					
					
					int fin = cad.length()-1;
					while(cad.charAt(fin)=='0')	
						fin--;
					cad = cad.substring(0,fin+1);
					
					if(cad.charAt(cad.length()-1)=='.')
						cad=cad.substring(0,cad.length()-1);
					
					System.out.println(cad);
				}
			}
			line = br.readLine();
		}
		br.close();
	}

}
