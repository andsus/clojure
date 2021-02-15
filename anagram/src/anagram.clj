(ns anagram
  (:require [clojure.string :as string]))

(defn- anagrams-of? [word]
  (let [word (string/lower-case word)
        sorted-word (sort word)]
      #(let [s (string/lower-case %)]  
        (and
          (not= s word)
          (= (sort s) sorted-word)))))

(defn anagrams-for [word prospects]  
  (filter (anagrams-of? word) prospects))
