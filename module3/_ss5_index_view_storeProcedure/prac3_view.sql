use classicmodels;

create view customer_views as
select customerNumber, customerName, Phone 
from customers;

select * from customer_views;

/* Update view can phai thoa man 1 so cac dieu kien*/
create or replace view customer_views as
select customerNumber, customerName, contactFirstName, contactLastName, phone
from customers
where city = "Nantes";	

/* Xoa view */
drop view customer_view;