create database _ss1_practice;
drop database _ss1_practice;

use _ss1_practice;
create table students(
	code_student int auto_increment,
    name_student varchar(100) not null,
    date_of_birth date,
    gender bit(1),
    primary key(code_student)
);