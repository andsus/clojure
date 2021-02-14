(ns bob (:require [clojure.string :as str]) )

(defn- yell? [s]
  (and 
    (re-find #"[a-zA-Z]" s) 
    (= s (str/upper-case s)) ))

(defn- question? [s]
  (str/ends-with? (str/trim s) "?")) 

(defn response-for [s] 
  (cond 
    (and (question? s) (yell? s)) "Calm down, I know what I'm doing!"
    (str/blank? s) "Fine. Be that way!"
    (yell? s) "Whoa, chill out!"
    (question? s) "Sure."
    :else "Whatever."  ))
