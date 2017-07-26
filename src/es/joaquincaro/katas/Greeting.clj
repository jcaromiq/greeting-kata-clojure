(ns es.joaquincaro.katas.Greeting)

(defn upper-case? [name] (and (> (count name) 0) (every? #(Character/isUpperCase %) name)))

(defmulti greet (fn [name] [(nil? name) (upper-case? name)]) )

(defn anonymous-greeting [] (personalized-greeting "my friend"))

(defmethod greet [true false] [_] (anonymous-greeting))

(defn personalized-greeting [name] (str "Hello, " name "."))
(defmethod greet [false false] [name] (personalized-greeting name))

(defmethod greet [false true] [name] ( (comp clojure.string/upper-case personalized-greeting) name))
