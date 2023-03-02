CREATE USER 'root'@'localhost' IDENTIFIED BY 'root';

GRANT ALL PRIVILEGES ON * . * TO 'root'@'localhost';

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';