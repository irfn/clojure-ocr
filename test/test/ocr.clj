(ns test.ocr
  (:use clojure.test)
  (:use ocr))

(deftest test-lines
	(are [description split-lines some-text] (= split-lines (lines some-text))
  "splitting lines" ["  _  _     _  _  _  _  _",
										 "| _| _||_||_ |_   ||_||_|",
										 "||_  _|  | _||_|  ||_| _|"] ["  _  _     _  _  _  _  _\n| _| _||_||_ |_   ||_||_|\n||_  _|  | _||_|  ||_| _|"]))

(deftest test-tip
  (is (= "t" (tip "tip"))))

(deftest test-tail
  (is (= "ail" (tail "tail"))))

(deftest test-column
  (is (= '("a" "b" "c") (column ["a1234","b1234","c1234"] tip))))

(deftest test-slice
  (is (= " ||  |___ | " (slice ["  _ ",
																"| _|",
																"||_ "]))))

(deftest test-ocr-parse
	(are [description ocr-result some-text] (= ocr-result (ocr-parse some-text))
  "dumb ocring" 123456789 ["  _  _     _  _  _  _  _\n| _| _||_||_ |_   ||_||_|\n||_  _|  | _||_|  ||_| _|"]))