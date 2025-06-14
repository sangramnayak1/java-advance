DROP database if EXISTS SANGRAM;
CREATE database SANGRAM;
use SANGRAM;
CREATE TABLE users (
	username varchar (10),
	password varchar (10)
);
insert into users (username, password) values ('admin', "adminpass");
insert into users (username, password) values ('sangram', "adminpass");
select * from users;
