create database product_management;

use product_management;

/* Base table */
create table deliverybills(
	delivery_number bigint,
    delivery_date date,
    primary key(delivery_number)
);

create table supplies(
	supply_code varchar(50),
    supply_name varchar(100),
    primary key(supply_code)
);

create table importbills(
	import_number bigint,
    import_date date,
    primary key(import_number)
);

create table manufactures(
	manufacture_code varchar(50),
    manufacture_name varchar(100),
    manufacture_address varchar(100),
    primary key(manufacture_code)
);

/* Đa trị manufacture_phone của manufacture */
create table manufacture_phones(
	id int auto_increment,
	manufacture_phone varchar(20),
    manufacture_code varchar(50),
    primary key(id),
    foreign key(manufacture_code) references manufactures(manufacture_code)
);

/* 4. Manufacture provide order (1-n) */
create table orders(
	order_number bigint,
    order_date date,
    manufacture_code varchar(50) unique,
    primary key(order_number),
    foreign key(manufacture_code) references manufactures(manufacture_code)
);


/* 1. Detail of delivery bill (n-n) */
create table deliverybill_detailed_supply(
	delivery_price double,
    delivery_amount int,
    delivery_number bigint,
    supply_code varchar(50),
    primary key(delivery_number, supply_code),
    foreign key(delivery_number) references deliverybills(delivery_number),
	foreign key(supply_code) references supplies(supply_code)
);

/* 2. Detail of import bill (n-n) */
create table importbill_detailed_supply(
	import_price double,
    import_amount int,
    import_number bigint,
    supply_code varchar(50),
    primary key(import_number, supply_code),
    foreign key(import_number) references importbills(import_number),
    foreign key(supply_code) references supplies(supply_code)
);

/* 3. Detail of order (n-n) */
create table order_detailed_supply(
	order_number bigint,
    supply_code varchar(50),
    primary key(order_number, supply_code),
    foreign key(order_number) references orders(order_number),
    foreign key(supply_code) references supplies(supply_code)
);

-- drop table supplies;
-- drop table deliverybills;
-- drop table importbills;
-- drop table manufactures;
-- drop table orders;
-- drop table manufacture_phones;

-- select * from supplies;
-- select * from manufactures;
-- select * from manufacture_phones;


