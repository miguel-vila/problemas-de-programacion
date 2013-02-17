package P2339;

class Main {

	static char [] grid;
	
	static int compare(char a,char b)
	{
		if(a=='R')
		{
			if(b=='S')
				return 1;
			else if(b=='P')
				return -1;
			else
				return 0;
		}
		else if(a=='S')
		{
			if(b=='P')
				return 1;
			else if(b=='R')
				return -1;
			else
				return 0;
		}
		else
		{
			if(b=='R')
				return 1;
			else if(b=='S')
				return -1;
			else
				return 0;
		}
	}
	
	static void advance(char [][] g,int i, int j)
	{
		if(i<g.length-1)
		{
			int cmp=compare(g[i][j],g[i+1][j]);
			advance(g,i+1,j);
			if(cmp!=0)
			{
				if(cmp==-1)
				{
					
				}
			}
		}
	}
	
}
