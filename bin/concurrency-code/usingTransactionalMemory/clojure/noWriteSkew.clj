(def checking-balance (ref 500))
(def savings-balance (ref 600))

#_ START:WITHDRAW
(defn withdraw-account [from-balance constraining-balance amount]
  (dosync
    (let [total-balance (+ @from-balance (ensure constraining-balance))] ;<label id="noWriteSkew.ensure"/>
      (. Thread sleep 1000)
      (if (>= (- total-balance amount) 1000)
        (alter from-balance - amount)
        (println "Sorry, can't withdraw due to constraint violation")))))
#_ END:WITHDRAW

(println "checking-balance is" @checking-balance)
(println "savings-balance is" @savings-balance)
(println "Total balance is" (+ @checking-balance @savings-balance))

(future (withdraw-account checking-balance savings-balance 100))
(future (withdraw-account savings-balance checking-balance 100))

(. Thread sleep 2000)

(println "checking-balance is" @checking-balance)
(println "savings-balance is" @savings-balance)
(println "Total balance is" (+ @checking-balance @savings-balance))
