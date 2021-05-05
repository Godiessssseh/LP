#lang scheme

;;(listasum l1)
;; Recorre la lista y crea una lista con los resultados de obtener la suma
;; retorna la lista nueva

(define listasum
  (lambda (l1)
    (if (null? l1) 
        '() ;Lista que se quiere retornar
        (cons (suma_max l1) (listasum (cdr l1))) ;Se separa en pares (cons)
        )
    )
  )

;;(suma_max l1)
;; Obtiene la suma máx de la lista entregada
;; Retorna la suma en un valor entero

(define suma_max
  (lambda (l1)
    (cond ;Casos bordes del programa
      ((null? l1)0) ;No tiene elementos, retorna 0
      ((null? (cdr l1)) (car l1)) ;Tiene solo 1, retorna el valor
      (else
       (+ (car l1) (apply max 0 (listasum (cddr l1)))) ;Apply max 0 y la lista correspondiente.
       )
      )
    )
  )

;funcion pedida

(define monedas_rec 
  (lambda (l1)
    (apply max 0 (listasum l1))
    )
  )