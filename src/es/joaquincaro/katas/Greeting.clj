(ns es.joaquincaro.katas.Greeting)

(defn upper-case?
  [name]
  (and (> (count name) 0) (every? #(Character/isUpperCase %) name)))

(defn personalized-greeting
  [name]
  (if (nil? name)
    (personalized-greeting "my friend")
    (str "Hello, " name ".")))

(defn more-of-two?
  [names]
  (if (> (count names) 2) true false))

(defn greet-shouting [name]
  ((comp clojure.string/upper-case personalized-greeting) name))

(defn
  multi-greet
  [names]
  (str "Hello, "
       (clojure.string/join ", and " [(clojure.string/join ", " (butlast names)) (last names)])
       "."))

(defn greet-two
  [names]
  (str "Hello, " (clojure.string/join " and " names) "."))

(defn greet-one
  [name]
  (if (upper-case? name)
    (greet-shouting name)
    (personalized-greeting name)))


(defmulti greet (fn [name] (coll? name)))
(defmethod greet true
  [names]
  (let [names-lowers (filter (comp not upper-case?) names)
        names-uppers (filter upper-case? names)]
    (str (if (more-of-two? names-lowers)
      (multi-greet names-lowers)
      (greet-two names-lowers))
    (if (> (count names-uppers) 0)
      (str " AND HELLO ", (clojure.string/join " AND " names-uppers) "!")))
    ))


(defmethod greet false
  [name]
  (greet-one name))
