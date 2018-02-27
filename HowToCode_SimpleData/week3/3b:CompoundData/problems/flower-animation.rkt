;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname flower-animation) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(require 2htdp/image)
(require 2htdp/universe)

;; a flower planting program

;; Constants
;;===========

(define WIDTH 1900)
(define HEIGHT 900)
(define MTS (empty-scene WIDTH HEIGHT "green"))

(define CENTER (circle 15 "solid" "lightorange"))
(define PETAL (ellipse 30 50 "solid" "purple"))
(define FLOWER
  (overlay (above CENTER(rectangle 1 10 0 "white"))
           (overlay/align "center" "top" (above (beside (rotate 217 PETAL) (rectangle 1 1 0 "white") (rotate 145 PETAL))
                                                (rotate 180 (beside (rotate 73 PETAL) (rectangle 10 0 0 "white") (rotate 288 PETAL))))
                          (above (rectangle 1 61 0 "white") PETAL))))

;; Data Definitions
;; ================

(define-struct flower (x y size))
;; Flower is (make-flower Integer Integer Natural)
;; interp. a flower with x position, y position, and a side length in pixels
(define F0 (make-flower 0 0 0))
(define F1 (make-flower (/ WIDTH 2) (/ HEIGHT 2) 15))

#;
(define (fn-for-flower f)
  (... (flower-x f)
       (flower-y f)
       (flower-size f)))

;; Template rules used:
;;  - Compound: 3 fields


;; Functions
;; =========

;; Flower -> Flower
;; starts the animation: start with (main (make-flower (/ WIDTH 2) (/ HEIGHT 2) 0))

(define (main f)
  (big-bang f
    (on-tick          tock)   ; Flower -> Flower
    (to-draw        render)   ; Flower -> Image
    (on-mouse handle-mouse))) ; Flower Integer Integer MouseEvent -> Flower


;; Flower -> Flower
;; add 1 to the size of the flower every clock tick
(check-expect (tock (make-flower  0  0  5)) (make-flower  0  0  6))
(check-expect (tock (make-flower 20 30 20)) (make-flower 20 30 21))
(check-expect (tock (make-flower 30 40 50)) (make-flower 30 40 51))

;(define (took f) f) ;stub
; <took template from Flower>

(define (tock f)
  (make-flower (flower-x f)
               (flower-y f)
               (add1 (flower-size f))))


;; Flower -> Image
;; render the flower of the given size on the MTS at the correct x and y coordinates
(check-expect (render (make-flower 10 10 20)) (place-image (rotate 20 (scale (/ 20 100) FLOWER)) 10 10 MTS))
(check-expect (render (make-flower 20 20  0)) (place-image empty-image 20 20 MTS))
(check-expect (render (make-flower 10 10 40)) (place-image (rotate 40 (scale (/ 40 100) FLOWER)) 10 10 MTS))

;(define (render f) MTS) ;stub
; <took template from Flower>

(define (render f)
  (place-image (if (zero? (flower-size f))
                   empty-image
                   (rotate (flower-size f) (scale (/ (flower-size f) 100) FLOWER)))
               (flower-x f)
               (flower-y f)
               MTS))



;; Flower Integer Integer MouseEvent -> Flower
;; repalce the flower with a new one of size 0 at the mouse-click
(check-expect (handle-mouse (make-flower 0 0 0 ) 5 5 "button-down") (make-flower 5 5 0))
(check-expect (handle-mouse (make-flower 0 0 0 ) 5 5 "button-up") (make-flower 0 0 0))
(check-expect (handle-mouse (make-flower 50 50 55 ) 10 10 "button-down") (make-flower 10 10 0))

;(define (handle-mouse f x y me) f)
; <took from MouseEvent>

(define (handle-mouse f x y me)
  (cond [(mouse=? me "button-down")(make-flower x y 0)]
        [else f]))