/*MAPA MENTAL!
1)Se debe revisar la lista de listas (Estan separadas por una coma las listas a comparar)
2)Revisar si es que la lista puede ser vacía ([])
3)Comparar entre los pares de valores si existe adyacencia o no.
4)Si lo son devuelve true, sino, devuelve false
5)Comentar todo lo que revise y encuentre en internet, siempre es útil para explicar que estoy haciendo

Consulta que se utiliza:
ady([[1,1],[2,2],[3,1],[1,1]],[[2,2],[3,1],[4,5],[2,2]]) (true)
*/

/*
-Elemento1: Elemento de una lista.
-Elemento2: Otro elemento de una lista.
-[Elemento1,Elemento2|_]: Es una lista formada por una head de los elementos 1 y 2 proveniente de la función inferior,
en forma de Tail (En este caso usamos Head|_, se ignora lo que sigue que sería la Tail).
Es una regla creada para saber si los dos elementos están adyacentes en una lista ingresada.
*/
sonadyacentes(Elemento1, Elemento2, [Elemento1,Elemento2|_]).

/*
-Elemento1: Elemento de una lista.
-Elemento2: Otro elemento de una lista.
-[_|Tail]: Ambos elementos pertenecen a esta lista (Tail o Cola) (No nos
interesa la Head).
Es una regla que aplica la recursividad de Prolog,
para comprobar si ambos elementos son adyacentes o no en una lista.
*/
sonadyacentes(Elemento1, Elemento2, [_|Tail]) :-
    sonadyacentes(Elemento1, Elemento2, Tail).

/*
-Lista 1: Es una lista recibida
La regla revisa si una lista es vacía ([_]) o no.
*/

is_empty(Lista1):- not(member(_,Lista1)). %¿Pertenece o no pertenece?

/*
-[Head1|Tail1]:Lista con su head y tail.
-[Head2|Tail2]:Lista con su head y tail.
Se obtienen las Head y Tail correspondientes a ambas listas, que están separadas por una coma, luego se aplica un append
para unir la head con la tail correspondiente en una lista nueva y finalmente se aplican dos findall, uno para saber que elementos
se repiten entre las dos listas, que se agregan a una nueva lista para luego ser comparadas y el segundo, para conocer si los elementos son adyacentes entre las listas.
*/
ady([Head1|Tail1],[Head2|Tail2]):- %Head y Colas de cada lista correspondiente
    append([Head1], Tail1, List1), %Appends para unir las Head y Colas.
    append([Head2], Tail2, List2),
    findall(X, (member(X, List1), member(X, List2)), ListaPares), %findall(X,GOAL,Lista) Lo que hace es que busca todas las formas
    %posibles de llegar a GOAL, se le aplica a X la misma sustitución para crear una instancia probable para GOAL y se unifican en una Lista nueva.
    \+ is_empty(ListaPares), %\+ if unsure or false, assume false, entonces revisa si es que es una lista vacía
    findall((A,B), (member(A, ListaPares), member(B, ListaPares), sonadyacentes(A,B,List1), sonadyacentes(A,B,List2)), Adyacentess),
    \+ is_empty(Adyacentess). %Compara si A y B, son miembros de la ListaPares, y luego revisa si son adyacentes con las Listas 1 y 2 que tienen las Head y Tails
	%y agrega todos esos valores (A,B) a la lista adyacentess. Nuevamente aplicamos \+, y si es necesario se revisa si es una lista vacía.
