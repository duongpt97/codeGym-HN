USE QuanLyBanHang;
-- Hiển thị các thông tin gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select oID, oDate, oTotalPrice from `Order`;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
SELECT
c.cID ,
c.cName,
p.pName,
od.odQTY
FROM
Customer c
JOIN
`Order` o ON c.cID = o.cID
JOIN
OrderDetail od ON o.oID = od.oID
JOIN
Product p ON od.pID = p.pID;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
SELECT cName
FROM Customer c
LEFT JOIN `Order` o ON c.cId = o.cId
WHERE o.oId IS NULL;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
SELECT
o.oID 'Ma HD',
o.oDate 'Ngay Ban',
SUM(od.odQTY * p.pPrice) totalAmount
FROM
`Order` o
JOIN
OrderDetail od ON o.oID = od.oID
JOIN
Product p ON od.pID = p.pID
GROUP BY
o.oID,o.oDate;