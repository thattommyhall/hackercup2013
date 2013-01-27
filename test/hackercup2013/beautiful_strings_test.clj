(ns hackercup2013.beautiful-strings-test
  (:use clojure.test
        hackercup2013.core
        hackercup2013.beautiful-strings
        ))

(deftest test-beauty
  (testing "beauty fn"
    (are [x y] (= (beauty x) y)
         "ABbCcc" 152
         "Good luck in the Facebook Hacker Cup this year!" 754
         "Ignore punctuation, please :)" 491
         "Sometimes test cases are hard to make up." 729
         "So I just go consult Professor Dalves" 646)))