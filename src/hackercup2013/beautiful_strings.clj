(ns hackercup2013.beautiful-strings
  (:use hackercup2013.core)
  (:require [clojure.string :as str]))

(def letters
  (set "abcdefghijklmnopqrstuvwxyz"))

(defn counts [s]
  (frequencies (filter letters (str/lower-case s))))

(defn beauty [s]
  (reduce + (map *
                 (reverse (sort (vals (counts s))))
                 (iterate dec 26))))

(defn -main []
  (process-file beauty "beautiful_strings.txt" "beautiful_strings_result.txt"))