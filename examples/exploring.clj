(ns examples.exploring
    (:use clojure.contrib.str-utils)
    (:import (java.io File)))
    
(defn is-small? [number]
    (if (< number 1000) "yes" "no"))
    
(defn is-small? [number]
    (if (< number 1000)
        (do (println "hello" number) "yes")
        "no"))
    
(defn countdown [result x]
    (if (zero? x)
        result
        (recur (conj result x) (dec x))))
    
(defn indexed [coll] (map vector (iterate inc 0) coll))

(defn index-filter [pred coll]
    (when pred
        (for [[idx elt] (indexed coll) :when (pred elt)] idx)))
        
(defn index-of-any [pred coll]
    (first (index-filter pred coll)))        

    

(defn #^{:tag String} shout
    [#^{:tag String} s] (.toUpperCase s))


(defn #^String shout
    [#^String s] (.toUpperCase s))
 
(defn shout
    ([s] (.toUpperCase s))
    {:tag String})
    
