(ns Data.Unfoldable1._foreign)

(defn unfoldr1ArrayImpl [is-nothing]
  (fn [from-just]
    (fn [fst]
      (fn [snd]
        (fn [f]
          (fn [b]
            (loop [result []
                   value b]
              (let [tuple (f value)
                    res (conj result (fst tuple))
                    maybe (snd tuple)]
                (if (is-nothing maybe)
                  res
                  (recur res (from-just maybe)))))))))))
