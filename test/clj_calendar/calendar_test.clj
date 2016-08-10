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
; Actual tests that checks if all functions exists.
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

(deftest test-format-from-to-date-for-week-existence
    "Check that the clj-calendar.calendar/format-from-to-date-for-week function definition exists."
    (testing "if the clj-calendar.calendar/format-from-to-date-for-week function definition exists."
        (is (callable? 'clj-calendar.calendar/format-from-to-date-for-week))))

(deftest test-calculate-first-day-of-week-existence
    "Check that the clj-calendar.calendar/calculate-first-day-of-week function definition exists."
    (testing "if the clj-calendar.calendar/calculate-first-day-of-week function definition exists."
        (is (callable? 'clj-calendar.calendar/calculate-first-day-of-week))))

(deftest test-get-first-day-of-week-existence
    "Check that the clj-calendar.calendar/get-first-day-of-week function definition exists."
    (testing "if the clj-calendar.calendar/get-first-day-of-week function definition exists."
        (is (callable? 'clj-calendar.calendar/get-first-day-of-week))))

(deftest test-get-last-day-of-week-existence
    "Check that the clj-calendar.calendar/get-last-day-of-week function definition exists."
    (testing "if the clj-calendar.calendar/get-last-day-of-week function definition exists."
        (is (callable? 'clj-calendar.calendar/get-last-day-of-week))))

(deftest test-get-first-day-of-week-formatted-existence
    "Check that the clj-calendar.calendar/get-first-day-of-week-formatted function definition exists."
    (testing "if the clj-calendar.calendar/get-first-day-of-week-formatted function definition exists."
        (is (callable? 'clj-calendar.calendar/get-first-day-of-week-formatted))))

(deftest test-get-last-day-of-week-formatted-existence
    "Check that the clj-calendar.calendar/get-last-day-of-week-formatted function definition exists."
    (testing "if the clj-calendar.calendar/get-last-day-of-week-formatted function definition exists."
        (is (callable? 'clj-calendar.calendar/get-last-day-of-week-formatted))))

;
; Tests for function behaviours
;

(deftest test-get-calendar
    "Check the function clj-calendar.calendar/get-calendar."
    (testing "the function clj-calendar.calendar/get-calendar."
        (is (not (nil? (get-calendar))))
        (is (or
            (=  (class (get-calendar)) java.util.Calendar)
            (=  (class (get-calendar)) java.util.GregorianCalendar)))
        (is (or
            (=  (type  (get-calendar)) java.util.Calendar)
            (=  (type  (get-calendar)) java.util.GregorianCalendar)))
        (is (>  (.get (get-calendar) (java.util.Calendar/YEAR)) 2000))
        (is (>= (.get (get-calendar) (java.util.Calendar/MONTH)) 0))
        (is (<  (.get (get-calendar) (java.util.Calendar/MONTH)) 12))
        (is (>= (.get (get-calendar) (java.util.Calendar/DAY_OF_MONTH)) 0))
        (is (<= (.get (get-calendar) (java.util.Calendar/DAY_OF_MONTH)) 31)) ; let's be on the safe side
        (is (>= (.get (get-calendar) (java.util.Calendar/DAY_OF_YEAR)) 0))
        (is (<= (.get (get-calendar) (java.util.Calendar/DAY_OF_YEAR)) 366)) ; let's be on the safe side
        (is (>= (.get (get-calendar) (java.util.Calendar/WEEK_OF_YEAR)) 0))
        (is (<= (.get (get-calendar) (java.util.Calendar/WEEK_OF_YEAR)) 54)) ; let's be on the safe side
))

(deftest test-get-calendar-2
    "Check the function clj-calendar.calendar/get-calendar."
    (testing "the function clj-calendar.calendar/get-calendar."
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 01 10 20 30)
            (is (not (nil? calendar)))
            (is (or
                (=  (class calendar) java.util.Calendar)
                (=  (class calendar) java.util.GregorianCalendar)))
            (is (or
                (=  (type  calendar) java.util.Calendar)
                (=  (type  calendar) java.util.GregorianCalendar)))
            (is (=  (.get calendar (java.util.Calendar/YEAR)) 2000))
            (is (=  (.get calendar (java.util.Calendar/MONTH)) 1))
            (is (=  (.get calendar (java.util.Calendar/DAY_OF_MONTH)) 1)))
))

(deftest test-get-calendar-3
    "Check the function clj-calendar.calendar/get-calendar."
    (testing "the function clj-calendar.calendar/get-calendar."
        (is (not (nil? (get-calendar))))
        (is (>= (.get (get-calendar) (java.util.Calendar/HOUR)) 0))
        (is (<= (.get (get-calendar) (java.util.Calendar/HOUR)) 11))
        (is (>= (.get (get-calendar) (java.util.Calendar/HOUR_OF_DAY)) 0))
        (is (<= (.get (get-calendar) (java.util.Calendar/HOUR_OF_DAY)) 23))
        (is (>= (.get (get-calendar) (java.util.Calendar/MINUTE)) 0))
        (is (<= (.get (get-calendar) (java.util.Calendar/MINUTE)) 59))
        (is (>= (.get (get-calendar) (java.util.Calendar/SECOND)) 0))
        (is (<= (.get (get-calendar) (java.util.Calendar/SECOND)) 59))
        (is (>= (.get (get-calendar) (java.util.Calendar/MILLISECOND)) 0))
        (is (<= (.get (get-calendar) (java.util.Calendar/MILLISECOND)) 999))
))

(deftest test-format-date-using-desired-format
    "Check the function clj-calendar.calendar/format-date-using-desired-format"
    (testing "the function clj-calendar.calendar/format-date-using-desired-format."
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 01 10 20 30)
            (is (= "2000" (format-date-using-desired-format calendar "yyyy")))
            (is (= "02"   (format-date-using-desired-format calendar "MM")))
            (is (= "01"   (format-date-using-desired-format calendar "dd")))
            (is (= "10"   (format-date-using-desired-format calendar "hh")))
            (is (= "20"   (format-date-using-desired-format calendar "mm")))
            (is (= "30"   (format-date-using-desired-format calendar "ss"))))))

(deftest test-format-date-using-desired-format-2
    "Check the function clj-calendar.calendar/format-date-using-desired-format"
    (testing "the function clj-calendar.calendar/format-date-using-desired-format."
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 01 10 20 30)
            (is (= "2000-02"    (format-date-using-desired-format calendar "yyyy-MM")))
            (is (= "2000-02-01" (format-date-using-desired-format calendar "yyyy-MM-dd")))
            (is (= "02-01"      (format-date-using-desired-format calendar "MM-dd")))
            (is (= "2000-01"    (format-date-using-desired-format calendar "yyyy-dd"))))))

(deftest test-format-date-using-desired-format-3
    "Check the function clj-calendar.calendar/format-date-using-desired-format"
    (testing "the function clj-calendar.calendar/format-date-using-desired-format."
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 01 10 20 30)
            (is (= "10:20"      (format-date-using-desired-format calendar "hh:mm")))
            (is (= "10:20:30"   (format-date-using-desired-format calendar "hh:mm:ss")))
            (is (= "2000-02-01 10"  (format-date-using-desired-format calendar "yyyy-MM-dd hh")))
            (is (= "2000-02-01 10:20"  (format-date-using-desired-format calendar "yyyy-MM-dd hh:mm")))
            (is (= "2000-02-01 10:20:30"  (format-date-using-desired-format calendar "yyyy-MM-dd hh:mm:ss"))))))

(deftest test-format-date-time-1
    "Check the function clj-calendar.calendar/format-date-time"
    (testing "the function clj-calendar.calendar/format-date-time"
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 01 10 20 30)
            (is (= "2000-02-01 10:20:30" (format-date-time calendar))))))

(deftest test-format-date-time-2
    "Check the function clj-calendar.calendar/format-date-time"
    (testing "the function clj-calendar.calendar/format-date-time"
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 01 10 20 30)
            (is (= "2000-01-01 10:20:30" (format-date-time calendar))))))

(deftest test-format-date-time-3
    "Check the function clj-calendar.calendar/format-date-time"
    (testing "the function clj-calendar.calendar/format-date-time"
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 31 10 20 30)
            (is (= "2000-01-31 10:20:30" (format-date-time calendar))))))

(deftest test-format-date-time-4
    "Check the function clj-calendar.calendar/format-date-time"
    (testing "the function clj-calendar.calendar/format-date-time"
        (let [calendar (get-calendar)]
            (.set calendar 2000 11 31 10 20 30)
            (is (= "2000-12-31 10:20:30" (format-date-time calendar))))))

(deftest test-format-date-time-5
    "Check the function clj-calendar.calendar/format-date-time"
    (testing "the function clj-calendar.calendar/format-date-time"
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 01 00 00 00)
            (is (= "2000-01-01 00:00:00" (format-date-time calendar))))))

(deftest test-get-year
    "Check the function clj-calendar.calendar/get-year"
    (testing "the function clj-calendar.calendar/get-year"
        (let [calendar (get-calendar)]
            (doseq [year (range 1 9999)]
                (.set calendar year 00 01 00 00 00)
                (is (= year (get-year calendar)))))))

(deftest test-get-month
    "Check the function clj-calendar.calendar/get-month"
    (testing "the function clj-calendar.calendar/get-month"
        (let [calendar (get-calendar)]
            (doseq [month (range 1 13)]
                (.set calendar 2000 month 00 00 00)
                (is (= month (get-month calendar)))))))

(deftest test-get-day-1
    "Check the function clj-calendar.calendar/get-month"
    (testing "the function clj-calendar.calendar/get-month"
        (let [calendar (get-calendar)]
            (doseq [day (range 1 31)]
                (.set calendar 2000 00 day 00 00)
                (is (= day (get-day calendar)))))))

(deftest test-get-day-2
    "Check the function clj-calendar.calendar/get-month"
    (testing "the function clj-calendar.calendar/get-month"
        (let [calendar (get-calendar)]
            (doseq [day (range 1 29)]
                (.set calendar 2000 01 day 00 00)
                (is (= day (get-day calendar)))))))

(deftest test-get-week-1
    "Check the function clj-calendar.calendar/get-week"
    (testing "the function clj-calendar.calendar/get-week"
        (let [calendar (get-calendar)]
            (doseq [week (range 1 52)]
                (.set calendar java.util.Calendar/WEEK_OF_YEAR week)
                (is (= week (get-week calendar)))))))

(deftest test-get-week-2
    "Check the function clj-calendar.calendar/get-week"
    (testing "the function clj-calendar.calendar/get-week"
        (let [calendar (get-calendar)]
            (doseq [week (range 1 52)]
                (.set calendar java.util.Calendar/YEAR 2000)
                (.set calendar java.util.Calendar/WEEK_OF_YEAR week)
                (is (= week (get-week calendar)))))))

(deftest test-get-day-of-week
    "Check the function clj-calendar.calendar/get-day-of-week"
    (testing "the function clj-calendar.calendar/get-day-of-week"
        (let [calendar (get-calendar)]
            (doseq [day (range 1 365)]
                ; don't change the year, it's preciselly selected :)
                (.set calendar java.util.Calendar/YEAR 2001)
                (.set calendar java.util.Calendar/DAY_OF_YEAR day)
                (is (= (inc (mod day 7)) (get-day-of-week calendar)))))))

(deftest test-get-calendar-for-week
    "Check the function clj-calendar.calendar/get-calendar-for-week"
    (testing "the function clj-calendar.calendar/get-calendar-for-week"
        ; first week might be set for the previous year
        (let [calendar (get-calendar-for-week 2000 2)]
            (are [x y] (= x y)
                2000 (get-year calendar)
                1    (get-month calendar)
                2    (get-week calendar)))))

(deftest test-calculate-first-day-of-week-1
    "Check the function clj-calendar.calendar/calculate-first-day-of-week"
    (testing "the function clj-calendar.calendar/calculate-first-day-of-week"
        (doseq [year (range 2000 2010)]
            (doseq [week (range 1 52)]
                ; must be zero, because we get 1st day of each week
                (is (zero? (calculate-first-day-of-week (get-calendar-for-week year week))))))))

(deftest test-calculate-first-day-of-week-2
    "Check the function clj-calendar.calendar/calculate-first-day-of-week"
    (testing "the function clj-calendar.calendar/calculate-first-day-of-week"
        (let [calendar (get-calendar)]
            (doseq [day (range 1 365)]
                ; don't change the year!
                (.set calendar java.util.Calendar/YEAR 2001)
                (.set calendar java.util.Calendar/DAY_OF_YEAR day)
                (is (= (- 0 (mod day 7)) (calculate-first-day-of-week calendar)))))))

(deftest test-get-first-day-of-week
    "Check the function clj-calendar.calendar/calculate-first-day-of-week"
    (testing "the function clj-calendar.calendar/calculate-first-day-of-week"
        (let [calendar1 (get-calendar)
              calendar2 (get-calendar)
              calendar3 (get-calendar)]
            (.set calendar1 java.util.Calendar/YEAR 2000)
            (.set calendar1 java.util.Calendar/WEEK_OF_YEAR 2)
            (.set calendar2 java.util.Calendar/YEAR 2000)
            (.set calendar2 java.util.Calendar/WEEK_OF_YEAR 3)
            (.set calendar3 java.util.Calendar/YEAR 2000)
            (.set calendar3 java.util.Calendar/WEEK_OF_YEAR 4)
            (are [x y] (= x (format-date y))
                "2000-01-02" (get-first-day-of-week calendar1)
                "2000-01-09" (get-first-day-of-week calendar2)
                "2000-01-16" (get-first-day-of-week calendar3)))))

(deftest test-get-last-day-of-week
    "Check the function clj-calendar.calendar/calculate-last-day-of-week"
    (testing "the function clj-calendar.calendar/calculate-last-day-of-week"
        (let [calendar1 (get-calendar)
              calendar2 (get-calendar)
              calendar3 (get-calendar)]
            (.set calendar1 java.util.Calendar/YEAR 2000)
            (.set calendar1 java.util.Calendar/WEEK_OF_YEAR 2)
            (.set calendar2 java.util.Calendar/YEAR 2000)
            (.set calendar2 java.util.Calendar/WEEK_OF_YEAR 3)
            (.set calendar3 java.util.Calendar/YEAR 2000)
            (.set calendar3 java.util.Calendar/WEEK_OF_YEAR 4)
            (are [x y] (= x (format-date y))
                "2000-01-08" (get-last-day-of-week calendar1)
                "2000-01-15" (get-last-day-of-week calendar2)
                "2000-01-22" (get-last-day-of-week calendar3)))))

(deftest test-format-time-1
    "Check the function clj-calendar.calendar/format-time"
    (testing "the function clj-calendar.calendar/format-time"
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 01 10 20 30)
            (is (= "10:20:30" (format-time calendar))))))

(deftest test-format-time-2
    "Check the function clj-calendar.calendar/format-time"
    (testing "the function clj-calendar.calendar/format-time"
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 01 10 20 60)
            (is (= "10:21:00" (format-time calendar))))))

(deftest test-format-time-3
    "Check the function clj-calendar.calendar/format-time"
    (testing "the function clj-calendar.calendar/format-time"
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 01 10 60 60)
            (is (= "11:01:00" (format-time calendar))))))

(deftest test-get-first-day-of-week-1
    "Check the function clj-calendar.calendar/get-first-day-of-week"
    (testing "the function clj-calendar.calendar/get-first-day-of-week"
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 1 00 00 00)
            (is (= "1999-12-26" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 2 00 00 00)
            (is (= "2000-01-02" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 3 00 00 00)
            (is (= "2000-01-02" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 4 00 00 00)
            (is (= "2000-01-02" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 5 00 00 00)
            (is (= "2000-01-02" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 6 00 00 00)
            (is (= "2000-01-02" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 7 00 00 00)
            (is (= "2000-01-02" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 8 00 00 00)
            (is (= "2000-01-02" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 9 00 00 00)
            (is (= "2000-01-09" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 10 00 00 00)
            (is (= "2000-01-09" (get-first-day-of-week-formatted calendar))))))

(deftest test-get-first-day-of-week-2
    "Check the function clj-calendar.calendar/get-first-day-of-week"
    (testing "the function clj-calendar.calendar/get-first-day-of-week"
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 1 00 00 00)
            (is (= "2000-01-30" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 2 00 00 00)
            (is (= "2000-01-30" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 3 00 00 00)
            (is (= "2000-01-30" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 4 00 00 00)
            (is (= "2000-01-30" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 5 00 00 00)
            (is (= "2000-01-30" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 6 00 00 00)
            (is (= "2000-02-06" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 7 00 00 00)
            (is (= "2000-02-06" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 8 00 00 00)
            (is (= "2000-02-06" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 9 00 00 00)
            (is (= "2000-02-06" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 10 00 00 00)
            (is (= "2000-02-06" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 11 00 00 00)
            (is (= "2000-02-06" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 12 00 00 00)
            (is (= "2000-02-06" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 13 00 00 00)
            (is (= "2000-02-13" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 01 14 00 00 00)
            (is (= "2000-02-13" (get-first-day-of-week-formatted calendar))))))

(deftest test-get-first-day-of-week-3
    "Check the function clj-calendar.calendar/get-first-day-of-week"
    (testing "the function clj-calendar.calendar/get-first-day-of-week"
        (let [calendar (get-calendar)]
            (.set calendar 2000 11 1 00 00 00)
            (is (= "2000-11-26" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 11 2 00 00 00)
            (is (= "2000-11-26" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 11 3 00 00 00)
            (is (= "2000-12-03" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 11 4 00 00 00)
            (is (= "2000-12-03" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 11 5 00 00 00)
            (is (= "2000-12-03" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 11 6 00 00 00)
            (is (= "2000-12-03" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 11 7 00 00 00)
            (is (= "2000-12-03" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 11 8 00 00 00)
            (is (= "2000-12-03" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 11 9 00 00 00)
            (is (= "2000-12-03" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 11 10 00 00 00)
            (is (= "2000-12-10" (get-first-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 11 11 00 00 00)
            (is (= "2000-12-10" (get-first-day-of-week-formatted calendar))))))

(deftest test-get-last-day-of-week-1
    "Check the function clj-calendar.calendar/get-last-day-of-week"
    (testing "the function clj-calendar.calendar/get-last-day-of-week"
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 1 00 00 00)
            (is (= "2000-01-01" (get-last-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 2 00 00 00)
            (is (= "2000-01-08" (get-last-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 3 00 00 00)
            (is (= "2000-01-08" (get-last-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 4 00 00 00)
            (is (= "2000-01-08" (get-last-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 5 00 00 00)
            (is (= "2000-01-08" (get-last-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 6 00 00 00)
            (is (= "2000-01-08" (get-last-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 7 00 00 00)
            (is (= "2000-01-08" (get-last-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 8 00 00 00)
            (is (= "2000-01-08" (get-last-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 9 00 00 00)
            (is (= "2000-01-15" (get-last-day-of-week-formatted calendar))))
        (let [calendar (get-calendar)]
            (.set calendar 2000 00 10 00 00 00)
            (is (= "2000-01-15" (get-last-day-of-week-formatted calendar))))))

