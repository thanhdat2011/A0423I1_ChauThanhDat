create database student_management;

use student_management;

create table classes(
	class_ID int auto_increment,
    class_name varchar(30) not null,
    class_startDate datetime not null,
    class_status bit(1),
    primary key(class_ID)
);

create table students(
	student_ID int auto_increment,
    student_name varchar(30) not null,
    student_address varchar(50),
    student_phone varchar(20),
    student_status bit,
    class_ID int not null,
    primary key(student_ID),
    foreign key(class_ID) references classes(class_ID)
);

create table subjects(
	sub_ID int auto_increment,
    sub_name varchar(30) not null,
    sub_credit tinyint not null default'1' check (sub_credit>=1),
    sub_status bit(1),
    primary key(sub_ID)
);

create table marks(
	mark_ID int auto_increment,
    mark float default '0' check(mark between 0 and 100),
    examtime tinyint default '1',
    sub_ID int not null,
    student_ID int not null,
    primary key(mark_ID),
    unique(sub_ID, student_ID),
    foreign key(sub_ID) references subjects(sub_ID),
    foreign key(student_ID) references students(student_ID)
);

/* Display table */
select * from classes;
select * from students;
select * from subjects;
select * from marks;

/* Display table with condition use join */
select students.student_name, marks.mark from students join marks
on students.student_ID = marks.student_ID
where mark >= 10
order by students.student_ID asc;

/* insert class */
insert into classes values(1, 'Andy', '2000-11-20', b'1');
insert into classes values(2, 'A2', '2000-09-15', b'1');
insert into classes values(3, 'A3', current_date, b'0');
insert into classes 
values	(4, 'A4', '2000-12-22', b'1'),
		(5, 'A5', '2023-12-01', b'1'),
		(6, 'A6', '2011-12-11', b'1');


/* insert student */
insert into students(student_name, student_address, student_phone, student_status, class_ID)
values('Dat', 'Da Nang', '0905123456', b'1', 1);

insert into students(student_name, student_address, student_phone, student_status, class_ID)
values('Huy', 'Da Nang', '0905123456', b'1', 1);

insert into students(student_name, student_address, student_phone, student_status, class_ID)
values('Hieu', 'Da Nang', '0905123456', b'1', 2);

insert into students(student_name, student_address, student_phone, student_status, class_ID)
values	('Cham', 'Da Nang', '0935223223', b'1', 1),
		('Khoi', 'USA', '0942345987', b'0', 2),
		('Ngan', 'Sai Gon', '987654321', b'0', 3);

insert into subjects
values	(1, 'MAD', 5, 1),
		(2, 'OSG', 6, 1),
		(3, 'SSG', 5, 1),
		(4, 'PRO', 10, 1);
        
insert into subjects values(5, 'CSD', 6, 1);
        
insert into marks(sub_ID, student_ID, mark, examtime)
values	(1, 1, 8, 1),
		(1, 2, 10, 2),
		(2, 1, 12, 1);

insert into marks(sub_ID, student_ID, mark, examtime)
values	(1, 3, 8, 1),
		(2, 4, 10, 2),
		(3, 5, 6, 4),
		(4, 6, 12, 8);
        
/* Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’ */
select * from students
where student_namE like 'h%';

/* Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12. */
select * from classes
where month(class_startDate) = 12;

/* Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5. */
select * from subjects 
where sub_credit between 3 and 5;

/* Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Khoi’ là 10. */
update students set class_ID = 1 where student_name = 'Khoi';

/* Hiển thị các thông tin: StudentName, SubName, Mark. 
Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. 
nếu trùng sắp theo tên tăng dần. */

select student_name, sub_name, mark
from marks
right join students on marks.student_ID = students.student_ID
right join subjects on marks.sub_ID = subjects.sub_ID
-- where sub_name = 'MAD'
order by mark desc, student_name asc;

/* TEST */
select student_name, sum(mark), count(mark), sum(mark)/count(mark) as average
from marks
join students on marks.student_ID = students.student_ID
join subjects on marks.sub_ID = subjects.sub_ID
group by student_name
having average >= 10
order by average desc;

select student_name, sum(mark), count(mark), avg(mark) as average
from marks
join students on marks.student_ID = students.student_ID
join subjects on marks.sub_ID = subjects.sub_ID
group by student_name
having average >= 10
order by average desc;

