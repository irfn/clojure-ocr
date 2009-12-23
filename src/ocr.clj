(ns ocr		
	(:use string-ops))
(require '[clojure.contrib.str-utils2 :as s])

(defn codes
	"reduced line versions of indexes"
	[]
	(to-array (list
						 " \\| ___\\|\\|( ){0,3}" 
						 " \\|\\|___ \\|\\|( ){0,3}"  
						 "_   \\|\\|( ){0,3}"  
						 "\\|\\|___  \\|( ){0,3}"  
						 " \\| ___  \\|( ){0,3}"  
						 " \\|  _  \\|\\|( ){0,3}"  
						 "___ \\|\\|( ){0,3}"  
						 "  \\|___ \\| ( ){3}"  
						 " \\|\\|( ){0,3}")))

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

(defn decode
	[text idx]
	(s/replace-first text (re-pattern (aget (codes) idx)) (str (- (alength (codes)) idx))))

(defn ocr-parse 
	"sample ocr"
	[text-be-parsed]
	(s/ltrim (areduce 
	 (codes)
	 idx 
	 ret 
	 (reduce-to-single-line (lines text-be-parsed)) 
	 (decode ret idx))))