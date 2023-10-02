create database orders_management;

use orders_management;

create table client_units(
	cu_code varchar(30),
    cu_name varchar(50) not null,
    cu_address varchar(30),
    cu_phone varchar(20),
    primary key(cu_code)
);

/* client relationship with client_unit */
create table clients(
	client_code varchar(30),
    client_name varchar(50) not null,
    cu_code varchar(30) unique,
    primary key(client_code),	
    foreign key(cu_code) references client_units(cu_code)
);

/* receiver relationship with client_unit - deliver_delivery */
create table receivers(
	r_code varchar(30),
    r_name varchar(50) not null,
    cu_code varchar(30) unique,
    primary key(r_code),
    foreign key(cu_code) references client_units(cu_code)
);

/*  */
create table supplies(
	supply_code varchar(30),
    supply_name varchar(50) not null,
    supply_unit varchar(20) default 'item',
    supply_description varchar(100),
    primary key(supply_code)
);


/* deliver relationship with deliver_delivery */
create table delivers(
	deliver_code varchar(30),
    deliver_name varchar(50) not null,
    primary key(deliver_code)
);

/* delivery_destination relationship with deliver_delivery */
create table delivery_destinations(
	des_code varchar(30),
    des_name varchar(50) not null,
    primary key(des_code)
);

/* client - supply */
create table client_order_supply(
	cos_code varchar(30),
    cos_date date,
    cos_amount int,
    client_code varchar(30),
    supply_code varchar(30),
    primary key(client_code, supply_code),
    foreign key(client_code) references clients(client_code),
    foreign key(supply_code) references supplies(supply_code)
);

/* supply - deliver - receiver - destination */
create table deliver_delivery(
	delivery_code varchar(30),
    delivery_date date,
    delivery_currency double,
    delivery_amount int,
    supply_code varchar(30),
    deliver_code varchar(30),
    r_code varchar(30),
    des_code varchar(30),
    primary key(supply_code, deliver_code, r_code, des_code),
    foreign key(supply_code) references supplies(supply_code),
    foreign key(deliver_code) references delivers(deliver_code),
    foreign key(r_code) references receivers(r_code),
    foreign key(des_code) references delivery_destinations(des_code)
);




