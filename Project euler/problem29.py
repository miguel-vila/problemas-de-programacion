#------Problem 29------

def problem29():
    l=[]
    for i in range(2,101):
        for j in range(2,101):
            pot=pow(i,j)
            if not pot in l:
                l.append(pot)
    return len(l)
