(ns test.ocr
  (:use clojure.test)
	(:use string-ops)
  (:use ocr))

(deftest test-column
  (is (= '("a" "b" "c") (column ["a1234","b1234","c1234"] tip))))

(deftest test-reduce-to-single-line
  (is (= " ||  |___ | " (reduce-to-single-line ["  _ ",
																"| _|",
																"||_ "]))))
(deftest test-ocr-parse
	(are [description ocr-result some-text] (= ocr-result (ocr-parse some-text))
  "dumb ocring" 123456789 ["  _  _     _  _  _  _  _\n| _| _||_||_ |_   ||_||_|\n||_  _|  | _||_|  ||_| _|"]))