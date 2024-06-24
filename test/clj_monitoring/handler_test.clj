(ns clj-monitoring.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [clj-monitoring.app :as cma]))

(deftest test-app
  (testing "main route"
    (let [response (cma/app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Hello World"))))

  (testing "not-found route"
    (let [response (cma/app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
