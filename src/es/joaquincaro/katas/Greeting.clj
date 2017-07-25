(ns es.joaquincaro.katas.Greeting)

(defn upper-case? [name] (and (> (count name) 0) (every? #(Character/isUpperCase %) name)))

(defmulti greet (fn [name] [(nil? name) (upper-case? name)]) )

(defmethod greet [true *] [_] "Hello, my friend.")
(defmethod greet [false false] [name] ( str "Hello, " name "."))

(defmethod greet [false true] [name] ( str "HELLO, "(clojure.string/upper-case name)  "."))
