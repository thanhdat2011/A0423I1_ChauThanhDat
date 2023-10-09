/* STEP 1 */
create database demo_index_view_SP;

use demo_index_view_SP;
-- drop table products;

/* STEP 2 */
create table products(
	id int auto_increment,
    productCode varchar(30),
    productName varchar(30),
    productPrice float,
    productAmount int,
    productDescription varchar(50),
    productStatus bit(1),
    primary key(id)
);

insert into products
values	(1, "P123", "Iphone 1", 300, 2, "First version", b'1'),
		(2, "P125", "Iphone 3", 400, 4, "Third version", b'0'),
		(3, "P119", "Iphone XS", 600, 10, "Famous version", b'0'),
		(4, "P130", "Iphone 10", 700, 7, "Last version", b'1'),
		(5, "P122", "Iphone 15", 2000, 1, "Newest version", b'1'),
		(6, "P138", "Iphone 20", 5000, 10, "New version", b'0');


/* STEP 3 */
/* display product with productCode */
select * from products where productCode = "P138";
explain select * from products where productCode = "P138";

select * from products where productName = "Iphone XS";
explain select * from products where productName = "Iphone XS";

/* Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục) */
create unique index idx_productCode on products(productCode);
-- alter table products drop index idx_productCode;

 
/* Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice) */
create index idx_pName_pPrice on products(productName, productPrice);
-- alter table products drop index idx_pName_pPrice;

/* STEP 4 */
/* Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products. */
create view product_view as
select productCode, productName, productPrice, productStatus
from products;

select * from product_view;

update product_view 
set productName = "Iphone Deep Purple 13" where productCode = "P123";

drop view product_view;

/* STEP 5 */
/* Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product */

delimiter //
create procedure findAllProduct()
begin
	select * from products;
end //
delimiter ;

call findAllProduct();

/* Tạo store procedure thêm một sản phẩm mới */
delimiter //
create procedure addProduct(pName varchar(30), pPrice float, pAmount int, pDes varchar(50))
begin 
	insert into products(productName, productPrice, productAmount, productDescription) values (pName, pPrice, pAmount, pDes);
end //
delimiter ;

call addProduct("IP 1000", 5000, 1, "Last and Best Version");

/* Tạo store procedure sửa thông tin sản phẩm theo id */
delimiter //
create procedure updateProductById(pID int, pCode varchar(30), pName varchar(30), pPrice float, pAmount int, pDes varchar(50), pStatus bit)
begin
	update products set productCode = pCode, productName = pName, productPrice = pPrice, productAmount = pAmount, productDescription = pDes, productStatus = pStatus
    where id = pID;
end //
delimiter ;

call updateProductById(2, "P_UPDATE", "Iphone XS_MAX", 1234, 10, "After update", 1);

/* Tạo store procedure xoá sản phẩm theo id */
delimiter //
create procedure deleteProductById(pID int)
begin
	delete from products where id = pID;
end //
delimiter ;

call deleteProductById(4);







