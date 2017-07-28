(ns es.joaquincaro.katas.Greeting)

(defn upper-case? [name] (and (> (count name) 0) (every? #(Character/isUpperCase %) name)))

(defn personalized-greeting [name] (str "Hello, " name "."))

(defn anonymous-greeting [] (personalized-greeting "my friend"))

(defn more-of-two?
  [names]
  (if (> (count names) 2) true false))

(defn greet-shouting [name]
      ((comp clojure.string/upper-case personalized-greeting) name))

(defn multi-greet
  [names]
  (str "Hello, "
       (clojure.string/join ", and " [(clojure.string/join ", " (butlast names)) (last names)])
       "."))
(defn greet-two
  [names]
  (str "Hello, " (clojure.string/join " and " names) "."))

(defmulti greet-one (fn [name] (nil? name)) )
(defmethod greet-one true [_] (anonymous-greeting))
(defmethod greet-one false
  [name]
  (if (upper-case? name)
    (greet-shouting name)
    (personalized-greeting name)))


(defmulti greet (fn [name] (coll? name)) )
(defmethod greet true
  [names]
  (if (more-of-two? names)
    (multi-greet names)
    (greet-two names)))

(defmethod greet false
  [name]
  (greet-one name))