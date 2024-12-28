(ns rrex.pages
  (:require [rum.core :as rum]
            [reitit.frontend.easy :as rfe]))

(rum/defc main-page [_]
  [:div
   [:h1 "Main Page"]
   [:ul
    [:li [:a {:href (rfe/href :account-page)} "Go to About"]]]])

(rum/defc account-page [_]
  [:div
   [:h1 "Account Page"]
   [:ul
    [:li [:a {:href (rfe/href :main-page)} "Go to Main page"]]]])

(rum/defc not-authorized-page [_]
  [:div
   [:h1 "Not Authorized"]
   [:ul
    [:li [:a {:href (rfe/href :main-page)} "Go to Main page"]]]])
