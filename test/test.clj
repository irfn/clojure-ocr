(ns test
  (:use clojure.test))

(def tests
     ['test.ocr])

(doseq [test tests] (require test))

(apply run-tests tests)

(shutdown-agents)