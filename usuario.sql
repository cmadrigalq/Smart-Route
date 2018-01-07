/**<<>><<>><<>>USUARIO<<>><<>><<>>*/
CREATE USER 'SMARTROUTE'@localhost 
IDENTIFIED BY '$SMARTROUTE$';
GRANT ALL PRIVILEGES ON * . * TO 'SMARTROUTE'@'localhost';
FLUSH PRIVILEGES;
/**<<>><<>><<>>USUARIO<<>><<>><<>>*/