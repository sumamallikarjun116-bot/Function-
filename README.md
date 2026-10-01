# FunctionHallBooking

Java Servlet + JDBC + MySQL function hall booking web application.

## Requirements
- JDK 17+
- Apache Tomcat 10.1+
- MySQL 8+
- MySQL Connector/J
- Jakarta Servlet API

## Database
Run `database/functionhall.sql` in MySQL.

Update username/password in:
`src/main/java/com/functionhall/util/DBConnection.java`

## Deploy
Create a Dynamic Web Project/Maven web application and copy these files into the matching folders.
Add MySQL Connector/J to the project.
Deploy the WAR to Tomcat.

Default admin:
email: admin@hallbook.com
password: admin123

For production, use hashed passwords and proper authentication/authorization.
