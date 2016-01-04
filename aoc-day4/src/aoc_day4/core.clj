(ns aoc-day4.core
  (:gen-class))

(import 'java.security.MessageDigest
        'java.math.BigInteger)

(defn md5 [s]
  (let [algorithm (MessageDigest/getInstance "MD5")
        size (* 2 (.getDigestLength algorithm))
        raw (.digest algorithm (.getBytes s))
        sig (.toString (BigInteger. 1 raw) 16)
        padding (apply str (repeat (- size (count sig)) "0"))]
    (str padding sig)))

; for full digest support, use clj-digest: https://github.com/tebeka/clj-digest

(defn test-md5-for-coin
  "Tests if the given hash starts with at least five zeros"
  [md5hash]
  (re-find #"^00000" md5hash))

(defn test-md5-for-coin6
  "Tests if the given hash starts with at least six zeros"
  [md5hash]
  (re-find #"^000000" md5hash))

(defn find-advent-coin
  "Find the Advent Coin based on input secret string"
  [secret]
  (loop [variable 1]
    (if (test-md5-for-coin (md5 (str secret variable)))
      variable
      (recur (inc variable)))))

(defn find-advent-coin6
  "Find the Advent Coin based on input secret string"
  [secret]
  (loop [variable 1]
    (if (test-md5-for-coin6 (md5 (str secret variable)))
      variable
      (recur (inc variable)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
