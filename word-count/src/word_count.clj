(ns word-count
  (:require [clojure.string :as clj-string]))

(defn word-count [s] 
  (->> 
    (clj-string/lower-case s)  
    (re-seq #"\w+" )
    frequencies))
