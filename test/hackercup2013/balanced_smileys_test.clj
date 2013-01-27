(ns hackercup2013.balanced-smileys-test
  (:use clojure.test
        hackercup2013.core
        hackercup2013.balanced-smileys
        ))

(deftest smileys
  (testing "balanced?"
    (are [x y] (= (balanced? x) y)
         ":((" "NO"
         "i am sick today (:()" "YES"
         "(:)" "YES"
         "hacker cup: started :):)" "YES"
         ")(" "NO")))