#------Problem 15------

def t(i=0,n=0): #metodo muy lento, seria t(17,20) o algo así
    if n==1:
        return 1
    if i==0:
        return n*(n+1)/2
    return t(i-1,n)+t(i,n-1)

def problem15():
    m = [[0 for x in range(21)] for y in range(21)]# copiado de http://python-es-faq.wikidot.com/#toc48
    for i in range(0,21):
        m[i][0]=1
        m[0][i]=1
    for i in range(1,21):
        for j in range(1,21):
            m[i][j]=m[i-1][j]+m[i][j-1]
    return m[20][20]
