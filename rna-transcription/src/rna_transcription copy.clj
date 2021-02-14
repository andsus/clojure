(ns rna-transcription)

(defn- dna-to-rna [s]
  (case s 
    \C \G
    \G \C
    \T \A   
    \A \U 
    (throw (AssertionError. "Wrong DNA input."))))

(defn to-rna [dna] 
  ; (apply str 
  ;   (map (fn   
  ;     [letter]
  ;     (if (contains? dna-map letter)
  ;       (get dna-map letter)
  ;       (throw (AssertionError. "Wrong DNA input."))))
  ;     (char-array dna) )))
  (apply str (map dna-to-rna dna)))
