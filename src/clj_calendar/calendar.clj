;
;  (C) Copyright 2015  Pavel Tisnovsky
;
;  All rights reserved. This program and the accompanying materials
;  are made available under the terms of the Eclipse Public License v1.0
;  which accompanies this distribution, and is available at
;  http://www.eclipse.org/legal/epl-v10.html
;
;  Contributors:
;      Pavel Tisnovsky
;

(ns clj-calendar.calendar
    "Namespace that contains various functions for handling calendar and dates.")

(defn get-calendar
    "Gets an instance of calendar using the default time zone and default locale."
    []
    (java.util.Calendar/getInstance))

(defn get-calendar-for-week
    "Gets a calendar for given year and week."
    [year week]
    (let [cal (get-calendar)]
        (.clear cal)
        (.set cal java.util.Calendar/WEEK_OF_YEAR week)
        (.set cal java.util.Calendar/YEAR year)
        cal))

(defn get-year
    "Returns the year for the current date."
    [calendar]
    (.get calendar java.util.Calendar/YEAR))

(defn get-week
    "Returns week number within the current year."
    [calendar]
    (.get calendar java.util.Calendar/WEEK_OF_YEAR))

(defn get-day-of-week
    "Returns day of week for given date."
    [calendar]
    (.get calendar java.util.Calendar/DAY_OF_WEEK))

(defn format-date-using-desired-format
    "Format given date using desired format, for example 'yyyy-MM-dd' etc."
    [calendar desired-format]
    (let [date-format (new java.text.SimpleDateFormat desired-format)]
        (.format date-format (.getTime calendar))))

(defn format-date
    "Format given date using the following format: 'yyyy-MM-dd'"
    [calendar]
    (format-date-using-desired-format calendar "yyyy-MM-dd"))

(defn format-date-time
    "Format given date using the following format: 'yyyy-MM-dd HH:mm:ss'"
    [calendar]
    (format-date-using-desired-format calendar "yyyy-MM-dd HH:mm:ss"))

