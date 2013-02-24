import string

def construirCadena(n=0):
	cad=""
	for i in range(1,n+1):
		cad+=str(i)
	return cad

def d(n=0): #devuelve la longitud de la cadena 
	if n<10:
		return n
	else:
		l=len(str(n))
		p=int(str(n)[0])
		numeroRaro = p*(10**(l-1))-1
		return d(numeroRaro) + l*(n-numeroRaro)

def numeroLimite(): #devuelve el numero de la cadena que construye una de longitud apenas mayor a 1000000
    lim=1000000
    i=1
    ev=0
    while ev<lim:
        ev=d(i)
        i+=1
    return i-1

def problem40():
    cad=construirCadena(numeroLimite())
    return int(cad[9])*int(cad[100-1])*int(cad[1000-1])*int(cad[10000-1])*int(cad[100000-1])*int(cad[1000000-1])
