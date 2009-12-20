(ns test.string-ops
  (:use clojure.test)
  (:use string-ops))

(deftest test-lines
	(are [description split-lines some-text] (= split-lines (lines some-text))
  "splitting lines" ["  _  _     _  _  _  _  _",
										 "| _| _||_||_ |_   ||_||_|",
										 "||_  _|  | _||_|  ||_| _|"] "  _  _     _  _  _  _  _\n| _| _||_||_ |_   ||_||_|\n||_  _|  | _||_|  ||_| _|"))

(deftest test-tip
  (is (= "t" (tip "tip"))))

(deftest test-tail
  (is (= "ail" (tail "tail"))))
