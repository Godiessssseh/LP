#lang scheme

;;(factorial n)
;;Descripcion: calcula el factorial de un numero ingresado
;;donde n es un numero entero
;;Retorno: el factorial del elemento n.
(define (factorial n)
  (let fac ((val 1) (f n))
    (if (= f 0)
        val
        (fac (* val f) (- f 1))
        )
    ) 
  )

;;(formula n x)
;;Descripcion: Aproxima el valor del seno utilizando la formula de MacLaurin 
;;Donde n es un valor entero y x es un valor real
;;Retorna el resultado de la formula.

(define (formula n x)
  (* (expt -1 n)
     (/ (expt x (+ (* 2 n) 1))
        (factorial (+ (* 2 n) 1))
        )
     )
  )

;Funcion pedida en el ejercicio

(define (seno x)
  (let repetir ((valor 0) (value 0)) 
    (if (= value 500)  ;Si es igual a 500, se cae y se va
        (exact->inexact valor)
        (repetir (+ valor (formula value x)) (+ value 1))
        )
    )
  )