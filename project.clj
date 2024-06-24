(defproject clj-monitoring "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [compojure "1.6.2"]
                 [org.clojure/data.json "1.0.0"]
                 [clj-statsd "0.4.0"]
                 [ring/ring-core "1.11.0"]
                 [puppetlabs/ring-middleware "1.1.0"]
                 [ring/ring-json "0.4.0"]
                 [ring/ring-jetty-adapter "1.9.5"]
                 [nrepl/nrepl "0.9.0"]
                 [ring/ring-defaults "0.3.2"]]
  :plugins [[lein-ring "0.12.5"]
            [cider/cider-nrepl "0.26.0"]]
  :main ^:skip-aot clj-monitoring.core
;;   :ring {:handler clj-monitoring.handler/app
;;          :port 4550}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]
         :repl-options {:init-ns clj-monitoring.core}}})
