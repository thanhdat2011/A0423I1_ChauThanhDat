use student_management;

select * from classes;
select * from students;
select * from subjects;
select * from marks;

/* Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.*/
select * from subjects 
where sub_credit in (select max(sub_credit) from subjects);

select *, max(sub_credit) from subjects group by subjects.sub_ID
having max(sub_credit) >= all (select max(sub_credit) from subjects);


/* Hiển thị các thông tin môn học có điểm thi lớn nhất.*/
select *, max(mark) from marks
join subjects on marks.sub_ID = subjects.sub_ID
group by mark_ID;

select *, max(mark) from marks
join subjects on marks.sub_ID = subjects.sub_ID
group by mark_ID
having max(mark) >= all(select max(mark) from marks);

/* Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần*/
select students.student_ID, student_name, student_phone, student_address, avg(mark) as average from students
join marks on students.student_ID = marks.student_ID
group by students.student_ID
order by average desc;


