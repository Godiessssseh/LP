/*MAPA MENTAL:
la idea principal es ver si es un sector válido o no lo es (poligono que tenga una interseccion
entre dos rectas, es inválido)
Se sabe que siempre tendrá como mínimo tres puntos y la lista siempre tendra cuatro
elementos. (El primer elemento y el ultimo elemento son iguales, para cerrar correctamente
el polígono.
Una forma de resolver esto es con la fórmula para comparar una recta y un punto:
(X-X1)*(Y2-Y1)-(Y-Y1)*(X2-X1). Lo cual facilitará mucho el trabajo debido a que si existe
una intersección entre dos rectas, automáticamente se sabe que es false.
Se usarán siempre dos puntos, ya que equivalen a una recta.
 
Consulta usada:
sector([[50,170],[185,15],[250,100],[170,175],[80,10],[25,90],[50,170]])
*/

/*
-[X1,Y1]: Es la ubicación del primer punto ingresado.
-[X2,Y2]: Es la ubicación del segundo punto ingresado.
-[X,Y]: Es la posicion de un nuevo punto para usar la fórmula.
-Distancia: Es la variable donde iremos guardando el valor de la distancia.
La regla distancia calcula tal y como lo dice su nombre, la distancia. Calculará la distancia
entre: una recta dada por el punto uno y el punto 2, y por un punto 3.
*/

distancia([X1,Y1],[X2,Y2],[X,Y], Distancia):-
    Distancia is (X-X1)*(Y2-Y1)-(Y-Y1)*(X2-X1).

/*
-[X1,Y1]: Posición del primer punto a usar
-[X2,Y2]: Posición del segundo punto a usar
-[[X3,Y3],[X4,Y4]]: Puntos de la recta que se va compararán
-Tail: Cola que se usará para seguir comparando con los datos restantes. 
Es una regla para comparar cada distancia entre cada punto de dos rectas, es decir 4 veces.
La recta A con dos puntos pertenecientes a la recta B, y 
la recta B con los puntos pertenecientes a la recta A.
Se compararán los signos, si son diferentes se intersectan.
Se llama por recursividad a la misma función, para seguir recorriendo la lista, cuando queden solamente 4 listas
pasa a la función terminal de abajo.
*/
comparardistancias([X1,Y1],[X2,Y2],[[X3,Y3],[X4,Y4]|Tail]):- %Puntos de la recta A y la recta B, y la Tail con lo que queda de la lista
   	distancia([X1,Y1], [X2,Y2], [X3,Y3], D1), 
    distancia([X1,Y1],[X2,Y2],[X4,Y4],D2),
    distancia([X3,Y3],[X4,Y4],[X1,Y1],D3),
    distancia([X3,Y3],[X4,Y4],[X2,Y2],D4),
    ((D1 >= 0,D2 >= 0);(D1 =< 0,D2 =< 0);(D3 >= 0,D4 >= 0);(D3 =< 0,D4 =< 0)), %Comparar las distancias
	comparardistancias([X1,Y1],[X2,Y2],[[X4,Y4]|Tail]),!. %Ya no nos interesa X3,Y3 debido a que ya los usamos. Pero
	%X4,Y4 son los puntos de otra recta que continua en la Tail.

/*
-[X1,Y1]: Posición del primer punto a usar
-[X2,Y2]: Posición del segundo punto a usar
-[[X3,Y3],[X4,Y4]]: Puntos de la recta que se va compararán
Es una regla para comparar el último caso restante, entre los 4 puntos que quedan en la lista.
Se compararán los signos, si son diferentes se intersectan.
*/

comparardistancias([X1,Y1],[X2,Y2],[[X3,Y3],[X4,Y4]]):- %Puntos de la recta A y la recta B
   	distancia([X1,Y1],[X2,Y2],[X3,Y3],D1), 
    distancia([X1,Y1],[X2,Y2],[X4,Y4],D2),
    distancia([X3,Y3],[X4,Y4],[X1,Y1],D3),
    distancia([X3,Y3],[X4,Y4],[X2,Y2],D4),
    ((D1 >= 0,D2 >= 0);(D1 =< 0,D2 =< 0);(D3 >= 0,D4 >= 0);(D3 =< 0,D4 =< 0)),!. %Comparar las distancias
	%Si tienen signos distintos, se intersectan. Si tienen signos iguales, no. Se termina aca.

/*
[Head1,Head2|Tail]
-Head1 : La primera alución de la lista ingresada
-Head2 : Segunda alución de la lista
-Tail : Cola de la lista
La regla sector es para que se pueda recorrer la lista obteniendo los dos primeros puntos y
la cola que correspondería al resto de valores. Luego se aplica recursividad para volver a llamar
a la regla, solamente que utilizando la segunda Head con la cola anterior, debido a que Head2 con
el primer valor de la Tail, también son una recta.
*/

sector([Head1,Head2|Tail]):-
    comparardistancias(Head1,Head2,Tail),
    sector(Head2|Tail). %Llamar recursivamente para seguir con los valores de la lista.

