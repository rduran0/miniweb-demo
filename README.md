# Miniweb Demo

## Description
Demo project that makes use of Java, MySQL and Spring for RESTful communication through get requests for backend and uses AngularJS, D3, nvD3, angular-nvD3 charts for visualization of data retrieved from database. Also makes use of JUnit 4 and Rest-assured 3.0.1 for testing.

## Notes
- SQL Script with database, tables and data creation is provided, refer to miniweb-demo/src/main/resources/mysql_scripts/DB_SCRIPT.sql.
- For the application to gain access to MySQL, the dataSource bean must be changed according to your MySQL user disponibility. Credentials are kept in miniweb-demo/src/main/resources/spring-mysql.xml:
  - Uri (http://$localhostName:$port/$databaseName) where $localhostName and $port corresponds to your localhost name and port defined in your MySQL server. $databaseName corresponds to the name of the database (ruleoflaw as provided in the database script).
  - username (miniweb) is your user name that has at least read privileges in your database.
  - password refers to the password used for your user to gain access.

## Changelog
- 1.0.0 - Demo finished with Rest-Assured simple tests.

## Contributors
- World Justice Project for the data set about rule of law: http://worldjusticeproject.org/