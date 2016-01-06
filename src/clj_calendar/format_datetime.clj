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

(ns clj-calendar.format-datetime
    "Namespace that contains various functions for handling calendar and dates.")

(defn format-time
    "Format a given time unit into human readable format."
    [amount unit]
    (format "%d %s ago" amount unit))

(defn format-time-
    "Format time into human readable format."
    [amount1 amount2 unit1 unit2]
    (if (= amount1 1)
        (cond
            (= amount2 0) (format "one %s ago" unit1)
            (= amount2 1) (format "one %s and one %s ago" unit1 unit2)
            :else         (format "one %s and %d %ss ago" unit1 amount2 unit2))
        (cond
            (= amount2 0) (format "%d %ss ago" amount1 unit1)
            (= amount2 1) (format "%d %ss and one %s ago" amount1 unit1 unit2)
            :else         (format "%d %ss and %d %ss ago" amount1 unit1 amount2 unit2))))

