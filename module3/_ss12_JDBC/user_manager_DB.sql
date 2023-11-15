create database user_manager;
use user_manager;
drop table users;

create table users(
	user_id int not null auto_increment,
    user_name varchar(120) not null,
    user_email varchar(220) not null,
    user_country varchar(120),
    primary key(user_id)
);

select * from users;
-- select user_id,user_name,user_email,user_country from users where user_id = 4;
-- select * from users order by user_name;
-- select * from users where user_country = "Da Nang";

insert into users(user_name, user_email, user_country) 
values	('Minh','minh@codegym.vn','Viet Nam'),
		('Kante','kante@che.uk','Kenia');
        
        
DELIMITER //
create procedure get_user_by_id(in user_id int)
begin
	select user_name, user_email, user_country 
    from users
    where users.user_id = user_id;
end //
DELIMITER ;

delimiter //
create procedure insert_user(
	in user_name varchar(50),
    in user_email varchar(50),
    in user_country varchar(50)
)
begin
	insert into users(user_name, user_email, user_country) values (user_name, user_email, user_country);
end //
delimiter ;        
        
 delimiter //
 create procedure find_all_user_by_country(in country varchar(50))
 begin
	-- set country = country;
	select * from users where user_country like concat('%',country,'%');
 end//
 delimiter ;
        
        
        
        
        
        
        
        
        
        
        