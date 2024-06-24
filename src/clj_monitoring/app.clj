(ns clj-monitoring.app
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clj-monitoring.init :as cmi]
            [ring.util.response :refer [response]]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
            [clj-monitoring.handler :as cmh]
            [ring.adapter.jetty :as jetty]))


;; Initialize resources
(cmi/initialize)


(defroutes app-routes
  (GET "/ping" [] (response {:message "pong"}))
  (POST "/user" {body :body} (response (cmh/create-user body)))
  (route/not-found (response {:message "invalid route"})))


(def app
  (-> app-routes
      (wrap-json-body {:keywords? true :bigdecimals? true})
      (wrap-json-response)))


(defn -main [& args]
  (jetty/run-jetty app {:port 3043})
  (println "Server started on port 3043"))
