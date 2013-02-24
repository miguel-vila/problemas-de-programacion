#------Problem 2------
    
def nNumeroFibonacci(n=0):
    l=[]
    l.append(0)
    l.append(1)
    for i in range(2,n+1):
        l.append(l[i-1]+l[i-2])
    return l[n]

def problem2():
    i=1
    x=0
    suma=0
    while x<4000000:
        x=nNumeroFibonacci(i)
        if x%2==0:
            suma+=x
        i+=1
    return suma
