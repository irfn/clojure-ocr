(ns test.ocr
  (:use clojure.test)
  (:use ocr))

(deftest test-foo
  (are [description foo-result foo-params] (= foo-result (foo foo-params))
       "gibberish" 30 [10 10 10]
       "licorice" 20 [5 5 10]
       "amateurish" 13 [5 3 5]))

