CREATE VIEW customer_views AS
SELECT customerNumber, customerName, phone
FROM  customers;

select * from customer_views WHERE customerName = 'Signal Gift Stores';

CREATE OR REPLACE VIEW customer_views AS
SELECT customerNumber, customerName, contactFirstName, contactLastName, phone
FROM customers
WHERE city = 'Nantes';

UPDATE customer_views
SET phone =' 8576254174'
WHERE customerName = 'Signal Gift Stores';

DELETE FROM customer_views
WHERE  phone =' 8576254174';

DROP VIEW customer_views;