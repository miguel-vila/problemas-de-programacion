#------Problem 1------

def problem1():
    suma=0
    i=1
    while i<1000:
        if i%3==0 or i%5==0:
            suma=suma+i
        i=i+1
    return suma
