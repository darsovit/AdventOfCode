(ns aoc-day4.core-test
  (:require [clojure.test :refer :all]
            [aoc-day4.core :refer :all]))

(deftest md5-test
  (testing "MD5 from jizhang/md5.clj"
    (is (= "000001dbbfa3a5c83a2d506429c7b00e" (md5 "abcdef609043")))))

(deftest example1-test
  (testing "Example 1 test from AoC website"
    (is (= 609043 (find-advent-coin "abcdef")))))

(deftest example2-test
  (testing "Example 2 test from AoC website"
    (is (= 1048970 (find-advent-coin "pqrstuv")))))

