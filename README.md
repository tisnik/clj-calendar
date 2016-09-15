# clj-calendar

This library contains set of functions that could be useful for working with
the calendar, date, and time values. Library is divided into two modules named
*calendar* and *format-datetime*. The first module contains various functions
to get current time, format time etc. The second module contains functions that
can convert a given date (or difference between two dates) into human readable
sentence like: "one day and 2 hours ago" etc.

## Installation

Usually no manual installation is required. Just use *Leiningen* or *Maven* to
integrate *clj-calendar* into your project.

### Manual installation

If you don't want to use *Leiningen*, you can manually download project snapshot
from
[https://clojars.org/org.clojars.tisnik/clj-calendar/versions/0.3.0-SNAPSHOT](https://clojars.org/org.clojars.tisnik/clj-calendar/versions/0.3.0-SNAPSHOT)
and integrate the source file into your project. Or simply clone the following
GIT repository:
[https://github.com/tisnik/clj-calendar](https://github.com/tisnik/clj-calendar)

[![Clojars Project](https://img.shields.io/clojars/v/org.clojars.tisnik/clj-calendar.svg)](https://clojars.org/org.clojars.tisnik/clj-calendar)

### Leiningen

    [clj-calendar "0.3.0-SNAPSHOT"]

### Gradle

    compile "clj-calendar:clj-calendar:0.3.0-SNAPSHOT"

### Maven

    <dependency>
        <groupId>clj-calendar</groupId>
        <artifactId>clj-calendar</artifactId>
        <version>0.3.0-SNAPSHOT</version>
    </dependency>

## Usage

As mentioned above there are two set of functions divided into two namespaces
(modules):

- clj-calendar/calendar
- clj-calendar/format-datetime

### Usage of clj-calendar/calendar

    (use '[clj-calendar.calendar])
    nil

    (get-calendar)
    #inst "2016-09-15T20:59:36.773+02:00"

    (get-calendar-for-week 2016 1)
    #inst "2015-12-27T00:00:00.000+01:00"

    (get-year (get-calendar))
    2016

    (def c (get-calendar))

    (get-year c)
    2016

    (get-month c)
    9

    (get-day c)
    15

    (get-week c)
    38

    (get-day-of-week c)
    5

    (calculate-first-day-of-week c)
    -4

    (get-first-day-of-week c)
    #inst "2016-09-11T21:00:18.781+02:00"

    (get-last-day-of-week c)
    #inst "2016-09-17T21:00:18.781+02:00"

    (format-current-date)
    "2016-09-15"


### Usage of clj-calendar/format-datetime

    (format-time- 1 2  "minute" "second")
    "one minute and 2 seconds ago"

    (format-time- 1 4  "day" "hour")
    "one day and 4 hours ago"

    (format-time 1 "month")
    "1 month ago"

    (format-time 2 "months")
    "2 months ago"

    (format-time 1 "year")
    "1 year ago"

    (format-time 2 "years"))))
    "2 years ago"

    (format-month 1 1)
    "one month and one day ago"

    (format-month 1 2)
    "one month and 2 days ago"

    (format-month 0 1)
    "one day ago"

    (format-day 1 1)
    "one day and one hour ago"

    (format-day 1 2)
    "one day and 2 hours ago"

    (format-day 2 1)
    "2 days and one hour ago"

    (format-day 2 2)
    "2 days and 2 hours ago"

### API Documentation

## Leiningen targets

The following *Leiningen* targets are supported by the current version of this module:

### Run unit tests

    lein test

### Measure code coverage

    lein cloverage

### Generate or regenerate documentation

    lein doc

### Bugs

## License

Copyright © 2015, 2016  Pavel Tisnovsky

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

