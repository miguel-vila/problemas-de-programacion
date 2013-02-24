#------Problem 30------

def problem30():
    l=[]
    for i in range(100,1000001):
        s=0
        for j in range(0,len(str(i))):
            s+=pow(int(str(i)[j]),5)
        if s==i:
            l.append(i)
    return sum(l)
