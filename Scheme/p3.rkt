#lang scheme

#|2 listas y sacar un valor random del largo+1
Ver si son del mismo largo
Agregar los valores que se cambian a otras listas nuevas
|#

(define (crossrd l1 l2) ;Lista 1 y 2
  (define ran1 (random (+ 1 (length l1)))) ;Random para l1 y l2 
  (define ran2 (random (+ 1 (length l2))))
  (cond
    ((equal? (length l1) (length l2))
     ;Si tienen el mismo largo hace el codigo.
     
     (let recorrerlist ((contador 1) (x l1) (z l2) (newlist1 (list)) (newlist2 (list))) ;el indice a cambiar, x y z representan listas, y se crean listas nuevas
       (if (= contador (+ (length l1) 1)) ;Se acaba cuando el i sea igual al largo de la lista+1
           (list newlist1 newlist2)
           (cond ;Condicionales que tendrá en base al random y contador

             
             ((> contador ran1) (recorrerlist (+ contador 1) (cdr x) (cdr z) (append newlist1 (list(car x))) (append newlist2 (list(car z)))))
 
             ;Si se cumple, agrega de esa forma a la lista, agregando valores de una lista a la otra. Lo mismo para para los otros casos
             ((< contador ran1) (recorrerlist (+ contador 1) (cdr x) (cdr z) (append newlist1 (list(car x))) (append newlist2 (list(car z)))))
             
             ((or (= contador ran1) (< contador (+ ran2 1)))
              (recorrerlist (+ contador 1) (cdr x) (cdr z) (append newlist1 (list(car z))) (append newlist2 (list(car x)))))
             
             (else #f)))) ;Si no cumple ninguna, es falso
     )
    )
  )