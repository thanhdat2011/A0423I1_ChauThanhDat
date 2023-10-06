use student_management;

select * from classes;
select * from students;
select * from subjects;
select * from marks;

/* Hiển thị danh sách tất cả các học viên.*/
select * from students;

/* Hiển thị danh sách các học viên đang theo học.*/
select * from students where student_status = true;

/* Hiển thị danh sách các môn học có thời gian học nhỏ hơn 10 giờ.*/
select * from subjects where sub_credit < 10;

/* Hiển thị danh sách học viên lớp A1.*/
select * from students where class_ID = 1;

/* Hiển thị điểm môn PRO của các học viên.*/
select student_name, sub_name, mark from students
join marks on students.student_ID = marks.student_ID
join subjects on marks.sub_ID = subjects.sub_ID
where sub_name = 'PRO';