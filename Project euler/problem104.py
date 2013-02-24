#------Problem 104------

def tomarPrimeros9numeros(n=0):
    return int(n/pow(10,contarDigitosNumero(n)-9))

def tomarUltimos9numeros(n=0):
    num=str(n)
    num=int(num[::-1])
    num=str(int(num/pow(10,contarDigitosNumero(num)-9)))
    return int(num[::-1])

def esPandigital(n=0):
    num=str(n)
    i=0
    digitos=['1','2','3','4','5','6','7','8','9']
    while i<len(num):
        if num[i] in digitos:
            digitos.remove(num[i])
        i+=1
    if len(digitos)==0:
        return True
    else:
        return False

def problem104():
    encontrado=False
    i=84
    while not(encontrado):
        preg=nNumeroFibonacci(i)
        if esPandigital(tomarPrimeros9numeros(preg)) and esPandigital(tomarUltimos9numeros(preg)):
            encontrado =True
            i-=1
        i+=1
    return i

def invertirN(n=0):
    num=str(n)
    num=num[::-1]
    return int(num)
