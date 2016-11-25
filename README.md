# hal-rest-example
Simple example of programmatic implementation of HAL in RESTful service using [SparkJava](http://sparkjava.com/).

This is not a real (nowadays) implementation but only mock GET API, a SparkJava example and a "good RESTful" design approach.

## Usage
mvn package

mvn exec:java -Dexec.mainClass="it.larus.assess.restspark.Application"

curl -v -H "Accept: application/json" http://localhost:8080/report/user/all/timesheet/2016

curl -v -H "Accept: application/json" http://localhost:8080/report/user/all/timesheet/2016/11

curl -v -H "Accept: application/json" http://localhost:8080/report/user/123/timesheet/2016/11

