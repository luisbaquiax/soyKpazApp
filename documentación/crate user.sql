/*creacion de usuario para la base de datos*/
CREATE USER 'soykpazong'@'localhost' IDENTIFIED BY 'soykpaz124@';
GRANT ALL PRIVILEGES ON *.* TO 'soykpazong'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;
