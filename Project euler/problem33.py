#------Problem 33------

def gcd(a=0,b=0):
    r1=a
    r2=b
    r3=-1
    while r3!=0:
        r3=r1%r2
        r1=r2
        r2=r3
    return r1

def problem33():
    den=[]
    num=[]
    for i in range(10,100):
        for j in range(i+1,100):
            if cancelable(i,j):
                den.append(j)
                num.append(i)
    prodDen=1
    prodNum=1
    i=0
    while i<4:
        prodDen*=den[i]
        prodNum*=num[i]
        i+=1
    return prodDen/gcd(prodDen,prodNum)
