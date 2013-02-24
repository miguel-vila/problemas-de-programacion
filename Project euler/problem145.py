#------Problem 145------

def problem145():
    suma=0
    for i in range(1,pow(10,9)+1):
        if not('0' in str(i)):
            b=i+invertirN(i)
            if consisteEnNumerosImpares(b):
                print(str(i)+"   "+str(b))
                suma+=1
    return suma

def consisteEnNumerosImpares(n=0):
    num=str(n)
    for i in range(0,len(str(n))):
        if int(n/pow(10,i))%2==0:
            return False
    return True
