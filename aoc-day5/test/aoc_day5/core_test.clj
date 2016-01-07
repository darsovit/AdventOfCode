(ns aoc-day5.core-test
  (:require [clojure.test :refer :all]
            [aoc-day5.core :refer :all]))

(deftest sample-test1
  (testing "Sample test 1"
    (is (= true (is-string-nice "ugknbfddgicrmpon")))))

(deftest sample-test2
  (testing "Sample test 2"
    (is (= true (is-string-nice "aaa")))))

(deftest sample-test3
  (testing "Sample Test 3"
    (is (= false (is-string-nice "jchzalrnumimnmhp")))))

(deftest sample-test4
  (testing "Sample Test 4"
    (is (= false (is-string-nice "haegwjzuvuyypxyu")))))

(deftest sample-test5
  (testing "Sample Test 5"
    (is (= false (is-string-nice "dvszwmarrgswjxmb")))))

(deftest testcountnice
  (testing "test count-nice-strings"
    (is (= 2 (count-nice-strings-5a ["aaa" "aaa"])))))

(deftest day5b-sample-test1
  (testing "5b Sample test 1"
    (is (= true (is-string-nice-5b "qjhvhtzxzqqjkmpb")))))

(deftest day5b-sample-test2
  (testing "5b Sample test 2"
    (is (= true (is-string-nice-5b "xxyxx")))))

(deftest day5b-sample-test3
  (testing "5b Sample test 3"
    (is (= false (is-string-nice-5b "uurcxstgmygtbstg")))))

(deftest day5b-sample-test3
  (testing "5b Sample test 4"
    (is (= false (is-string-nice-5b "ieodomkazucvgmuy")))))
