(defproject clj-monitoring "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [compojure "1.6.2"]
                 [clj-statsd "0.4.0"]
                 [ring/ring-defaults "1.9.5"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler clj-monitoring.handler/app
         :port 4550}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
