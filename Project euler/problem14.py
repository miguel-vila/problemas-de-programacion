#------Problem 14------

def collatzProblem(n=0):
    cont=1
    while n!=1:
        if str(math.log(n,2)).endswith(".0"):
                cont+=math.log(n,2)
                break
        if n%2==0:
            n/=2
        else:
            n=3*n+1
        cont+=1
    return cont

def problem14():
    mayor=0
    num=0
    cont=2
    while cont<1000000:
        a=collatzProblem(cont)
        if a>mayor:
            mayor=a
            num=cont
        cont+=1
    return num
