(ns isbn-verifier)


(defn char->int [char]
  (if (= char \X)
    10
    (Character/digit char 10)))

(defn sum-isbn [isbn]
  (->> isbn
       (map char->int)
       (map * (range 10 0 -1))
       (apply +)))

(defn match-isbn-pattern? [isbn]
  (or (re-matches #"\d{9}[\dX]" isbn) "-1"))

(defn find-x-isbn [isbn]
  (apply str (re-seq #"[\dX]" isbn)))

(defn isbn? [isbn]
  (->> isbn
       find-x-isbn
       match-isbn-pattern?
       sum-isbn
       (#(mod % 11))
       zero?))