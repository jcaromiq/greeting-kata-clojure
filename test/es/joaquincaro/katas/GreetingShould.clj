(ns es.joaquincaro.katas.GreetingShould
    (:require
        [midje.sweet :refer :all]
        [es.joaquincaro.katas.Greeting :refer :all]))

(facts
  "About The Greeting Kata"
  (fact
    "Greet given a name\n"
    (greet "Bob") => "Hello, Bob."

    )

  )

