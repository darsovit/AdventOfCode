(ns aoc-day3.core-test
  (:require [clojure.test :refer :all]
            [aoc-day3.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

(deftest right-test
  (testing "move-right from origin increments x"
    (is (= (move-right {:x 0 :y 0}) {:x 1 :y 0}))
    (is (= (move-right {:x -1 :y 0}) {:x 0 :y 0}))
    ))

(deftest no-moves-is-1-house
  (testing "no moves delivers presents to 1 house"
    (is (= (santa-delivery "") 1))))

(deftest move-right-is-2-houses
  (testing "move-right from origin results in two houses visited"
    (is (= (santa-delivery ">") 2))))

(deftest move-in-square-is-4-houses
  (testing "move in a square from origin, results in 4 houses visited"
    (is (= (santa-delivery "^>v<") 4))))

(deftest move-back-and-forth-results-in-2-houses
  (testing "move up and down repeatedly, resulst in 2 houses visited"
    (is (= (santa-delivery "^v^v^v^v^v") 2))))


