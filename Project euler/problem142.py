#------Problem 142------

def problem142():
    mayor=0
    num=0
    cont=2
    while cont<1000000:
        cont2=1
        while cont!=1:
            if cont%2==0:
                cont/=2
            else:
                cont=3*n+1
            cont2+=1
        if cont2>mayor:
            mayor=cont2
            num=cont
        cont+=1
    return num
