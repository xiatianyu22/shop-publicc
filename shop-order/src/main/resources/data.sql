DROP TABLE IF EXISTS SHOP_ORDER;
 
CREATE TABLE SHOP_ORDER (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  customer_name VARCHAR(250) NOT NULL,
  order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  shipping_address_id VARCHAR(250) DEFAULT NULL,
  desc_id INT
);

CREATE TABLE SHOP_ORDER_DESC (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  desc VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO SHOP_ORDER (customer_name,  shipping_address) VALUES
  ('Zhang 1',  'Address 1', 1),
  ('Zhang 2', 'Address 2', 2),
  ('Zhang 3',  'Address 3', 3);
  
INSERT INTO SHOP_ORDER_DESC(desc) VALUES
	('desc 1'),
	('desc 2'),
	('desc 3');