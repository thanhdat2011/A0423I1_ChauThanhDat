create database sales_management;

use sales_management;

create table customers(
	cID varchar(30),
    cName varchar(30),
    cAge date,
    primary key(cID)
);

create table orders(
	oID varchar(30),
    oDate date,
    oTotalPrice double,
    cID varchar(30) unique,
    primary key(oID),
    foreign key(cID) references customers(cID)
);

create table products(
	pID varchar(30),
    pName varchar(30),
    pPrice double,
    primary key(pID)
);

create table order_detail_product(
	oID varchar(30) unique,
    pID varchar(30) unique,
    odQTY int,
    primary key(oID, pID),
    foreign key(oID) references orders(oID),
    foreign key(pID) references products(pID)
);


