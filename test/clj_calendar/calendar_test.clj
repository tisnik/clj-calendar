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

(ns clj-calendar.calendar-test
    (:require [clojure.test :refer :all]
              [clj-calendar.calendar :refer :all]))


;
; Common functions used by tests.
;

(defn callable?
    "Test if given function-name is bound to the real function."
    [function-name]
    (clojure.test/function? function-name))



;
; Actual tests.
;

(deftest test-get-calendar-existence
    "Check that the clj-calendar.calendar/get-calendar function definition exists."
    (testing "if the clj-calendar.calendar/get-calendar function definition exists."
        (is (callable? 'clj-calendar.calendar/get-calendar))))

(deftest test-get-calendar-for-week-existence
    "Check that the clj-calendar.calendar/get-calendar-for-week function definition exists."
    (testing "if the clj-calendar.calendar/get-calendar-for-week function definition exists."
        (is (callable? 'clj-calendar.calendar/get-calendar-for-week))))

(deftest test-get-year-existence
    "Check that the clj-calendar.calendar/get-year function definition exists."
    (testing "if the clj-calendar.calendar/get-year function definition exists."
        (is (callable? 'clj-calendar.calendar/get-year))))

(deftest test-get-week-existence
    "Check that the clj-calendar.calendar/get-week function definition exists."
    (testing "if the clj-calendar.calendar/get-week function definition exists."
        (is (callable? 'clj-calendar.calendar/get-week))))

(deftest test-get-day-of-week-existence
    "Check that the clj-calendar.calendar/get-day-of-week function definition exists."
    (testing "if the clj-calendar.calendar/get-day-of-week function definition exists."
        (is (callable? 'clj-calendar.calendar/get-day-of-week))))

(deftest test-format-date-existence
    "Check that the clj-calendar.calendar/format-date function definition exists."
    (testing "if the clj-calendar.calendar/format-date function definition exists."
        (is (callable? 'clj-calendar.calendar/format-date))))

(deftest test-format-date-time-existence
    "Check that the clj-calendar.calendar/format-date-time function definition exists."
    (testing "if the clj-calendar.calendar/format-date-time function definition exists."
        (is (callable? 'clj-calendar.calendar/format-date-time))))

(deftest test-format-date-using-desired-format-existence
    "Check that the clj-calendar.calendar/format-date-using-desired-format function definition exists."
    (testing "if the clj-calendar.calendar/format-date-using-desired-format function definition exists."
        (is (callable? 'clj-calendar.calendar/format-date-using-desired-format))))

