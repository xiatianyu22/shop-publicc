DROP TABLE IF EXISTS SHOP_ORDER_ITEM;
 
CREATE TABLE SHOP_ORDER_ITEM (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  order_id INT NOT NULL,
  product_code VARCHAR(32) NOT NULL,
  product_name VARCHAR(250) NOT NULL,
  quality INT DEFAULT 0
);
 
INSERT INTO SHOP_ORDER_ITEM (order_id, product_code,  product_name, quality) VALUES
  (1, 'code 3',  'product 3', 1);