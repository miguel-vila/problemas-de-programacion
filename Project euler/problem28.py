#------Problem 28------

def problem28():
    suma=1
    for i in range(1001,2,-2):
        suma+=4*pow(i,2)-6*i+6
    return suma
