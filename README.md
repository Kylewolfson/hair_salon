# _Hair Salon client and stylist tracker_

#### _Allows salon owner to add stylists and then add customers to the stylists, saving the info to a sql database, 4/9/2016_

#### By _Kyle Wolfson_

## Description

_Allows salon owner to add stylists and then add customers to the stylists, saving the info to a sql database._

## Setup/Installation Requirements

* _Open psql_
* _run command in sql: CREATE DATABASE hair_salon_
* _run command in terminal (from the hair_salon directory): psql hair_salon < salon.sql_
* _run command from terminal: gradle run_
* _access the app via a browser at localhost:4567_

_The above instructions will import the database with a few initial entries, feel free to empty the tables out if you would prefer. You may also CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon if you would like to run tests with gradle_

## Known Bugs

_No front end delete functionality added at this time, entries can be deleted from the database using psql_

## Support and contact details

_wolfsonk@gmail.com_

## Technologies Used

_gradle, java, psql, Spark, Velocity_

### License

*MIT license*

Copyright (c) 2016 **_Kyle Wolfson_**
