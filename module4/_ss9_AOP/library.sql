use ex2_library;

select * from book;
select * from fptclass;
select * from student;
select * from student_rent_book;
truncate student_rent_book;
delete from book 
where book_id = 6 or book_id = 7;