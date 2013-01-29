(ns hackercup2013.beautiful-strings
  (:use hackercup2013.core)
  (:require [clojure.string :as str]))

(def letters
  (set "abcdefghijklmnopqrstuvwxyz"))

(defn counts [s]
  (frequencies (filter letters (str/lower-case s))))

(defn sorted-by-val [m]
  (into (sorted-map-by (fn [key1 key2]
                         (compare [(get m key2) key2]
                                  [(get m key1) key1])))
         m)
)
(defn beauty [s]
  (reduce + (map *
                 (vals (sorted-by-val (counts s)))
                 (iterate dec 26))))

(defn -main []
  (process-file beauty "beautiful_strings.txt" "beautiful_strings_result.txt"))