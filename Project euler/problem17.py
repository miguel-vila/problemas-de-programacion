import string

def numero(n):
    if len(str(n))==1:
        l={0:"",1:" one",2:" two",3:" three",4:" four",5:" five",6:" six",7:" seven",8:" eight",9:" nine"}
        return l[n]
    else:
        if len(str(n))==2:
            if str(n).startswith('1'):
                if n==10:
                    return " ten"
                if n==11:
                    return " eleven"
                if n==12:
                    return " twelve"
                if n==13:
                    return " thirteen"
                if n==15:
                    return " fifteen"
                suf="teen" if str(n)[1]!='8' else "een"
                return numero(int(str(n)[1]))+suf
            if str(n).startswith('2'):
                return " twenty"+numero(int(str(n)[1]))
            if str(n).startswith('3'):
                return " thirty"+numero(int(str(n)[1]))
            if str(n).startswith('4'):
                return " forty"+numero(int(str(n)[1]))
            if str(n).startswith('5'):
                return " fifty"+numero(int(str(n)[1]))
            suf="ty" if str(n)[0]!='8' else "y"
            return numero(int(str(n)[0]))+suf+numero(int(str(n)[1]))
        else:
            s="" if str(n).endswith("00") else " and"
            return numero(int(str(n)[0]))+" hundred"+s+numero(int(str(n)[1:3])) 
            

def problem17():
    return 11+sum(sum(len(i) for i in numero(j).split()) for j in range(1000))    
            
