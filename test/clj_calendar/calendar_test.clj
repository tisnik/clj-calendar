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

