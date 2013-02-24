import math
import time

#Devuelve la n-sima permutacion lexicografica de una lista ordenada l
#(El orden inicial 
def nPermutacion(n,l):
    if len(l)==1:
        return str(l[0])
    else:
        esp=math.factorial(len(l)-1)
        for i in range(len(l)):
            if i*esp+1<= n <=(i+1)*esp:
                p=l[i]
                l.remove(l[i])
                return str(p)+nPermutacion(n-i*esp,l)
        return "FUCK!" #nunca se deberia retornar esto

def problem24():
    inicio=time.time()
    print(nPermutacion(1000000,[0,1,2,3,4,5,6,7,8,9]))
    return time.time()-inicio


def sicas(n):
	n=str(n)

	return all(n[2*i-2]==chr(48+i)	for i in range(1,10)) and n[18]=='0' if len(n)==19 else False

def __main__():
    print(problem24())
