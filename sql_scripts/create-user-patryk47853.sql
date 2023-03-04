CREATE USER 'patryk47853'@'localhost' IDENTIFIED BY 'patryk47853';

GRANT ALL PRIVILEGES ON * . * TO 'patryk47853'@'localhost';

#
# Starting with MySQL 8.0.4, the MySQL team changed the 
# default authentication plugin for MySQL server 
# from mysql_native_password to caching_sha2_password.
#
# The command below will make the appropriate updates for your user account.
#
# See the MySQL Reference Manual for details: 
# https://dev.mysql.com/doc/refman/8.0/en/caching-sha2-pluggable-authentication.html
#
ALTER USER 'patryk47853'@'localhost' IDENTIFIED WITH mysql_native_password BY 'patryk47853';