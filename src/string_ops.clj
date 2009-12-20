(ns string-ops)		
(require '[clojure.contrib.str-utils2 :as s])

(defn only-a-tip?
	"True if s is of length 0 or 1"
	[line-of-text]
	(>= 1 (.length line-of-text)))

(defn lines
	"splits by newlines"
	[text]
	(seq (.split text "\n")))

(defn tip
	"tip of a string"
	[string-value]
	(str (first string-value)))

(defn tail
	"tip of a string"
	[string-value]
	(apply str (rest string-value)))