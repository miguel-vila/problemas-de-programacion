import Algoritmos
import math
import time

def permutacionesMayoresYprimas(n):
    r=[]
    for i in str(n):
        r.append(int(i))
    l=[n]
    for i in range(math.factorial(len(r))):
        p=int(Algoritmos.nPermutacion2(i+1,r))
        if p>n and Algoritmos.esPrimo(p):
            l.append(p)    
    return l

def subsecuenciaAritmetica(l):
    d=0
    for i in range(0,len(l)-1):
        for j in range(i+1,len(l)-1):
            d=l[j]-l[i]
            if d+l[j] in l and d!=0:
                return [l[i],l[j],d+l[j]]
    return []
        

def problem49():
    ini=time.time()
    for i in range(1488,10000):
        if Algoritmos.esPrimo(i) and not('0' in str(i) ):
            perm=permutacionesMayoresYprimas(i)
            sub=subsecuenciaAritmetica(perm)
            if len(sub)!=0:
                print(time.time()-ini)
                return sub
    return []
            
