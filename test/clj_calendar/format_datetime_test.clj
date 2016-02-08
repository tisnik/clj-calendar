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
    "Check the function clj-calandar.format-datetime/format-time-."
    (testing "the function clj-calandar.format-datetime/format-time-."
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


