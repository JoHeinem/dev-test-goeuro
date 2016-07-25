## Introduction

This is small small application that queries the GoEuro Location API and stores the given information in a csv file. 

## Execution

Create a Java command line tool that takes as an input parameter a string

```
java -jar GoEuroTest.jar "CITY_NAME"
```

The program takes this string and queries with it the GoEuro Location JSON API: The app this API endpoint as follows:

http://api.goeuro.com/api/v2/position/suggest/en/CITY_NAME

Where CITY_NAME is the string that the user has entered as a parameter when calling the tool. The program takes the given information from the user input and creates a CSV file CITY_NAME.csv in the current directory from it. The CSV file stores the following attributes: _id, name, type, latitude, longitude.

## Task description

The exact task description can be found at the GoEuro Github account:
https://github.com/goeuro/dev-test/blob/master/README.md

