import math

def n(n=0):
    l=[]
    l.append(3)
    l.append(7)
    for i in range(2,n+1):
        l.append(2*l[i-1]+l[i-2])
    return l[n-1] 

def d(n=0):
    l=[]
    l.append(1)
    l.append(2)
    for i in range(2,n+1):
        l.append(2*l[i-1]+l[i-2])
    return l[n]

def problem57():
    cont=0
    for i in range(1,1001):
        if len(str(n(i)))>len(str(d(i))):
            cont+=1
    return cont
