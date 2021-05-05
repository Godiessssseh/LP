#lang scheme

(define preorden
  (lambda (l1 funcion) ;Lista 1 con la funcion a ingresar
    (if (null? l1) 
        '()  ;La lista que se quiere retornar.
        (append (funcion(car l1)) ;devuelve el primer valor de la lista
                (preorden (cadr l1) funcion)   ;Si tiene valores, agrega el primer valor y aplica
                (preorden (caddr l1) funcion)) ;cadr es el car de cdr, caddr, es el cad de cdr de cdr. (Lei esto, creo que lo entendí y venía a lugar)
        )
    )
  )
