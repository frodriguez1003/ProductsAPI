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
INSERT INTO products VALUES('SKU0006', 9.99, 'USB-C to USB Adapter', 'Electronics');
INSERT INTO products VALUES('SKU0007', 75.00, 'Leather Wallet with RFID Protection', 'Accessories');
INSERT INTO products VALUES('SKU0008', 35.00, 'Yoga Mat with Non-Slip Surface', 'Sports');
INSERT INTO products VALUES('SKU0009', 220.00, 'Smartwatch with Heart Rate Monitor', 'Electronics');
INSERT INTO products VALUES('SKU0010', 12.50, 'Ceramic Coffee Mug, 350ml', 'Home & Kitchen');
INSERT INTO products VALUES('SKU0011', 60.00, 'Bluetooth Portable Speaker', 'Electronics');
INSERT INTO products VALUES('SKU0012', 85.00, 'Backpack with Laptop Compartment', 'Accessories');
INSERT INTO products VALUES('SKU0013', 18.00, 'Stainless Steel Cutlery Set, 24 Pieces', 'Home & Kitchen');
INSERT INTO products VALUES('SKU0014', 250.00, 'Electric Guitar Starter Pack', 'Musical Instr.');
INSERT INTO products VALUES('SKU0015', 42.00, 'Running Shoes, Men''s Size 42', 'Footwear');
INSERT INTO products VALUES('SKU0016', 27.99, 'Digital Bathroom Scale with Body Fat Analyzer', 'Home Appliances');
INSERT INTO products VALUES('SKU0017', 14.99, 'Set of 6 Organic Cotton Socks', 'Clothing');
INSERT INTO products VALUES('SKU0018', 300.00, 'DSLR Camera with 18-55mm Lens', 'Electronics');
INSERT INTO products VALUES('SKU0019', 8.99, 'Hardcover Notebook, A5, 200 Pages', 'Stationery');
INSERT INTO products VALUES('SKU0020', 65.00, 'Microwave Oven, 20L Capacity', 'Home Appliances');
INSERT INTO products VALUES('SKU0021', 23.50, 'LED Desk Lamp with Adjustable Brightness', 'Home & Kitchen');
INSERT INTO products VALUES('SKU0022', 19.00, 'Wireless Charger Pad for Smartphones', 'Electronics');
INSERT INTO products VALUES('SKU0023', 55.00, 'Men''s Quartz Analog Watch with Leather Strap', 'Accessories');
INSERT INTO products VALUES('SKU0024', 30.00, 'Wooden Chess Set with Folding Board', 'Toys & Games');
INSERT INTO products VALUES('SKU0025', 99.00, 'Home Security Camera with Night Vision', 'Electronics');
INSERT INTO products VALUES('SKU0026', 16.50, 'Aromatherapy Essential Oil Diffuser', 'Home & Kitchen');
INSERT INTO products VALUES('SKU0027', 40.00, 'Professional Blender with 2L Jar', 'Home Appliances');
INSERT INTO products VALUES('SKU0028', 22.00, 'Kids'' Educational Tablet Toy', 'Toys & Games');
INSERT INTO products VALUES('SKU0029', 110.00, 'Mechanical Gaming Keyboard with RGB
Lighting', 'Electronics');
INSERT INTO products VALUES('SKU0030', 7.50, 'Pack of 10 Ballpoint Pens, Blue Ink', 'Stationery');
