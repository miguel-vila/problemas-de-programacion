#------Problem 16------

def contarDigitosNumero(n=0):
   num=str(n)
   return len(num)

def problem20(n=0):
    num=str(math.factorial(100))
    suma=0
    i=0
    while i<len(num):
        suma+=int(num[i])
        i+=1
    return suma
