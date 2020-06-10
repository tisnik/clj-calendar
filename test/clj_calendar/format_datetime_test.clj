;
;  (C) Copyright 2015, 2016, 2020  Pavel Tisnovsky
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
  (testing
    "if the clj-calendar.format-datetime/format-time function definition exists."
    (is (callable? 'clj-calendar.format-datetime/format-time))))

(deftest test-format-time--existence
  "Check that the clj-calendar.format-datetime/format-time- function definition exists."
  (testing
    "if the clj-calendar.format-datetime/format-time- function definition exists."
    (is (callable? 'clj-calendar.format-datetime/format-time-))))

(deftest test-format-month-existence
  "Check that the clj-calendar.format-datetime/format-month function definition exists."
  (testing
    "if the clj-calendar.format-datetime/format-month function definition exists."
    (is (callable? 'clj-calendar.format-datetime/format-month))))

(deftest test-format-day-existence
  "Check that the clj-calendar.format-datetime/format-day function definition exists."
  (testing
    "if the clj-calendar.format-datetime/format-day function definition exists."
    (is (callable? 'clj-calendar.format-datetime/format-day))))

(deftest test-format-hours-existence
  "Check that the clj-calendar.format-datetime/format-hours function definition exists."
  (testing
    "if the clj-calendar.format-datetime/format-hours function definition exists."
    (is (callable? 'clj-calendar.format-datetime/format-hours))))

(deftest test-format-minutes-existence
  "Check that the clj-calendar.format-datetime/format-minutes function definition exists."
  (testing
    "if the clj-calendar.format-datetime/format-minutes function definition exists."
    (is (callable? 'clj-calendar.format-datetime/format-minutes))))

(deftest test-format-seconds-existence
  "Check that the clj-calendar.format-datetime/format-seconds function definition exists."
  (testing
    "if the clj-calendar.format-datetime/format-seconds function definition exists."
    (is (callable? 'clj-calendar.format-datetime/format-seconds))))

;
; Actual tests.
;

(deftest test-format-time-1
  "Check the function clj-calendar.format-datetime/format-time-."
  (testing
    "the function clj-calendar.format-datetime/format-time-."
    (are [x y] (= x y)
         "one minute ago"                 (format-time- 1 0  "minute" "second")
         "one minute and one second ago"  (format-time- 1 1  "minute" "second")
         "one minute and 2 seconds ago"   (format-time- 1 2  "minute" "second")
         "one minute and 3 seconds ago"   (format-time- 1 3  "minute" "second")
         "one minute and 4 seconds ago"   (format-time- 1 4  "minute" "second")
         "one minute and 59 seconds ago"  (format-time- 1 59 "minute" "second")
         "one minute and 60 seconds ago"  (format-time- 1 60 "minute" "second")
         "one minute and 61 seconds ago"  (format-time- 1 61 "minute" "second")
         "one minute and 99 seconds ago"  (format-time- 1 99 "minute" "second")
         "one day ago"                    (format-time- 1 0  "day" "hour")
         "one day and one hour ago"       (format-time- 1 1  "day" "hour")
         "one day and 2 hours ago"        (format-time- 1 2  "day" "hour")
         "one day and 3 hours ago"        (format-time- 1 3  "day" "hour")
         "one day and 4 hours ago"        (format-time- 1 4  "day" "hour")
         "one day and 59 hours ago"       (format-time- 1 59 "day" "hour")
         "one day and 60 hours ago"       (format-time- 1 60 "day" "hour")
         "one day and 61 hours ago"       (format-time- 1 61 "day" "hour")
         "one day and 99 hours ago"       (format-time- 1 99 "day" "hour")
         "one month ago"                  (format-time- 1 0  "month" "year")
         "one month and one year ago"     (format-time- 1 1  "month" "year")
         "one month and 2 years ago"      (format-time- 1 2  "month" "year")
         "one month and 3 years ago"      (format-time- 1 3  "month" "year")
         "one month and 4 years ago"      (format-time- 1 4  "month" "year")
         "one month and 59 years ago"     (format-time- 1 59 "month" "year")
         "one month and 60 years ago"     (format-time- 1 60 "month" "year")
         "one month and 61 years ago"     (format-time- 1 61 "month" "year")
         "one month and 99 years ago"     (format-time- 1 99 "month" "year"))))

(deftest test-format-time-2
  "Check the function clj-calendar.format-datetime/format-time-."
  (testing
    "the function clj-calendar.format-datetime/format-time-."
    (are [x y] (= x y)
         "2 minutes ago"                 (format-time- 2 0 "minute" "second")
         "2 minutes and one second ago"  (format-time- 2 1 "minute" "second")
         "2 minutes and 2 seconds ago"   (format-time- 2 2 "minute" "second")
         "2 minutes and 3 seconds ago"   (format-time- 2 3 "minute" "second")
         "2 minutes and 4 seconds ago"   (format-time- 2 4 "minute" "second")
         "2 minutes and 59 seconds ago"  (format-time- 2 59 "minute" "second")
         "2 minutes and 60 seconds ago"  (format-time- 2 60 "minute" "second")
         "2 minutes and 61 seconds ago"  (format-time- 2 61 "minute" "second")
         "2 minutes and 99 seconds ago"  (format-time- 2 99 "minute" "second")
         "2 days ago"                    (format-time- 2 0 "day" "hour")
         "2 days and one hour ago"       (format-time- 2 1 "day" "hour")
         "2 days and 2 hours ago"        (format-time- 2 2 "day" "hour")
         "2 days and 3 hours ago"        (format-time- 2 3 "day" "hour")
         "2 days and 4 hours ago"        (format-time- 2 4 "day" "hour")
         "2 days and 59 hours ago"       (format-time- 2 59 "day" "hour")
         "2 days and 60 hours ago"       (format-time- 2 60 "day" "hour")
         "2 days and 61 hours ago"       (format-time- 2 61 "day" "hour")
         "2 days and 99 hours ago"       (format-time- 2 99 "day" "hour")
         "2 months ago"                  (format-time- 2 0 "month" "year")
         "2 months and one year ago"     (format-time- 2 1 "month" "year")
         "2 months and 2 years ago"      (format-time- 2 2 "month" "year"))))

(deftest test-format-time-3
  "Check the function clj-calendar.format-datetime/format-time-."
  (testing
    "the function clj-calendar.format-datetime/format-time-."
    (are [x y] (= x y)
         "99 minutes ago"                 (format-time- 99 0 "minute" "second")
         "99 minutes and one second ago"  (format-time- 99 1 "minute" "second")
         "99 minutes and 2 seconds ago"   (format-time- 99 2 "minute" "second")
         "99 minutes and 3 seconds ago"   (format-time- 99 3 "minute" "second")
         "99 minutes and 4 seconds ago"   (format-time- 99 4 "minute" "second")
         "99 minutes and 59 seconds ago"  (format-time- 99 59 "minute" "second")
         "99 minutes and 60 seconds ago"  (format-time- 99 60 "minute" "second")
         "99 minutes and 61 seconds ago"  (format-time- 99 61 "minute" "second")
         "99 minutes and 99 seconds ago"  (format-time- 99 99 "minute" "second")
         "99 days ago"                    (format-time- 99 0 "day" "hour")
         "99 days and one hour ago"       (format-time- 99 1 "day" "hour")
         "99 days and 2 hours ago"        (format-time- 99 2 "day" "hour")
         "99 days and 3 hours ago"        (format-time- 99 3 "day" "hour")
         "99 days and 4 hours ago"        (format-time- 99 4 "day" "hour")
         "99 days and 59 hours ago"       (format-time- 99 59 "day" "hour")
         "99 days and 60 hours ago"       (format-time- 99 60 "day" "hour")
         "99 days and 61 hours ago"       (format-time- 99 61 "day" "hour")
         "99 days and 99 hours ago"       (format-time- 99 99 "day" "hour")
         "99 months ago"                  (format-time- 99 0 "month" "year")
         "99 months and one year ago"     (format-time- 99 1 "month" "year")
         "99 months and 2 years ago"      (format-time- 99 2 "month" "year"))))

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
                "one month ago"  (format-month 1 0))))

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
                "2 months ago"   (format-month 2 1)
                "2 months ago"   (format-month 2 2)
                "2 months ago"   (format-month 2 100)
                "4 months ago"   (format-month 4 1)
                "4 months ago"   (format-month 4 2)
                "4 months ago"   (format-month 4 100)
                "100 months ago" (format-month 100 1)
                "100 months ago" (format-month 100 2)
                "100 months ago" (format-month 100 100))))

(deftest test-format-month-special-cases
  "Check the function clj-calendar.format-datetime/format-month."
  (testing "the function clj-calendar.format-datetime/format-month."
           (are [x y] (= x y)
                "one day ago"    (format-month 0 1)
                "2 days ago"     (format-month 0 2)
                "100 days ago"   (format-month 0 100))))

(deftest test-format-day-1
  "Check the function clj-calendar.format-datetime/format-day."
  (testing "the function clj-calendar.format-datetime/format-day."
           (are [x y] (= x y)
                "one day ago"    (format-day 1 0))))

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
                "2 days and one hour ago"    (format-day 2 1)
                "2 days and 2 hours ago"     (format-day 2 2)
                "2 days and 100 hours ago"   (format-day 2 100)
                "4 days and one hour ago"    (format-day 4 1)
                "4 days and 2 hours ago"     (format-day 4 2)
                "4 days and 100 hours ago"   (format-day 4 100)
                "100 days and one hour ago"  (format-day 100 1)
                "100 days and 2 hours ago"   (format-day 100 2)
                "100 days and 100 hours ago" (format-day 100 100))))

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
                "2 hours and one minute ago"     (format-hours 2 1)
                "2 hours and 2 minutes ago"      (format-hours 2 2)
                "2 hours and 100 minutes ago"    (format-hours 2 100)
                "4 hours and one minute ago"     (format-hours 4 1)
                "4 hours and 2 minutes ago"      (format-hours 4 2)
                "4 hours and 100 minutes ago"    (format-hours 4 100)
                "100 hours and one minute ago"   (format-hours 100 1)
                "100 hours and 2 minutes ago"    (format-hours 100 2)
                "100 hours and 100 minutes ago"  (format-hours 100 100))))

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
                "2 minutes and one second ago"     (format-minutes 2 1)
                "2 minutes and 2 seconds ago"      (format-minutes 2 2)
                "2 minutes and 100 seconds ago"    (format-minutes 2 100)
                "4 minutes and one second ago"     (format-minutes 4 1)
                "4 minutes and 2 seconds ago"      (format-minutes 4 2)
                "4 minutes and 100 seconds ago"    (format-minutes 4 100)
                "100 minutes and one second ago"   (format-minutes 100 1)
                "100 minutes and 2 seconds ago"    (format-minutes 100 2)
                "100 minutes and 100 seconds ago"  (format-minutes 100 100))))

(deftest test-format-seconds-1
  "Check the function clj-calendar.format-datetime/format-seconds."
  (testing "the function clj-calendar.format-datetime/format-seconds."
      (are [x y] (= x y)
           "one second ago"                 (format-seconds 1)
           "2 seconds ago"                  (format-seconds 2)
           "4 seconds ago"                  (format-seconds 4)
           "100 seconds ago"                (format-seconds 100))))

