;
;  (C) Copyright 2015, 2016  Pavel Tisnovsky
;
;  All rights reserved. This program and the accompanying materials
;  are made available under the terms of the Eclipse Public License v1.0
;  which accompanies this distribution, and is available at
;  http://www.eclipse.org/legal/epl-v10.html
;
;  Contributors:
;      Pavel Tisnovsky
;

(ns clj-calendar.format-datetime-test
    (:require [clojure.test :refer :all]
              [clj-calendar.format-datetime :refer :all]))


;
; Common functions used by tests.
;

(defn callable?
    "Test if given function-name is bound to the real function."
    [function-name]
    (clojure.test/function? function-name))

;
; Tests for various defs and functions existence
;

(deftest test-format-time-existence
    "Check that the clj-calendar.format-datetime/format-time function definition exists."
    (testing "if the clj-calendar.format-datetime/format-time function definition exists."
        (is (callable? 'clj-calendar.format-datetime/format-time))))

(deftest test-format-time--existence
    "Check that the clj-calendar.format-datetime/format-time- function definition exists."
    (testing "if the clj-calendar.format-datetime/format-time- function definition exists."
        (is (callable? 'clj-calendar.format-datetime/format-time-))))

(deftest test-format-month-existence
    "Check that the clj-calendar.format-datetime/format-month function definition exists."
    (testing "if the clj-calendar.format-datetime/format-month function definition exists."
        (is (callable? 'clj-calendar.format-datetime/format-month))))

(deftest test-format-day-existence
    "Check that the clj-calendar.format-datetime/format-day function definition exists."
    (testing "if the clj-calendar.format-datetime/format-day function definition exists."
        (is (callable? 'clj-calendar.format-datetime/format-day))))

(deftest test-format-hours-existence
    "Check that the clj-calendar.format-datetime/format-hours function definition exists."
    (testing "if the clj-calendar.format-datetime/format-hours function definition exists."
        (is (callable? 'clj-calendar.format-datetime/format-hours))))

(deftest test-format-minutes-existence
    "Check that the clj-calendar.format-datetime/format-minutes function definition exists."
    (testing "if the clj-calendar.format-datetime/format-minutes function definition exists."
        (is (callable? 'clj-calendar.format-datetime/format-minutes))))

(deftest test-format-seconds-existence
    "Check that the clj-calendar.format-datetime/format-seconds function definition exists."
    (testing "if the clj-calendar.format-datetime/format-seconds function definition exists."
        (is (callable? 'clj-calendar.format-datetime/format-seconds))))

;
; Actual tests.
;

(deftest test-format-time-1
    "Check the function clj-calendar.format-datetime/format-time-."
    (testing "the function clj-calendar.format-datetime/format-time-."
        (are [x y] (= x y)  
              "one minute ago"                (format-time- 1 0 "minute" "second")
              "one minute and one second ago" (format-time- 1 1 "minute" "second")
              "one minute and 2 seconds ago"  (format-time- 1 2 "minute" "second")
              "one day ago"                   (format-time- 1 0 "day" "hour")
              "one day and one hour ago"      (format-time- 1 1 "day" "hour")
              "one day and 2 hours ago"       (format-time- 1 2 "day" "hour")
              "one month ago"                 (format-time- 1 0 "month" "year")
              "one month and one year ago"    (format-time- 1 1 "month" "year")
              "one month and 2 years ago"     (format-time- 1 2 "month" "year"))))

(deftest test-format-time-2
    "Check the function clj-calendar.format-datetime/format-time-."
    (testing "the function clj-calendar.format-datetime/format-time-."
        (are [x y] (= x y)  
              "2 minutes ago"                (format-time- 2 0 "minute" "second")
              "2 minutes and one second ago" (format-time- 2 1 "minute" "second")
              "2 minutes and 2 seconds ago"  (format-time- 2 2 "minute" "second")
              "2 days ago"                   (format-time- 2 0 "day" "hour")
              "2 days and one hour ago"      (format-time- 2 1 "day" "hour")
              "2 days and 2 hours ago"       (format-time- 2 2 "day" "hour")
              "2 months ago"                 (format-time- 2 0 "month" "year")
              "2 months and one year ago"    (format-time- 2 1 "month" "year")
              "2 months and 2 years ago"     (format-time- 2 2 "month" "year"))))

(deftest test-format-time
    "Check the function clj-calendar.format-datetime/format-time."
    (testing "the function clj-calendar.format-datetime/format-time."
        (are [x y] (= x y)  
              "1 month ago"  (format-time 1 "month")
              "2 months ago" (format-time 2 "months")
              "1 year ago"   (format-time 1 "year")
              "2 years ago"  (format-time 2 "years"))))

(deftest test-format-month-1
    "Check the function clj-calendar.format-datetime/format-month."
    (testing "the function clj-calendar.format-datetime/format-month."
        (are [x y] (= x y)  
              "one month ago"              (format-month 1 0))))

(deftest test-format-month-2
    "Check the function clj-calendar.format-datetime/format-month."
    (testing "the function clj-calendar.format-datetime/format-month."
        (are [x y] (= x y)  
              "one month and one day ago"  (format-month 1 1)
              "one month and 2 days ago"   (format-month 1 2)
              "one month and 100 days ago" (format-month 1 100))))

(deftest test-format-month-3
    "Check the function clj-calendar.format-datetime/format-month."
    (testing "the function clj-calendar.format-datetime/format-month."
        (are [x y] (= x y)  
              "2 months ago" (format-month 2 1)
              "2 months ago" (format-month 2 2)
              "2 months ago" (format-month 2 100))))

(deftest test-format-day-1
    "Check the function clj-calendar.format-datetime/format-day."
    (testing "the function clj-calendar.format-datetime/format-day."
        (are [x y] (= x y)  
              "one day ago"              (format-day 1 0))))

(deftest test-format-day-2
    "Check the function clj-calendar.format-datetime/format-day."
    (testing "the function clj-calendar.format-datetime/format-day."
        (are [x y] (= x y)  
              "one day and one hour ago"  (format-day 1 1)
              "one day and 2 hours ago"   (format-day 1 2)
              "one day and 100 hours ago" (format-day 1 100))))

(deftest test-format-day-3
    "Check the function clj-calendar.format-datetime/format-day."
    (testing "the function clj-calendar.format-datetime/format-day."
        (are [x y] (= x y)  
              "2 days and one hour ago"  (format-day 2 1)
              "2 days and 2 hours ago"   (format-day 2 2)
              "2 days and 100 hours ago" (format-day 2 100))))

(deftest test-format-hours-1
    "Check the function clj-calendar.format-datetime/format-hours."
    (testing "the function clj-calendar.format-datetime/format-hours."
        (are [x y] (= x y)  
              "one hour ago"              (format-hours 1 0))))

(deftest test-format-hours-2
    "Check the function clj-calendar.format-datetime/format-hours."
    (testing "the function clj-calendar.format-datetime/format-hours."
        (are [x y] (= x y)  
              "one hour and one minute ago"  (format-hours 1 1)
              "one hour and 2 minutes ago"   (format-hours 1 2)
              "one hour and 100 minutes ago" (format-hours 1 100))))

(deftest test-format-hours-3
    "Check the function clj-calendar.format-datetime/format-hours."
    (testing "the function clj-calendar.format-datetime/format-hours."
        (are [x y] (= x y)  
              "2 hours and one minute ago"   (format-hours 2 1)
              "2 hours and 2 minutes ago"    (format-hours 2 2)
              "2 hours and 100 minutes ago"  (format-hours 2 100))))

(deftest test-format-minutes-1
    "Check the function clj-calendar.format-datetime/format-minutes."
    (testing "the function clj-calendar.format-datetime/format-minutes."
        (are [x y] (= x y)  
              "one minute ago"              (format-minutes 1 0))))

(deftest test-format-minutes-2
    "Check the function clj-calendar.format-datetime/format-minutes."
    (testing "the function clj-calendar.format-datetime/format-minutes."
        (are [x y] (= x y)  
              "one minute and one second ago"  (format-minutes 1 1)
              "one minute and 2 seconds ago"   (format-minutes 1 2)
              "one minute and 100 seconds ago" (format-minutes 1 100))))

(deftest test-format-minutes-3
    "Check the function clj-calendar.format-datetime/format-minutes."
    (testing "the function clj-calendar.format-datetime/format-minutes."
        (are [x y] (= x y)  
              "2 minutes and one second ago"   (format-minutes 2 1)
              "2 minutes and 2 seconds ago"    (format-minutes 2 2)
              "2 minutes and 100 seconds ago"  (format-minutes 2 100))))

(deftest test-format-seconds-1
    "Check the function clj-calendar.format-datetime/format-seconds."
    (testing "the function clj-calendar.format-datetime/format-seconds."
        (are [x y] (= x y)  
              "one second ago"                 (format-seconds 1)
              "2 seconds ago"                  (format-seconds 2))))

