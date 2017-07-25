(ns es.joaquincaro.katas.Greeting)

(defn upper-case? [name] (and (> (count name) 0) (every? #(Character/isUpperCase %) name)))

(defmulti greet (fn [name] [(nil? name) (upper-case? name)]) )

(defmethod greet [true false] [_] "Hello, my friend.")
(defmethod greet [false false] [n] ( str "Hello, " n "."))

(defmethod greet [true true] [_] "HELLO, MY FRIEND.")
(defmethod greet [false true] [n] ( str "HELLO, "(clojure.string/upper-case n)  "."))
