use classicmodels;
-- drop database mysqlsampledatabase;

SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.';
SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactFirstName = 'King';

explain SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.';
EXPLAIN SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactFirstName = 'King';

-- ALTER TABLE customers ADD INDEX idx_customerName(customerName); 
create index inx_customerName on customers(customerName);

-- ALTER TABLE customers ADD INDEX idx_full_name(contactFirstName, contactLastName);
create index idx_full_name on customers(contactFirstName, contactLastName);

/* Xoa index trong bang */
ALTER TABLE customers DROP INDEX idx_full_name;