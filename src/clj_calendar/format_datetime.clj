;
;  (C) Copyright 2015, 2016  Pavel Tisnovsky
;
;  All rights reserved. This program and the accompanying materials
;  are made available under the terms of the Eclipse Public License v1.0
;  which accompanies this distribution, and is available at
;  http://www.eclipse.org/legal/epl-v10.html
;
;  Contributors:
;      Pavel Tisnovsky
;

(ns clj-calendar.format-datetime
    "Namespace that contains various functions for handling calendar and dates.")

(defn one?
    "Predicate that is especially useful in this namespace."
    [n]
    (== n 1))

(defn format-time
    "Format a given time unit into human readable format."
    [amount unit]
    (format "%d %s ago" amount unit))

(defn format-time-
    "Format time into human readable format."
    [amount1 amount2 unit1 unit2]
    (if (one? amount1)
        (cond
            (zero? amount2) (format "one %s ago" unit1)
            (one? amount2)  (format "one %s and one %s ago" unit1 unit2)
            :else           (format "one %s and %d %ss ago" unit1 amount2 unit2))
        (cond
            (zero? amount2) (format "%d %ss ago" amount1 unit1)
            (one? amount2)  (format "%d %ss and one %s ago" amount1 unit1 unit2)
            :else           (format "%d %ss and %d %ss ago" amount1 unit1 amount2 unit2))))


(defn format-day
    "Format days/hours in case the given build is younger than one month."
    [days hours]
    (format-time- days hours "day" "hour"))

(defn format-hours
    "Format hours/minutes in case the given build is younger than one day."
    [hours minutes]
    (format-time- hours minutes "hour" "minute"))

(defn format-minutes
    "Format minutes/seconds in case the given build is younger than one hour"
    [minutes seconds]
    (format-time- minutes seconds "minute" "second"))

(defn format-seconds
    "Format seconds into human readable format."
    [seconds]
    (if (one? seconds)
        (format "one second ago")
        (format "%d seconds ago" seconds)))

(defn format-one-month
    "Format month into human readable format."
    [days]
    (cond (zero? days) "one month ago"
          (>  days 1)  (format "one month and %d days ago" days)
          :else        (format "one month and one day ago")))

(defn format-month
    "Format month into human readable format."
    [months days]
    (cond (zero? months) (format-day days 0)
          (> months 1)   (format "%d months ago" months)
          :else          (format-one-month days)))

