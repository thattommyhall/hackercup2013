(ns hackercup2013.find-the-min-test
  (:use clojure.test
        hackercup2013.core
        hackercup2013.find-the-min
        ))

(deftest find-the-min
  (testing "min fn"
    (are [x y] (= (find-min x) y)
         "not ready to handle 2 line input yet" 3
         )))