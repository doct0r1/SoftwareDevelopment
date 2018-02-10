;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname Quiz) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(require 2htdp/image)

;; Image1 && Image2 -> Boolean
;; two images and produces true if the first is larger than the second (width*height) for image1 > image2

(check-expect (bigger-img? (square 10 "solid" "red") (rectangle 10 5 "solid" "black"))
              #t)
(check-expect (bigger-img? (square 10 "solid" "red") (rectangle 10 10 "solid" "black"))
              #f)
(check-expect (bigger-img? (square 10 "solid" "red") (rectangle 10 20 "solid" "black"))
              #f)

;(define (bigger-img? img1 img2) false) ;Stub

;(define (bigger-img? img1 img2) ;template
;  (... img1 img2))

(define (bigger-img? img1 img2)
  (> (* (image-width img1) (image-height img1)) (* (image-width img2) (image-height img2))))
