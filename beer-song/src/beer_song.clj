(ns beer-song)

; (def verse 0
;   (str "No more bottles of beer on the wall, no more bottles of beer.
;     Go to the store and buy some more, 99 bottles of beer on the wall.
;     ")
;   )

; (defn verse 1
;   (str "1 bottle of beer on the wall, 1 bottle of beer.
;     Take it down and pass it around, no more bottles of beer on the wall.
;     ")
;   )

; (defn verse 2
;   (str "2 bottles of beer on the wall, 2 bottles of beer.
;     Take it down and pass it around, 1 bottle of beer on the wall.
;     ")
;    )

(defn verse
  "Returns the nth verse of the song."
  [num]
  ( case num
    0 (str "No more bottles of beer on the wall, no more bottles of beer.
Go to the store and buy some more, 99 bottles of beer on the wall.
")
    1 (str "1 bottle of beer on the wall, 1 bottle of beer.
Take it down and pass it around, no more bottles of beer on the wall.
")
    2 (str "2 bottles of beer on the wall, 2 bottles of beer.
Take one down and pass it around, 1 bottle of beer on the wall.
")
    (str num " bottles of beer on the wall, " num " bottles of beer.
Take one down and pass it around, " (dec num) " bottles of beer on the wall.
")
 
  )
   )

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start] (sing start 0))
  ([start end]
    (->> (range start (dec end) -1)
      (map verse)
      ;; add newline between verses
      (map #(str % "\n"))
      (reduce str)
      ;; remove the final newline
      (#(clojure.string/join "" (drop-last %) ))
    )
    )
  )
