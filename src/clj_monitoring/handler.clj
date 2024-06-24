
(ns clj-monitoring.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clj-monitoring.init :as cmi]
            [ring.util.response :refer [response]]
            [clj-statsd :as statsd]))



(defn user []
  (statsd/increment cmi/statsd-client "business-logic-1.calls")
  ;; Your business logic here
  {:status "success", :message "Business logic executed"})

