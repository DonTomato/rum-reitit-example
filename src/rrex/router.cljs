(ns rrex.router
  (:require [rum.core :as rum] 
            [reitit.frontend :as rf]
            [reitit.frontend.easy :as rfe]
            [reitit.frontend.controllers :as rfc]
            [rrex.routes :refer [routes]]))

(defonce router-match (atom nil))

(defn init! []
  (rfe/start! (rf/router routes)
              (fn [n-match]
                (swap! router-match (fn [o-match]
                                            (when n-match
                                              (assoc n-match :controllers (rfc/apply-controllers (:controllers o-match) n-match))))))
              {:use-fragment false}))

(rum/defc router-mounting-point < rum/reactive []
  (let [value (rum/react router-match)]
    (when value
      (let [view (:view (:data value))]
        (view (:parameters value))))))