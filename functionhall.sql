CREATE DATABASE IF NOT EXISTS functionhall;
USE functionhall;

CREATE TABLE IF NOT EXISTS users(
 id INT AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(100) NOT NULL,
 email VARCHAR(120) UNIQUE NOT NULL,
 password VARCHAR(255) NOT NULL,
 role VARCHAR(20) DEFAULT 'USER'
);

CREATE TABLE IF NOT EXISTS halls(
 id INT AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(120) NOT NULL,
 location VARCHAR(150) NOT NULL,
 capacity INT NOT NULL,
 price DECIMAL(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS bookings(
 id INT AUTO_INCREMENT PRIMARY KEY,
 user_id INT NOT NULL,
 hall_id INT NOT NULL,
 booking_date DATE NOT NULL,
 event_name VARCHAR(150) NOT NULL,
 payment_method VARCHAR(40) NOT NULL,
 status VARCHAR(30) DEFAULT 'CONFIRMED',
 FOREIGN KEY(user_id) REFERENCES users(id),
 FOREIGN KEY(hall_id) REFERENCES halls(id)
);

INSERT INTO halls(name,location,capacity,price) VALUES
('Royal Grand Hall','Tirupati',800,75000),
('Lotus Convention Center','Chennai',500,55000),
('Green Garden Function Hall','Bengaluru',300,35000),
('Sri Lakshmi Mahal','Hyderabad',700,65000);

INSERT INTO users(name,email,password,role) VALUES
('Admin','admin@hallbook.com','admin123','ADMIN');