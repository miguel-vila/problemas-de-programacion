#------Problem 41------
    
def problem41():
    lista=permutaciones("1234567",7)
    l=[]
    for i in range(0,len(lista)):
        if esPrimo(lista[i]):
            l.append(lista[i])
    return max(l)

def crearNumero(l=[]):
    num=""
    for i in range(0,len(l)):
        num+=str(l[i])
    return int(num)

import itertools

def permutaciones(num="",n=0):
    l=[]
    lista=list(itertools.permutations(num,n))
    for i in range(0,len(lista)):
        l.append(crearNumero(lista[i]))
    return l

def pandigit(n=0):
    mayor=0
    comp=str(n)
    j=0
    if repetido(n):
        return False
    while j<len(comp):
        if int(comp[j])>mayor:
            mayor=int(comp[j])
        j+=1
    pandigit=True
    mayor-=1
    while mayor>0:
        if not str(mayor) in str(n):
            pandigit=False
            break
        mayor-=1
    return pandigit

def numerosPandigit():
    lista=[]
    i=87654321
    while i<=987654321:
        if pandigit(i):
            lista.append(i)
        i+=1
    return lista

def repetido(n=0):
    l=[]
    j=0
    while j<len(str(n)):
        l.append(str(n)[j])
        j+=1
    i=0
    while i<len(l):
        compar=l[i]
        copia=l
        del copia[i]
        if compar in copia:
            return True
        i+=1
    return False
