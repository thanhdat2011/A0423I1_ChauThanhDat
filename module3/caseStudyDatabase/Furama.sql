create database furama;

use furama;

create table positions(
	position_code int,
    position_name varchar(45),
    primary key(position_code)
);

create table levels(
	level_code int,
    level_name varchar(45),
    primary key(level_code)
);

create table departments(
	department_code int,
    department_name varchar(45),
    primary key(department_code)
);

create table customerTypes(
	customerType_code int,
    customerType_name varchar(45),
    primary key(customerType_code)
);

create table rentTypes(
	rentType_code int,
    rentType_name varchar(45),
    primary key(rentType_code)
);

create table serviceTypes(
	serviceType_code int,
    serviceType_name varchar(45),
    primary key(serviceType_code)
);

create table accompaniedServices(
	aS_code int,
    aS_name varchar(45),
    aS_price double,
    aS_unit varchar(10),
    aS_status varchar(45),
    primary key(aS_code)
);
-- alr create till here


create table services(
	service_code int,
    service_name varchar(45),
    service_area int,
    service_rentFee double,
    service_maxCustomer int,
    
    service_standardRoom varchar(45),
    service_descriptionOtherAmenities varchar(45),
    service_poolArea double,
    service_floorNumber int,
    
    rentType_code int,
    serviceType_code int,
    foreign key(rentType_code) references rentTypes(rentType_code),
    foreign key(serviceType_code) references serviceTypes(serviceType_code),
    primary key(service_code)
);

create table employees(
	employee_code int,
    employee_name varchar(45),
    employee_dob Date,
    employee_idCard varchar(45),
    employee_salary double,
    employee_phone varchar(45),
    employee_email varchar(45),
    employee_address varchar(45),
    
    position_code int,
    level_code int,
    department_code int,
    foreign key(position_code) references positions(position_code),
    foreign key(level_code) references levels(level_code),
    foreign key(department_code) references departments(department_code),
    primary key(employee_code)
);

create table customers(
	customer_code int,
    customer_name varchar(45),
    customer_dob Date,
    customer_gender bit(1),
    customer_idCard varchar(45),
    customer_phone varchar(45),
    customer_email varchar(45),
    customer_address varchar(45),
    
    customerType_code int,
    foreign key(customerType_code) references customerTypes(customerType_code),
    primary key(customer_code)
);

create table contracts(
	contract_code int,
    contract_startDate datetime,
    contract_endDate datetime,
    contract_deposit double,
    
    employee_code int,
    customer_code int,
    service_code int,
    foreign key(employee_code) references employees(employee_code),
    foreign key(customer_code) references customers(customer_code),
    foreign key(service_code) references services(service_code),
    primary key(contract_code)
);

create table contractDetails(
	contractDetail_code int,
    contractDetail_amount int,
    contract_code int,
    aS_code int,
    foreign key(contract_code) references contracts(contract_code),
    foreign key(aS_code) references accompaniedServices(aS_code),
    primary key(contractDetail_code)
);











