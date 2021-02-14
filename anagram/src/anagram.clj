(ns anagram
  (:require [clojure.string :as string]))

(defn anagrams? [alpha beta]
  (let [ a (string/lower-case alpha) 
         b (string/lower-case beta)] 
         (and
          (not (= a b))
          (= (sort a) (sort b)))))

(defn anagrams-for [word prospects]  
  (filter #(anagrams? word %) prospects))
