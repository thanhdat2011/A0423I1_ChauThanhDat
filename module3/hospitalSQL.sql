create database hospital;
use hospital;

create table benh_an(
	benhan_id varchar(20),
    indate date,
    outdate date,
    reason varchar(50),
    primary key (benhan_id)
);

create table benh_nhan(
	benhnhan_id varchar(20),
    benhnhan_name varchar(20),
    benhan_id varchar(20),
    primary key (benhnhan_id),
    foreign key (benhan_id) references benh_an(benhan_id)
);
truncate benh_nhan;
INSERT INTO `hospital`.`benh_nhan` (`benhnhan_id`, `benhnhan_name`, `benhan_id`) VALUES ('BN-434', 'Nguyễn Văn A', 'BA-001');
INSERT INTO `hospital`.`benh_nhan` (`benhnhan_id`, `benhnhan_name`, `benhan_id`) VALUES ('BN-123', 'Nguyễn Văn C', 'BA-112');
INSERT INTO `hospital`.`benh_nhan` (`benhnhan_id`, `benhnhan_name`, `benhan_id`) VALUES ('BN-984', 'Tôn Nữ D', 'BA-223');
INSERT INTO `hospital`.`benh_nhan` (`benhnhan_id`, `benhnhan_name`, `benhan_id`) VALUES ('BN-153', 'Đoàn Thị E', 'BA-444');

select * from benh_an;
select * from benh_nhan;

DELIMITER //
create procedure find_all_benh_an()
begin
	select benh_an.benhan_id, benhnhan_id, benhnhan_name, indate, outdate, reason from benh_nhan
	join benh_an on benh_nhan.benhan_id = benh_an.benhan_id
	order by benh_an.benhan_id;
end //
DELIMITER ;

DELIMITER //
create procedure find_benh_an_by_id(in benhan_id varchar(20))
begin
	select benh_an.benhan_id, benhnhan_id, benhnhan_name, indate, outdate, reason from benh_nhan
	join benh_an on benh_nhan.benhan_id = benh_an.benhan_id
	where benh_an.benhan_id = benhan_id;
end //
DELIMITER ;

DELIMITER //
create procedure update_benh_an(in benhan_id varchar(20), benhnhan_name varchar(20), indate date, oudate date, reason varchar(50))
begin
	update benh_nhan set benhnhan_name = benhnhan_name where benh_nhan.benhan_id = benhan_id;
    update benh_an set indate = indate, outdate = outdate, reason = reason where benh_an.benhan_id = benhan_id;
end //
DELIMITER ;


-- chưa xong
DELIMITER //
create procedure delete_benh_an (in benhan_id varchar(20), benhnhan_name varchar(20), indate date, oudate date, reason varchar(50))
begin
	update benh_nhan set benhnhan_name = benhnhan_name where benh_nhan.benhan_id = benhan_id;
    update benh_an set indate = indate, outdate = outdate, reason = reason where benh_an.benhan_id = benhan_id;
end //
DELIMITER ;