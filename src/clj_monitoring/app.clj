(ns clj-monitoring.app
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clj-monitoring.init :as cmi]
            [clj-statsd :as statsd]
            [ring.util.response :refer [response]]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
            [clj-monitoring.handler :as cmh]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults api-defaults]]))

;; (defroutes app-routes
;;   (GET "/" [] "Hello World")
;;   (route/not-found "Not Found"))

;; (def app
;;   (wrap-defaults app-routes site-defaults))


;; Initialize resources
(cmi/initialize)

(defn wrap-with-statsd [handler]
  (fn [request]
    (statsd/increment cmi/statsd-client "requests.count")
    (handler request)))

(defroutes app-routes
  (GET "/ping" [] (response {:message "pong"}))
  (GET "/user" [] (response cmh/user) )
  (route/not-found "Not Found"))

(def app
  (-> (wrap-defaults app-routes api-defaults)
      wrap-json-response
      wrap-json-body
      ;; wrap-with-statsd
      wrap-reload
      ))