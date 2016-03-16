(ns aoc-day6.core
  (:gen-class))

(defn load-lines-from-file
  "Loads lines from the given file"
  [filename]
  (clojure.string/split (slurp filename) #"\n"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
