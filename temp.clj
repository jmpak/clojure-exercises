(use 'clojure.contrib.str-utils)
(def visitors (ref #{}))

(defn hello 
    "Writes hello message to *out*. Calls you by username.
    Knows if you have been here before."
    [username]
    (dosync
        (let [past-visitor (@visitors username)]
            (if past-visitor
                (str "Welcome back, " username)
                (do
                    (alter visitors conj username)
                    (str "Hello, ", username))))))


(defn date [p1 p2 & c]
    (println p1 "and" p2 "went out with" (str-join " " c) "chaporones."))
    
(defn indexable-word? [word]
    (> (count word) 2))    
    
(defn make-greeter [greeting-prefix]
    (fn [username] (str greeting-prefix ", " username)))
    
(defn triple [number] (* 3 number))    

(defn square-corners [bottom left size]
    (let [[_ top right] [1 3 5]]
        [[bottom left] [top left] [top right] [bottom right]]
        ))
        
(defn greet-author-1 [author]
    (println "Hello," (:first-name author)))        
    
(defn greet-author-2 [{fname :first-name}]
    (println "Hello," fname))    
    
(defn ellipsize [words]
    (let [[w1 w2 w3] (re-split #"\s+" words)]
        (str-join " " [w1 w2 w3 "..."])))    

(defn side-effect [number] 
    (if (< number 100)
        "yes"
        (do
            (println "sadfdasf")
            "no")))        