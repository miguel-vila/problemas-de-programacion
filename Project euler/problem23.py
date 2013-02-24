from math import sqrt
from time import time

# Genera los divisores de todos los numeros hasta x
def divisores(x):
    div=[{},{1:True}]
    # div[i] contiene un diccionario con los divisores de i
    for i in range(2,x+1):
        j=2
        div.append({})
        div[i][1]=True
        while j<=sqrt(i):
            if i%j==0:
                div[i][j]=True
                div[i][i/j]=True
                A=div[j]
                B=div[i/j]
                for a in A.keys():
                    div[i][a]=True
                    for b in B.keys():
                        div[i][a*b]=True
                for b in B.keys():
                    div[i][b]=True
                break
            j+=1
        div[i][i]=True
    return div

def abundants(x):
    div = divisores(x)
    return [ i for i in range(1,x+1) if sum(div[i].keys()) - i > i ]

def noAb(x):
    t0=time()
    abund=abundants(x)
    filt=(x+1)*[False]
    for i in xrange(len(abund)):
        j=i
        while abund[i]+abund[j]<=x and j<len(abund):
            filt[abund[i]+abund[j]]=True
            j+=1
    suma = 0
    for i in xrange(x+1):
        if not filt[i]:
            suma+=i
    print "Tiempo=",str(time()-t0)
    return suma

print noAb(28123)
