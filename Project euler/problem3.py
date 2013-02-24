#------Problem 3------

def problem3():# El número es apenas 6000 algo, el método se demora mucho en
               # comprobar que es el mayor
               
    n=600851475143
    num=0
    for i in range(2,int(n/7)):# 7 por q el numero evidentemente no es divisible
                               # por 2,3 ó 5
        if(n%i==0):
            print(i)
            esPrimo=True
            if i%2==0:
                esPrimo=False
            for j in range(3,int(i/2),2):
                if(i%j==0):
                    esPrimo=False
                    break
            if(esPrimo):
                num=i
                print(i)
    print("Este texto nunca aparecerá en pantalla")
    return num
