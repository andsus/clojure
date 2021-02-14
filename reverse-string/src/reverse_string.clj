(ns reverse-string)

(defn reverse-string [s]
  (apply str (into () s))
)

(defn reverse-string-tail-rec [s]
   (loop [r (rest s) acc (conj () (first s)) ]
    (if (= (count r) 0 )
      (apply str acc)
      (recur (rest r) (conj acc (first r)))
    )
  ) 
)

(defn reverse-string-reduce [s]
  (reduce #(str %2 %1) "" s)
)

