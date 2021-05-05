#lang scheme

#|Guia mental
Lista con las filas del triangulo
Obtener la ultima lista que es el valor que necesitamos
Aplicar la forma "Lazy", que es lo pedido|#


;;(build_filitas filita)
;;Se crea una lista con las filas del triangulo de Pascal
;;Retorna la lista con las filas
  
(define(build_filitas  filita)
  (delay
    (map +(cons 0 filita) (append filita '(0))) ;A todos los valores le aplica la misma funcion (map) y se agregan a la lista creada
    ) 
  ) 

;;(filitaspascal l1 l2)
;;Se crea una lista nueva donde se ingresarán todas las filas que fueron creadas hasta el valor n y se aplicara la evaluación perezosa
;;Retornará una lista con todas las filas del triangulo.

(define(filitaspascal l1 l2)
  (if ( = l2 0)  ;Si la lista es nula, devuelve una lista vacia
      '()
      (cons l1 (filitaspascal(force(build_filitas l1))(- l2 1))) ;Se fuerza (force) para la creación de la lista
      )
  )   

(define (lazypascal n)
  
  (set! n ( + n 1)) ;Re-ligar la variable n para el problema
  
  ;;(last_row list)
  ;;El valor n es el ingresado por el usuario en lazypascal, n es para ver el piso que se quiere buscar
  ;;Retornará la ultima fila del triangulo que es lo que se pide

  (define (last_row list)
    
    (list-ref  list (- n 1))) ;Retorna el elemento de la lista en la posicion dada (list-ref). En este caso, la ultima posicion.
  
  (last_row (filitaspascal (list 1) n))) ;Se usa list 1, para que el valor siempre sea uno, si se pone un 2, duplica todos los valores del triangulo
