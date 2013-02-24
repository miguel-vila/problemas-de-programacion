#------Problem 25------

def nNumeroFibonacci(n=0):
    l=[]
    l.append(0)
    l.append(1)
    for i in range(2,n+1):
        l.append(l[i-1]+l[i-2])
    return l[n]

def problem25():
    i=4000
    while len(str(nNumeroFibonacci(i)))!=1000:
        i+=1
    return i
