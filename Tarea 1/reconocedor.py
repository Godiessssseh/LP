import re

"""
Nombre de la función: RGB
-----------------------
Parámetro 1: String
-----------------------
La funcion recibe el string e imprime por pantalla si es RGB o si no pertenece al lenguaje
"""

def RGB(str):
    RGB=re.compile(r"^#([A-F]|[0-9]){6}$")
    if RGB.fullmatch(str) is not None:
        print("RGB")
    else:
        print("No pertenece al lenguaje")

"""
Nombre de la función: HSL
-----------------------
Parámetro 1: String
-----------------------
La funcion recibe el string e imprime por pantalla si es HSL o si no pertenece al lenguaje
"""

def HSL(string):
        gd=r'(\d+)'
        s=r'\s*'
        pattern=fr'hsl\({s}{gd}{s},{s}{gd}{s}%{s},{s}{gd}{s}%{s}\)'
        m=re.match(pattern, string)
        try:
            n1, n2, n3=m.groups()    #En caso que sea un número negativo
        except AttributeError:
            print("No pertenece al lenguaje")
            return
        n1, n2, n3=map(int, [n1, n2, n3])
        if (n1 < 0 or n1 > 360) or (n2 < 0 or n2 > 100) or (n3 < 0 or n3 > 100):
            print("No pertenece al lenguaje")
        else:
            print("HSL")

"""
Nombre de la función: _Directorios
-----------------------
Parámetro 1: String
-----------------------
La funcion recibe el string y retorna si el directorio pertenece o no
"""
def _Directorios(Str):
    if re.search(r"^[A-Z]:\\", Str) or re.search(r"^\.{1,2}\\", Str)  or re.search(r"^~\\",Str) or re.search(r"^\s*",Str)  != None:
        valor=Str.split("\\")  # Lista de string separada por ,
        for i in valor:
            if i == "":
                return "No pertenece al lenguaje"
        for letra in range(1, len(valor)):
            if re.search(r"[^\/:?<>|]", valor[letra]) == None or re.search(r"(^\s+)[A-Za-z0-9]+",valor[letra])!=None:
                return "No pertenece al lenguaje"
        return "Directorio"
    else:
        return "No pertenece al lenguaje"

"""
Nombre de la función: Directorios
-----------------------
Parámetro 1: String
-----------------------
La funcion recibe el string e imprime por pantalla si es un Directorio o si no pertenece al lenguaje
"""

def Directorios(Str):
    print(_Directorios(Str))

"""
Nombre de la función: Correos
-----------------------
Parámetro 1: String
-----------------------
La funcion recibe el string e imprime por pantalla si es un Correo o no
"""

def Correos(Str):
    mail=re.compile(r"^\b[\w.%+-]+@{1}?[\w.-]+\.[a-zA-Z]{2,6}\b$")
    if mail.fullmatch(Str)!=None:
        print("Correo")
    else:
        print("No pertenece al lenguaje")

"""
Nombre de la función: Factorial
-----------------------
Parámetro 1: Entero
-----------------------
La funcion recibe el entero y devuelve un número factorial que se usará para Pascal
"""

def Factorial(n):
        if n == 0 or n == 1:
            resultado=1
        elif n>1:
            resultado=n * Factorial(n - 1)
        return resultado

""""
Nombre de la función: Altura
-----------------------
Parámetro 1: Entero
-----------------------
La funcion recibe el entero y nos devuelve la altura del triangulo de pascal
"""


def Altura_triangulo(alto):
    i=0
    k=0
    list=[]
    while i<=alto:
        while k<=i:
            c=i-k
            p=Factorial(c)
            s=Factorial(k)
            numero=Factorial(i)
            value=p*s
            j=int(numero/value)
            if i==alto:
                list.append(j)
            k+=1
        i+=1
        k=0
    return list

""""
Nombre de la función: Triangulo_de_Pascal
-----------------------
Parámetro 1: String
-----------------------
La funcion recibe el string e imprime en pantalla si es de Triangulo de Pascal o si no pertenece al lenguaje
"""
def Triangulo_de_Pascal(Str):
    altura=len(re.findall(r"\d+",Str))
    compara=Altura_triangulo(altura-1)
    Str=Str.strip("{}")
    Str=[int(n) for n in Str.split()]
    if Str==compara:
        print("Pascal")
    else:
        print("No pertenece al lenguaje")

"""
Nombre de la función: Fechas
-----------------------
Parámetro 1: String
-----------------------
La funcion recibe el string e imprime por pantalla si es una Fecha o no
"""

def Fechas(string):  #El regex se armó desde 0
    fecha=re.compile(r"^([0-9]{4}[-/]?((0[13-9]|1[012])[-/]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-/]?31|02[-/]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00)[-/]?02[-/]?29)$")
    if fecha.fullmatch(string)!=None:
        print("Fecha")
    else:
        print("No pertenece al lenguaje")

"""
Nombre de la función: XDSON
-----------------------
Parámetro 1: String
-----------------------
La funcion recibe el string e imprime por pantalla si ese string pertenece o no a XDSON

"""
def XDSON(Str):
    if re.search("^<",Str)  != None or re.search(r">$",Str)!=None:
        print("XDSON")
    else:
        print("No pertenece al lenguaje")


"""
Nombre de la función: Search
-----------------------
Parámetro 1: String
-----------------------
La funcion recibe el string y busca a que función pertenece

"""
def Search(string):
    if "#" in string:
        RGB(string)
    elif "hsl" in string:
        HSL(string)
    elif re.search(r"^[A-Z]:\\", string) or re.search(r"^\.{1,2}\\", string)  or re.search(r"^~\\",string):
        Directorios(string)
    elif re.search(r"^\b[\w.%+-]+@{1}?[\w.-]+\.[a-zA-Z]{2,6}\b$",string):
        Correos(string)
    elif re.search(r"{|}",string):
        Triangulo_de_Pascal(string)
    elif re.search(r"-", string):
        Fechas(string)
    elif "<" in string or ">" in string:
        XDSON(string)
    else:
        print("No pertenece al lenguaje")

FILE = open("palabras.txt","r")
for i in FILE:
    i=i.strip("\n")
    Search(i)
FILE.close()