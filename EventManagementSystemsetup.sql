CREATE DATABASE EventManagement;
USE EventManagement;

CREATE TABLE Events (
    event_id INT AUTO_INCREMENT PRIMARY KEY,
    event_name VARCHAR(100) NOT NULL,
    event_date DATE NOT NULL,
    event_location VARCHAR(100),
    event_description TEXT
);

CREATE TABLE Participants (
    participant_id INT AUTO_INCREMENT PRIMARY KEY,
    event_id INT,
    participant_name VARCHAR(100),
    participant_email VARCHAR(100),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

