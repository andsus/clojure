(ns rna-transcription)

(defn- dna-to-rna [s]  
  (map {
    \C \G
    \G \C
    \T \A   
    \A \U} s))

(defn to-rna [dna] 
  (let [ rna (apply str (dna-to-rna dna )) ]
    (assert (= (count dna) (count rna)) )
    rna  ))

