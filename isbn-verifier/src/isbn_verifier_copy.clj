;(ns isbn-verifier)
;;
;; (defn- parse11 [x] (if (= x "X") 10 (Long/parseLong x)))
;
;; (defn isbn? [isbn]
;;   (true? (and
;;     (re-matches #"\d-?\d\d\d-?\d\d\d\d\d-?[\dX]" isbn)
;;     (zero? (mod
;;               (apply + (map #(* %1 (parse11 %2))
;;                             (range 10 0 -1)
;;                             (re-seq #"[\dX]" isbn)))
;;               11)))))
;
;
;
;(defn char->int [char]
;  (if (= char \X)
;    10
;    (Character/digit char 10)))
;
;(defn sum-isbn [isbn]
;  (->> isbn
;       (map char->int)
;       (map * (range 10 0 -1))
;       (apply +)))
;
;(defn match-isbn-pattern? [isbn]
;  (or (re-matches #"\d{9}[\dX]" isbn) "-1"))
;
;(defn find-x-isbn [isbn]
;  (apply str (re-seq #"[\dX]" isbn)))
;
;(defn isbn? [isbn]
;  (->> isbn
;       find-x-isbn
;       match-isbn-pattern?
;       sum-isbn
;       (#(mod % 11))
;       zero?))