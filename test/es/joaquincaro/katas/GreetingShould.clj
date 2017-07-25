(ns es.joaquincaro.katas.GreetingShould
    (:require
      [midje.sweet :refer :all]
      [es.joaquincaro.katas.Greeting :refer :all]))

(facts
  "About The Greeting Kata"

  (fact "Greet given a name"
        (greet "Bob") => "Hello, Bob.")

  (fact "Greet with stand-it if name is null"
        (greet nil) => "Hello, my friend.")

  (fact "Greet with upper if name is in upper"
        (greet "PEPE") => "HELLO, PEPE.")


)

