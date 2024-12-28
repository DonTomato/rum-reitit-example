(ns rrex.routes
  (:require [rrex.pages :as pages]
            [reitit.frontend.easy :as rfe]))

(def routes
  [["/"
    {:name :main-page
     :view pages/main-page}]
   
   ["/account"
    {:name :account-page
     :view pages/account-page
     :controllers [{:start (fn []
                             ; There should be some condition here
                             (when true
                               (rfe/navigate :non-authorized-page {:replace true})))}]}]

   ["/non-authorized"
    {:name :non-authorized-page
     :view pages/not-authorized-page}]])

