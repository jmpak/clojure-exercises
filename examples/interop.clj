(ns examples.interop
    (:use clojure.contrib.str-utils)
    (:import (java.io File)))

(defn describe-class [c]
    {:name (.getName c)
     :final (java.lang.reflect.Modifier/isFinal (.getModifiers c))})
