;; problem at https://www.facebook.com/hackercup/problems.php?pid=321892127915788&round=189890111155691

(ns hackercup2013.card-game
  (:use hackercup2013.core)
  (:require [clojure.string :as str]
            [clojure.math.combinatorics :as comb]
            [clojure.java.io :as io]))

(defn process-file-2 [f input output]
  (with-open [output-file (io/writer output)
              input-file (io/reader input)]
    (doseq [output-line
            (map (partial format "Case #%d: %s\n" )
                 (iterate inc 1)
                 (map #(apply f %)
                      
                      (partition 2
                                 (drop 1
                                       (line-seq input-file) ))))]
        (do (.write output-file output-line)
            (print output-line)
            ))))

(def factorial
  (memoize (fn [n]
             (reduce *' (range 1 (inc n))))))

(defn nCks [k]
  (let [fac (factorial k)]
    (map #(/ % fac)
         (reductions (fn [acc n]
                       (* acc (/ n (- n k))))
                     fac
                     (iterate inc (inc k))))))

;;;; Slow obvious soln
;; (defn sum-max-of-subsets [cards k]
;;   (reduce + (map #(apply max %) (comb/combinations cards k))))

(defn sum-max-of-subsets [cards k]
  (let [sorted (drop (dec k) (sort cards))
        nck (nCks (dec k))
        ]

    (mod (reduce +'
                 (map * sorted nck))
         1000000007
         )))

(defn bigparse [s]
  (bigint (Integer. s)))

(defn parse-input [line1 line2]
  (let [k (bigparse (second (str/split line1 #"\s+")))
        cards (map bigparse (str/split line2 #"\s+"))
        ]
    (sum-max-of-subsets cards k)
    ))

(defn -main []
  (process-file-2 parse-input "card_game.txt" "card_game_result.txt"))