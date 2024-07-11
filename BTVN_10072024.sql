CREATE DATABASE demo;
USE demo;

CREATE TABLE products (
      id INT AUTO_INCREMENT PRIMARY KEY,
      productCode VARCHAR(50) NOT NULL,
      productName VARCHAR(255) ,
      productPrice BIGINT(20),
      productAmount BIGINT(20),
      productDescription VARCHAR(255) ,
      productStatus INT(10) 
);

ALTER TABLE products ADD INDEX idx_product_code(productCode);
ALTER TABLE products ADD INDEX idx_composite_products(productName, productPrice);

CREATE VIEW products_view AS
SELECT productCode, productName, productPrice,productStatus
FROM  products;
select * from products_view;
UPDATE products_view
SET productCode ='IPHONE'
WHERE productName = 'Dien thoai';

DROP VIEW products_view;



DELIMITER //

CREATE PROCEDURE findAllProduct()
BEGIN

  SELECT * FROM products;

END //

DELIMITER ;

call findAllProduct();


DELIMITER //

CREATE PROCEDURE insertProduct()
BEGIN

 
INSERT INTO products (productCode, productName, productPrice,productAmount,productDescription,productStatus)  

VALUES ('NEW_PROD','San pham moi',2350000,36630,'san pham moi',1);

END //

DELIMITER ;

call insertProduct();


DELIMITER //

CREATE PROCEDURE updateProduct( IN  p_id INT,
									p_prod_name varchar(255),
									p_prod_price BIGINT(20),
                                    p_prod_amount BIGINT(20),
                                    p_prod_description varchar(255))
BEGIN
	UPDATE products
	SET productName = p_prod_name,
		productPrice = p_prod_price,
		productAmount = p_prod_amount,
		productDescription = p_prod_description
	where id = p_id;
END //

DELIMITER ;

call updateProduct(2,'Hi',80000,6000,'hi');


-- xoa mem san pham

DELIMITER //

CREATE PROCEDURE deleteProduct( IN  p_id INT)
BEGIN
	UPDATE products
	SET productStatus = 0
	where id = p_id;
END //

DELIMITER ;

call deleteProduct(2);

-- xoa san pham khoi db

DELIMITER //

CREATE PROCEDURE deleteProductNew( IN  p_id INT)
BEGIN
	DELETE FROM products WHERE id = p_id;
END //

DELIMITER ;

call deleteProductNew(2);
select * from products;