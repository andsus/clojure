(ns run-length-encoding)

(defn encode [[fst & rst :as run]]
  (cond->> fst
    rst (str (count run))))


(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (->> plain-text
    (partition-by identity)
    (map encode)
    (apply str)))
  
(defn decode [[_ cnt chr]]
  (cond->> chr 
    (seq cnt) (repeat (Integer/parseInt cnt)) ))


(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (->> cipher-text
    (re-seq #"(\d*)(\D)" )
    (mapcat decode)
    (apply str)))
    
