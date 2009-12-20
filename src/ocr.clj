(ns ocr		
	(:use string-ops))

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