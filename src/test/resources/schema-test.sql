-- schema.sql
DROP TABLE IF EXISTS products;

CREATE TABLE IF NOT EXISTS products (
    sku VARCHAR(10) PRIMARY KEY,
    price NUMERIC(1000,2),
    description VARCHAR(100),
    category VARCHAR(20)
);

INSERT INTO products VALUES('SKU0001', 19.99, 'Wireless Mouse with ergonomic design', 'Electronics');
INSERT INTO products VALUES('SKU0002', 499.00, '4K Ultra HD Smart TV, 55 inches', 'Electronics');
INSERT INTO products VALUES('SKU0003', 29.50, 'Stainless Steel Water Bottle, 1L', 'Home & Kitchen');
INSERT INTO products VALUES('SKU0004', 15.00, 'Cotton T-Shirt, Unisex, Size M', 'Clothing');
INSERT INTO products VALUES('SKU0005', 120.00, 'Noise-Cancelling Over-Ear Headphones', 'Electronics');
INSERT INTO products VALUES('SKU0015', 42.00, 'Running Shoes, Men''s Size 42', 'Footwear');
