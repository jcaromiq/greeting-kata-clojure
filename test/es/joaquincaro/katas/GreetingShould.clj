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
        (greet "JERRY") => "HELLO, JERRY.")

  (fact "Greet two names"
        (greet ["Jill", "Jane"]) => "Hello, Jill and Jane.")

  (fact "Greet three names"
        (greet ["Amy", "Brian", "Charlotte"]) => "Hello, Amy, Brian, and Charlotte.")

  (fact "Allow mixing of normal and shouted names by separating the response into two greetings"
        (greet ["Amy", "BRIAN", "Charlotte"]) => "Hello, Amy and Charlotte. AND HELLO BRIAN!")

  (fact "Allow mixing of normal and shouted names by separating the response into two greetings, several upper case ones"
        (greet ["Amy", "BRIAN", "JAMES" "Charlotte"]) => "Hello, Amy and Charlotte. AND HELLO BRIAN AND JAMES!")

  (fact "Allow split any entries in name if a string containing a comma, split it as its own input"
        (greet ["Bob", "Charlie, Dianne"]) => "Hello, Bob, Charlie, and Dianne.")
  )

