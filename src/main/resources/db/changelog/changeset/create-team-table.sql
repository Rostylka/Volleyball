CREATE SEQUENCE team_seq START WITH 1 INCREMENT BY 1;

-- Create the teams table
CREATE TABLE teams (
                       id BIGINT PRIMARY KEY DEFAULT NEXTVAL('team_seq'),
                       name VARCHAR(255) NOT NULL,
                       coach VARCHAR(255),
                       city VARCHAR(255),
                       logo VARCHAR(255)
);

