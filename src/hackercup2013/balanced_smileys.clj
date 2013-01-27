(ns hackercup2013.balanced-smileys
  (:use hackercup2013.core)
  (:require [clojure.string :as str]))

(defn balanced? [s]
  "YES")

(defn -main []
  (process-file balanced? "balanced.txt" "balanced-result.txt"))