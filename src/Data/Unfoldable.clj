(ns Data.Unfoldable._foreign)

(defn unfoldrArrayImpl [is-nothing]
  (fn [from-just]
    (fn [fst]
      (fn [snd]
        (fn [f]
          (fn [b]
            (loop [result []
                   value b]
              (let [maybe (f value)]
                (if (is-nothing maybe)
                  result
                  (let [tuple (from-just maybe)]
                    (recur (conj result (fst tuple))
                           (snd tuple))))))))))))
