(ns hackercup2013.card-game-test
  (:use clojure.test
        hackercup2013.core
        hackercup2013.card-game
        ))

(def decksize 10000)
(defn random-vector []
  (vec (take decksize (repeatedly #(int (rand 2000000000))))))

(deftest cardgame
  (testing "examples"
    (are [cards k answer] (= (sum-max-of-subsets cards k) answer)
         [3 6 2 8] 3 30 
         [10 20 30 40 50] 2 400
         [0 1 2 3 5 8] 4 103
         [1069 1122] 2 1122
         [10386 10257 10432 10087 10381 10035 10167 10206 10347 10088] 5 2621483))
  (testing "large-input"
    (dotimes [n 25]
      (let [v (random-vector)
            k (int (Math/floor (rand decksize)))]
        (time (sum-max-of-subsets v k)))))

  )
  