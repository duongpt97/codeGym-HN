SELECT 
    o.orderNumber,
    SUM(od.quantityOrdered * od.priceEach) totalAmount
FROM
    orders o JOIN orderdetails od ON o.orderNumber = od.orderNumber
GROUP BY o.orderNumber;


select year(orderDate) as nam, sum(od.priceEach * od.quantityOrdered) doanh_thu
from orders o
         join orderdetails od on o.orderNumber = od.orderNumber
where year(orderDate) > 2003
  and status = 'Resolved'
group by year(orderDate);

-- In ra danh sách đơn hàng có tổng tiền là lớn nhất 
select  a.orderNumber,a.totalAmount from (
SELECT 
    o.orderNumber,
    SUM(od.quantityOrdered * od.priceEach)  totalAmount
FROM
    orders o JOIN orderdetails od ON o.orderNumber = od.orderNumber
    GROUP BY o.orderNumber) a
    order by a.totalAmount desc
    LIMIT 5;

-- In ra danh sách đơn hàng có tổng tiền là nhỏ nhất
select  a.orderNumber,a.totalAmount from (
SELECT 
    o.orderNumber,
    SUM(od.quantityOrdered * od.priceEach)  totalAmount
FROM
    orders o JOIN orderdetails od ON o.orderNumber = od.orderNumber
    GROUP BY o.orderNumber) a
    order by a.totalAmount asc 
	LIMIT 5;

-- Hiển thị thông tin sản phẩm được mua nhiều nhất
select  productCode,productName,quantityProduct from (
SELECT p.productCode,p.productName,
    SUM(od.quantityOrdered)  quantityProduct
FROM
   products p  JOIN orderdetails od ON p.productCode = od.productCode
GROUP BY od.productCode) a
order by quantityProduct desc 
limit 1;


-- Tính doanh thu trung bình
select avg(a.doanh_thu) doanh_thu_trung_binh
from (select year(orderDate) as nam, sum(od.priceEach * od.quantityOrdered) doanh_thu
      from orders o
               join orderdetails od on o.orderNumber = od.orderNumber
          and status = 'Resolved'
      group by year(orderDate)) a;


