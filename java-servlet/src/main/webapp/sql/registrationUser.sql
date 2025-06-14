DROP database if EXISTS SANGRAM;
CREATE database SANGRAM;
use SANGRAM;
-- TABLE users is already created so modify the table to add more columns
ALTER TABLE users
ADD user_id int auto_increment unique key,
ADD first_name varchar(36),
ADD last_name varchar(36),
ADD age int,
ADD address varchar(250),
ADD contact varchar(10),
ADD email varchar(36);
show tables;
-- show columns from users;
-- describe SANGRAM.users;
desc SANGRAM.users;
select * from users;