CREATE SEQUENCE player_seq START WITH 1 INCREMENT BY 1;

-- Create the players table
CREATE TABLE players (
                         id BIGINT DEFAULT NEXTVAL('player_seq') PRIMARY KEY,
                         first_name VARCHAR(255) NOT NULL,
                         last_name VARCHAR(255) NOT NULL,
                         position VARCHAR(255),
                         age INT,
                         height VARCHAR(255),
                         weight VARCHAR(255),
                         team_id BIGINT,
                         CONSTRAINT fk_players_team FOREIGN KEY (team_id) REFERENCES teams (id)
);