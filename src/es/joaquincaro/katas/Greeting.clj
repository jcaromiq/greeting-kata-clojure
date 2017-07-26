(ns es.joaquincaro.katas.Greeting)

(defn upper-case? [name] (and (> (count name) 0) (every? #(Character/isUpperCase %) name)))

(defn personalized-greeting [name] (str "Hello, " name "."))

(defn anonymous-greeting [] (personalized-greeting "my friend"))

(defn greet-shouting [name]
      ((comp clojure.string/upper-case personalized-greeting) name))

(defmulti greet (fn [name] (nil? name)) )

(defmethod greet true [_] (anonymous-greeting))


(defmethod greet false
           [name]
           (if (upper-case? name)
             (greet-shouting name)
             (personalized-greeting name)))