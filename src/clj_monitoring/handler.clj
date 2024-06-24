
(ns clj-monitoring.handler
  (:require [compojure.core :refer :all]
            [clj-statsd :as statsd]))



(defn user-by-id
  [body]
  "This fn does some complex business logic. 
   For example :
   - Fetch someting from DB , or
   - Call 3rd API 
   - Massage the data in some required format"
  (statsd/timing "clj_server.create-user" (:timer body))
  {:id (:id body)
   :name (str "test-user-" (:id body))})


(defn create-user
  [body]
  (if (even? (:id body))
    (statsd/increment "clj_server.even_userid" 1)
    (statsd/increment "clj_server.odd_userid" 1))
  (user-by-id body))
