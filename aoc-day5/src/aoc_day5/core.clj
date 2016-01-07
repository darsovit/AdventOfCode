(ns aoc-day5.core
  (:gen-class))

(defn has-no-naughty-string-combo
  "Returns true if the string has no naughty string combos from AoC Day 5"
  [possibly-nice]
  (if (re-find #"ab|cd|pq|xy" possibly-nice) 
    false
    true))

(defn contains-letter-twice-in-a-row
  "Returns true if there is a letter that appears twice in a row"
  [possibly-nice]
  (loop [remaining-letters (seq possibly-nice)]
    (if (> 2 (count remaining-letters) )
      false
      (let [[first & rest] remaining-letters] 
        (if (= first (nth rest 0))
          true
          (recur rest))))))

(defn is-string-nice
  "Returns true if the string is nice per rules in Advent of Code day 5"
  [possibly-nice]
  (if (and (re-find #"[aeiou].*[aeiou].*[aeiou]" possibly-nice) (contains-letter-twice-in-a-row possibly-nice) (has-no-naughty-string-combo possibly-nice))
    true
    false))

(defn contains-repeating-pair-of-letters
  "Returns true if the string contains a pair of letters that repeats itself"
  [possibly-nice]
  (loop [remaining-letters (seq possibly-nice)]
    (if (> 4 (count remaining-letters) )
      false
      (let [[first second & rest] remaining-letters]
        (if (re-find (re-pattern (clojure.string/join [first second])) (clojure.string/join rest))
          true
          (recur (cons second rest)))))))

(defn contains-letter-that-repeats-after-one-other
  "Returns true if the string contains a repeating letter with one letter between"
  [possibly-nice]
  (loop [remaining-letters (seq possibly-nice)]
    (if (> 3 (count remaining-letters) )
      false
      (let [[first second third & rest] remaining-letters]
        (if (= first third)
          true
          (recur (cons second (cons third rest))))))))

(defn is-string-nice-5b
  "Returns true if the string is nice per rules in Advent of Code day 5 part 2"
  [possibly-nice]
  (and (contains-repeating-pair-of-letters possibly-nice) (contains-letter-that-repeats-after-one-other possibly-nice)))

(defn count-nice-strings
  "Returns count of nice strings, given a sequence of strings"
  [nice-function lines]
  (loop [remaining-lines lines nicecount 0]
    (if (empty? remaining-lines)
      nicecount
      (let [[first & rest] remaining-lines]
        (if (nice-function first)
          (recur rest (inc nicecount))
          (recur rest nicecount))))))

(defn count-nice-strings-5a
  "Returns count of nice strings with 5A rules"
  [lines]
  (count-nice-strings is-string-nice lines))

(defn count-nice-strings-5b
  "Returns count of nice strings with 5B rules"
  [lines]
  (count-nice-strings is-string-nice-5b lines))

(defn load-lines-from-file
  "Loads lines from the given file"
  [filename]
  (clojure.string/split (slurp filename) #"\n"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

