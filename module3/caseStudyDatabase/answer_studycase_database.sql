use furama;

select * from employees;
select * from customers;
select * from services;


/* 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên 
bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.*/

select * from employees where employee_name regexp '^[H|T|K].{0,14}$';

/* 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi 
và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.*/

select 
		* 
from 
		customers
where 
		(year(now()) - year(customer_dob)) between 18 and 50
		and customer_address like '%Đà Nẵng' 
        or customer_address like '%Quảng Trị';

select 
		* 
from 
		customers
where 
		timestampdiff(year, customer_dob, now()) between 18 and 50
		and customer_address like '%Đà Nẵng' 
        or customer_address like '%Quảng Trị';

/* 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.*/
/* Có nghĩa là phải biết được khách hàng 'loại Dia' nào 'đã đặt phòng'
 =>>  customerTypes <- customers -> contracts */

select 
		cus.customer_code, 
        customer_name, 
        count(con.customer_code) as num_booking
from 
		customers as cus
		join customerTypes as cusT on cus.customerType_code = cusT.customerType_code
		join contracts as con on cus.customer_code = con.customer_code
where 
		customerType_name = "Diamond"
group by 
		con.customer_code
order by 
		num_booking;

/* 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
(Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) 
cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra). */
/* not done */

select 
		cus.customer_code, 
        customer_name, 
        customerType_name, 
        con.contract_code, 
        service_name, 
        contract_startDate, 
        contract_endDate, 
        -- sum(contractDetail_amount),
        -- sum(aS_price),
        service_rentFee,
        sum(contractDetail_amount*aS_price + service_rentFee) as 'Total Price'
from 
		customers as cus
		left join customerTypes as cusT on cus.customerType_code = cusT.customerType_code
		left join contracts as con on cus.customer_code = con.customer_code
		left join contractdetails as conDe on con.contract_code = conDe.contract_code
		left join accompaniedServices as accSer on conDe.aS_code = accSer.aS_code
		left join services as ser on con.service_code = ser.service_code
where 
		con.customer_code is not null 
group by 
		con.contract_code
order by 
		customer_code;

/* 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại 
dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3). */

select 
		service_code, 
        service_name, 
        service_area, 
        service_rentFee, 
        serviceType_name
from
		services as ser
		join serviceTypes as serT on ser.serviceType_code = serT.serviceType_code
where
		service_code not in
        -- not exists (can replace code line above)
        (select 
				con.service_code 
		from
				contracts as con
        where 
				ser.service_code = con.service_code and
				contract_startDate between "2021-01-01" and "2021-03-31");

/* 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu 
của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng 
trong năm 2021.*/

select 
		service_code, 
        service_name, 
        service_area, 
        service_maxCustomer, 
        service_rentFee, 
        serviceType_name
from
		services as ser
		join serviceTypes as serT on ser.serviceType_code = serT.serviceType_code
where	
		exists(
				select *
                from
						contracts as con
				where
						ser.service_code = con.service_code
                        and year(contract_startDate) = "2020")
		and not exists(
				select *
                from
						contracts as con
				where
						ser.service_code = con.service_code
                        and year(contract_startDate) = "2021");

/* 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên. */

select distinct customer_name from customers;

select customer_name from customers group by customer_name;

select customer_name from customers
union
select customer_name from customers;

/* 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với 
mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng. */


/* 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm.
Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem
(được tính dựa trên việc sum so_luong ở dich_vu_di_kem). */
/* not done */
select 
		con.contract_code, 
        contract_startDate, 
        contract_endDate, 
        contract_deposit, 
        sum(contractDetail_amount)
from 
		contracts as con
        left join contractDetails as conDe on con.contract_code = conDe.contract_code
group by
		con.contract_code;
        
/* 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng 
có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”. */
        
select
		*
from
		accompaniedServices as acc
where
		-- aS_name in
        exists
        (select
				aS_name 
        from
				customers as cus 
                join customerTypes as ct on cus.customerType_code = ct.customerType_code
                join contracts as c on cus.customer_code = c.customer_code
                join contractDetails as cd on c.contract_Code = cd.contract_Code
                join accompaniedServices as accSer on cd.aS_code = accSer.aS_code
		where
                acc.aS_code = accSer.aS_code and
				customerType_name = "Diamond"
                and customer_address like "%Vinh"
                or customer_address = "%Quãng Ngãi");
        
/*select
				aS_name 
        from
				customers as cus 
                join customerTypes as ct on cus.customerType_code = ct.customerType_code
                join contracts as c on cus.customer_code = c.customer_code
                join contractDetails as cd on c.contract_Code = cd.contract_Code
                join accompaniedServices as acc on cd.aS_code = acc.aS_code
		where
				customerType_name = "Diamond"
                and customer_address like "%Vinh"
                or customer_address = "%Quãng Ngãi";*/
        
        
/* 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, 
so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ 
đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.*/
        
select 
		c.contract_code, 
        employee_name,
        customer_name, 
        customer_phone, 
        service_name, 
        sum(contractDetail_amount) as number_of_accompanied_service, 
        contract_deposit
from
		contracts as c
        join employees as e on c.employee_code = e.employee_code
        join customers as cu on c.customer_code = cu.customer_code
        join services as s on c.service_code = s.service_code
        join contractDetails as cd on c.contract_code = cd.contract_code
where
		c.contract_code in (
				select 
						contract_code
                from
						contracts
				where
						contract_startDate between "2020-10-01" and "2020-12-31")
                        
		and c.contract_code not in (
				select 
						contract_code
                from
						contracts
				where
						contract_startDate between "2021-01-01" and "2021-06-30")
group by
		c.contract_code;
        
/*        
SELECT
    contract_code,
    employee_name nhan_vien,
    SUM(contract_deposit) tong_tien_coc,
    SUM(contractDetail_amount) tong_so_luong_dvdk
FROM
    contracts
    LEFT JOIN employees nv USING (employee_code)
    LEFT JOIN services USING (service_code)
    LEFT JOIN customers kh USING (customer_code)
    LEFT JOIN contractDetails using (contract_code)
    LEFT JOIN accompaniedServices USING (aS_code)
WHERE
    customer_code IN (
        SELECT
            customer_code
        FROM
            customers
            JOIN contracts USING(customer_code)
        WHERE
            contract_startDate BETWEEN '2020-10-01'
            AND '2020-12-30'
    )
    and customer_code NOT IN (
        SELECT
            customer_code
        FROM
            customers
            JOIN contracts USING(customer_code)
        WHERE
            contract_startDate BETWEEN '2021-01-01'
            AND '2021-06-30'
    )
GROUP BY
    contract_code;
 */       
        
/* 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
 (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).*/
        
select 
		aS_code, 
        aS_name, 
        sum(contractDetail_amount) as number_of_using_service
from
		accompaniedServices
        join contractDetails using (aS_code)
group by
		aS_code
having
		number_of_using_service >= all (select sum(contractDetail_amount) 
										from accompaniedServices
										join contractDetails using (aS_code)
										group by aS_code);
		
/* 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung 
(được tính dựa trên việc count các ma_dich_vu_di_kem).*/
		
select 
		-- c.contract_code,
        -- serviceType_name,
        aS_name,
        count(acs.aS_code) as number_of_using_service
from
		accompaniedServices as acs
        join contractDetails as cd on acs.aS_code = cd.aS_code
        join contracts as c on cd.contract_code = c.contract_code
        join services as s on c.service_code = s.service_code
        join serviceTypes as st on s.serviceType_code = st.serviceType_code
group by
		acs.aS_code
having
		number_of_using_service = 1;

/* 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, 
ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.*/

select 
		employee_code, 
        employee_name, 
        level_name, 
        department_name, 
        employee_phone, 
        employee_address
from
		employees as e1
		join levels using (level_code)
        join departments using (department_code)
where	
		exists
        (select 
				e.employee_code,
                count(c.contract_code) as totalContract
        from
				employees as e
				join contracts as c using (employee_code)
		where
				e1.employee_code = e.employee_code
				and contract_startDate between "2020-01-01" and "2021-12-31"
		group by
				e.employee_code
		having
				totalContract <= 3
        );

/* 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021. */

/* 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, 
chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 
là lớn hơn 10.000.000 VNĐ.*/

/* 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng). */

/* 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.*/

/* 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống,
 thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.*/





