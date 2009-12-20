(ns ocr)		
(require '[clojure.contrib.str-utils2 :as s])

(defn only-a-tip?
	"True if s is of length 0 or 1"
	[line-of-text]
	(>= 1 (.length line-of-text)))

(defn lines
	"splits by newlines"
	[text]
	(seq (.split (first text) "\n")))

(defn digitize
	"read 3 lines at a time"
	[lines]
	(1234))

(defn tip
	"tip of a string"
	[string-value]
	(str (first string-value)))

(defn tail
	"tip of a string"
	[string-value]
	(apply str (rest string-value)))
	
(defn column
	"concat result of operations"
	[lines, operation]
	(map operation lines))

(defn tip-slice-of
	"chop off the tips"
	[lines]
	(apply str (column lines tip)))
									
(defn reduce-to-single-line
	"wtf"
	[lines]	
	(loop [
				 aggregate "" 
				 lines-of-text lines]
		(let [tip-slice (tip-slice-of lines-of-text)
					tip-aggregate (.concat aggregate tip-slice)]
			(if (every? only-a-tip? lines-of-text)		 
				tip-aggregate
				(recur tip-aggregate (column lines-of-text tail)))))) 

(defn ocr-parse 
	"sample ocr"
	[text-be-parsed] 
	(lines text-be-parsed))