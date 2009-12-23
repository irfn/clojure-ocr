(ns test.ocr
  (:use clojure.test)
	(:use string-ops)
  (:use ocr))

(deftest test-column
  (is (= '("a" "b" "c") (column ["a1234","b1234","c1234"] tip))))


(deftest test-reduce-to-single-line
	(is (= 
			 "    ||  |___ |    ___ || |  _  || | ___  | ||___  |   _   || ||___ || | ___||"
			 (reduce-to-single-line (lines 
"
   _  _     _  _  _  _  _
 | _| _||_||_ |_   ||_||_|
 ||_  _|  | _||_|  ||_| _|")))))
                 
(deftest test-ocr-parse
	(is (= 
			 "123456789"
			 (ocr-parse 
"  
   _  _     _  _ _  _  _
 | _| _||_||_ |_  ||_||_|
 ||_  _|  | _||_| ||_| _|"))))
                 
                 
