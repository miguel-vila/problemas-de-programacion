currencies = [1,2,5,10,20,50,100,200]

def memoizar(f):
    cache= {}
    def mem(*x):
        if x not in cache:
            cache[x] = f(*x)
        return cache[x]
    return mem

def formas(n,i=len(currencies)-1):
    if n==0:
        return 1
    elif i<0:
        return 0
    else:
        return formas(n,i-1)+(formas(n-currencies[i],i) if n>=currencies[i] else 0)

formas = memoizar(formas)

def problem31():
    return formas(200)
