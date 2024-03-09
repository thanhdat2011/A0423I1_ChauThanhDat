use classicmodels;

/* IN: Đây là chế độ mặc định (nghĩa là nếu bạn không định nghĩa loại nào thì nó sẽ hiểu là IN). */

delimiter //
create procedure getCusById(in cusNum int) 	
begin
	select * from customers where customerNumber = cusNum;
end //
delimiter ;

call getCusByid(175);

/* Khi truyền tham số dạng OUT mục đích là lấy dữ liệu trong Procedure và sử dụng ở bên ngoài.
Khi truyền tham số vào dạng OUT phải có chữ @ đằng trước biến
Hoạt động giống tham chiếu nên biến truyền vào dạng OUT không cần định nghĩa trước, chính vì vậy khởi đầu nó có giá trị NULL*/

delimiter //
create procedure getCusCountByCity(in city varchar(50), out total int)
begin
	set total = (select count(customerNumber) from customers where customers.city = city);
end //
delimiter ;

call getCusCountByCity('Lyon',@total);

select @total;

/* INOUT là sự kết hợp giữa IN và OUT */

delimiter //

CREATE PROCEDURE SetCounter(INOUT counter INT, IN inc INT)
BEGIN
    SET counter = counter + inc;
END//

delimiter ;

SET @counter = 1;

CALL SetCounter(@counter,1); -- 2

CALL SetCounter(@counter,1); -- 3

CALL SetCounter(@counter,5); -- 8

SELECT @counter; -- 8

