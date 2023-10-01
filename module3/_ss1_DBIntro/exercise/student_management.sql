/* create schema/ database named "student_management" */
create database student_management;

/* to interact with "student_management" database */
use student_management;

/* create students, teachers table */
create table students(
	code_student int auto_increment,
    name_student varchar(100),
    date_of_birth date,
    gender bit(1),
    primary key(code_student)
);

create table teachers(
	id_teacher int,
    name_teacher varchar(100),
    age_teacher int,
    country_teacher varchar(100),
    primary key(id_teacher)
);

/* Display students and teachers table */
select * from students;
select * from teachers;

select name_student, date_of_birth from students;
select name_student, date_of_birth from students
where name_student = "thanh dat" or date_of_birth = "2000-09-15";

/* insert into table */
insert into students values(1, "thanh dat", "2000-11-20", b'1');
insert into students(name_student, date_of_birth) values("xuan tram", "2000-09-15");
insert into students(name_student) values("Hue Khoi");
insert into students(name_student, date_of_birth) values("Minh Duc", "2000-02-02");
insert into teachers values(1, "Haruki sensei", "30", "Japan");
insert into teachers values(2, "A Quoc", "32", "Da Nang");
insert into teachers(id_teacher, age_teacher) values(3, "35");

/* update attribute in table */
update students set relationship = "inlove"
where code_student = 1;

update students set relationship = "a dog"
where code_student = 4 or code_student = 5;

/* update students set code_student = null  (primary key ko duoc null) */

/* set sql_safe_updates to update row with condition field which not primary key */
set sql_safe_updates = 0;
update teachers set country_teacher = "Tokyo"
where name_teacher = "Haruki sensei";
set sql_safe_updates = 1;

/* delete row in table */
delete from students where code_student = 3;

/* add/drop attribute(collum) to table using 'alter table' */
alter table students add relationship text;
alter table students add nothing text;
alter table students drop nothing;

/* 	How to add 'not null' to field name_student if we dont define before ?  yes
	If using alter which keyword we use ? 	modify
	alter table students modify name_student not null;  */
alter table teachers
modify country_teacher varchar(100);


-- drop table teachers;




