create database library;
use library;


create table books (
	book_id varchar(20) not null,
    book_name varchar(50),
    book_author varchar(50),
    book_description varchar(50),
    book_amount int,
    primary key (book_id)
);

create table students (
	student_id int auto_increment,
    student_name varchar(50),
    student_class varchar(50),
    primary key (student_id)
);

create table cards (
	card_id int auto_increment,
    card_status bit(1),
    rent_date date,
    return_date date,
    book_id varchar(20),
    student_id int,
    primary key (card_id),
    foreign key(book_id) references books(book_id),
    foreign key(student_id) references students(student_id)
); 

DELIMITER //
create procedure get_book_by_id(in book_id varchar(20))
begin
	select * 
    from books
    where books.book_id = book_id;
end //
DELIMITER ;

DELIMITER //
create procedure find_all_student()
begin
	select card_id, cards.book_id, book_name, book_author, student_name, student_class, rent_date, return_date
	from cards
	join students on students.student_id = cards.student_id
	join books on books.book_id = cards.book_id;
end //
DELIMITER ;



 -- thuê sách và giảm số lượng đi 1   
DELIMITER //
create procedure rent_book(
	-- in card_id varchar(20), 
 	in book_id varchar(20),
    in student_id int,
    in rent_date date,
    in return_date date
)
begin
	insert into cards(book_id, student_id, rent_date, return_date, card_status)
    values(book_id, student_id, date(now()), return_date, b'1');
    
    update books set book_amount = book_amount - 1 where books.book_id = book_id;
end //
DELIMITER ;



update books set book_amount = book_amount - 1 where book_id = "S-0001";
select * from books;
select * from cards;
select * from students;
truncate cards;