create database sales_management;
-- drop database sales_management;
use sales_management;

create table customers(
	cID int auto_increment,
    cName varchar(25),
    cAge tinyint,
    primary key(cID)
);

create table orders(
	oID int auto_increment,
    oDate datetime,
    oTotalPrice int,
    cID int,
    primary key(oID),
    foreign key(cID) references customers(cID)
);

create table products(
	pID int auto_increment,
    pName varchar(25),
    pPrice int,
    primary key(pID)
);

create table order_detail_product(
	oID int,
    pID int,
    odQTY int,
    primary key(oID, pID),
    foreign key(oID) references orders(oID),
    foreign key(pID) references products(pID)
);

/* Query to table */
select * from customers;
select * from orders;
select * from products;
select * from order_detail_product;

/* Insert data */
insert into customers(cName, cAge)
values	("Minh Quan", 10),
		("Ngoc Oanh", 20),
		("Hong Ha", 50);

insert into orders(cID, oDate)
values	(1, "2006-03-21"),
		(2, "2006-03-23"),
		(1, "2006-03-16");

insert into products(pName, pPrice)
values	("May Giat", 3),
		("Tu Lanh", 5),
		("Dieu Hoa", 7),
		("Quat", 1),
		("Bep Dien", 2);
        
insert into order_detail_product(oID, pID, odQTY)
values	(1, 1, 3),
		(1, 3, 7),
		(1, 4, 2),
		(2, 1, 1),
		(3, 1, 8),
		(2, 5, 4),
		(2, 3, 3);

/* Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order */
select * from orders;

/* Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách */
select cName, oDate, pName from customers
join orders on customers.cID = orders.cID
join order_detail_product on orders.oID = order_detail_product.oID
join products on  order_detail_product.pID = products.pID
order by cName, oDate;

/* Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào */
select * from customers
left join orders on customers.cID = orders.cID
where oID is null;

/* Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
(giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn.
Giá bán của từng loại được tính = odQTY*pPrice) */
select * from orders
join order_detail_product on orders.oID = order_detail_product.oID
join products on order_detail_product.pID = products.pID;

select orders.oID, oDate, sum(pPrice*odQTY) as total from orders
join order_detail_product on orders.oID = order_detail_product.oID
join products on order_detail_product.pID = products.pID
group by orders.oID;
/* Tai sao ko xep theo oDate duoc khi co oID */

