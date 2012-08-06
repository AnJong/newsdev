CREATE DATABASE newsdev;

CREATE USER 'newsdev'@'localhost' IDENTIFIED BY 'newsdev';

GRANT USAGE ON * . * TO 'newsdev'@'localhost' IDENTIFIED BY 'newsdev' WITH MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0 ;

GRANT ALL PRIVILEGES ON `newsdev` . * TO 'newsdev'@'localhost';
