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
    (println p1 "and" p2 "went out with " (count c) "chaporones.")
     println (apply str c)
    )