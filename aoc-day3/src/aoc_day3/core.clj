(ns aoc-day3.core
  (:gen-class))

(require '[clojure.set :refer [union]])

(defn move-right
  [pos]
  (hash-map :x (+ (:x pos) 1) :y (:y pos)))

(defn move-left
  [pos]
  (hash-map :x (- (:x pos) 1) :y (:y pos)))

(defn move-up
  [pos]
  (hash-map :x (:x pos) :y (+ (:y pos) 1)))

(defn move-down
  [pos]
  (hash-map :x (:x pos) :y (- (:y pos) 1)))

(defn determine-pos
  "Calculates new position based on value"
  [pos direction]
  (case direction
    \> (move-right pos)
    \^ (move-up pos)
    \< (move-left pos)
    \v (move-down pos)
    pos
    ))

(defn deliver-to-house
  "Given a direction and a state with :curpos and :visited-house-set, returns a new state taking the given direction"
  [direction currentstate]
  (let [new-position (determine-pos (:curpos currentstate) direction)]
    (do 
      (println (:curpos currentstate) " " new-position)
    {:curpos new-position :visited-house-set (conj (:visited-house-set currentstate) new-position)})))


(defn santa-delivery
  "Given a string input for directions, counts houses visited by santa"
  [directions]
  (let [currentpos {:x 0 :y 0}]
    (loop [remaining-directions (seq directions) currentstate {:curpos currentpos :visited-house-set #{currentpos}}]
      (if (empty? remaining-directions)
        (count (:visited-house-set currentstate))
        (let [[direction & remaining] remaining-directions]
          (recur remaining (deliver-to-house direction currentstate)))))))

(defn santa-and-robo-delivery
  "Given a string input for directions, counts houses visited by santa"
  [directions]
  (let [currentpos {:x 0 :y 0}]
    (loop [remaining-directions (seq directions) santastate {:curpos currentpos :visited-house-set #{currentpos}} robostate {:curpos currentpos :visited-house-set #{currentpos}}]
      (if (empty? remaining-directions)
        (count (union (:visited-house-set santastate) (:visited-house-set robostate)))
        (let [[santadirection robodirection & remaining] remaining-directions]
          (recur remaining (deliver-to-house santadirection santastate) (deliver-to-house robodirection robostate)))))))

;  (loop [remaining-directions (seq directions) currentstate {:curpos {:x 0 :y 0}
;  (loop [remaining-directions (seq directions) visited-house-set #{{:x 0 :y 0}}]
;   (if (empty? remaining-directions)
;     (count visited-house-set)
;     (let [[direction & remaining] remaining-directions]
;       (recur remaining
;              (into visited-house-set
;                    (set
;     + (count (seq directions)) 1))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (do
    (def s (slurp "input.txt"))
    (println (santa-delivery s))
    (println (santa-and-robo-delivery s))
    ))
