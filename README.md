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
[https://clojars.org/clj-calendar/versions/0.3.0-SNAPSHOT](https://clojars.org/clj-calendar/versions/0.3.0-SNAPSHOT)
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

### Usage of clj-calendar/format-datetime

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

