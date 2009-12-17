(ns test.ocr
  (:use clojure.test)
  (:use ocr))

(deftest test-foo
  (are [description foo-result foo-params] (= foo-result (foo foo-params))
       "strike" 30 [10 10 10]
       "spare" 20 [5 5 10]
       "no mark" 13 [5 3 5]))

