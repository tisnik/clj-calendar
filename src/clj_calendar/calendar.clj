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

