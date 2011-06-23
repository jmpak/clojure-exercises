(ns examples.interop
    (:use clojure.contrib.str-utils)
    (:import (java.io File) (org.xml.sax InputSource) (org.xml.sax.helpers DefaultHandler) (java.io StringReader) (javax.xml.parsers SAXParserFactory)))
    
(defn describe-class [c]
    {:name (.getName c)
     :final (java.lang.reflect.Modifier/isFinal (.getModifiers c))})

(def print-element-handler
    (proxy [DefaultHandler] []
        (startElement
         [uri local qname atts]
         (println (format "Saw element: %s" qname)))))
         
(defn demo-sax-parse [source handler]
    (.. SAXParserFactory newInstance newSAXParser 
        (parse (InputSource. (StringReader. source))
            handler)))
         
(defn dotimes-test
    [] (dotimes [i 5] 
        (.start (Thread. (fn [] (Thread/sleep (rand 500))
            (println (format "%d on %s" i (Thread/currentThread))))))))         