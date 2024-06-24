
(ns clj-monitoring.init
  (:require [clj-statsd :as statsd]))

;; Define a StatsD client. Adjust host and port as needed.
;; (def statsd-client (statsd/init {:host "localhost" :port 8125}))

(def statsd-client (statsd/setup "localhost" 8125))



;; Function to initialize other resources if needed
(defn initialize []
  (println "Initialization complete"))
