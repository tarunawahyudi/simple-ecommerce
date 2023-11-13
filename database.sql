CREATE DATABASE simple_ecommerce;

CREATE TABLE users
(
    id               SERIAL       NOT NULL PRIMARY KEY,
    username         VARCHAR(100) NOT NULL,
    password         VARCHAR(100) NOT NULL,
    name             VARCHAR(100) NOT NULL,
    token            VARCHAR(100),
    token_expired_at BIGINT,
    CONSTRAINT username_unique UNIQUE (username, token)
);

CREATE TABLE products
(
    id          SERIAL       NOT NULL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    description VARCHAR(200),
    price       INTEGER
);

CREATE TABLE wallets
(
    id      SERIAL      NOT NULL PRIMARY KEY,
    name    VARCHAR(50) NOT NULL,
    balance INT DEFAULT 0,
    user_id INT         NOT NULL,
    CONSTRAINT fk_wallets_user FOREIGN KEY (user_id) REFERENCES users (id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE orders
(
    id         SERIAL NOT NULL PRIMARY KEY,
    total      INT    NOT NULL DEFAULT 0,
    order_date TIMESTAMP       DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE order_detail
(
    id         SERIAL NOT NULL PRIMARY KEY,
    order_id   INT    NOT NULL,
    product_id INT    NOT NULL,
    user_id    INT    NOT NULL,
    qty        INT    NOT NULL,
    sub_total  INT    NOT NULL DEFAULT 0,
    CONSTRAINT fk_order_detail_order FOREIGN KEY (order_id) REFERENCES orders (id),
    CONSTRAINT fk_order_detail_product FOREIGN KEY (product_id) REFERENCES products (id),
    CONSTRAINT fk_order_detail_user FOREIGN KEY (user_id) REFERENCES users (id)
);

INSERT INTO products (name, description, price)
VALUES ('Laptop XYZ', 'Powerful laptop with high performance', 1500),
       ('Smartphone ABC', 'Latest model with advanced features', 800),
       ('Headphones 123', 'Wireless noise-canceling headphones', 200),
       ('Smartwatch QWERTY', 'Fitness tracker with heart rate monitor', 120),
       ('Camera Z', 'Professional-grade camera for photography', 1000),
       ('Gaming Console XYZ', 'Next-gen gaming console with 4K support', 500),
       ('Wireless Mouse', 'Ergonomic design for comfortable use', 30),
       ('Bluetooth Speaker', 'Portable speaker for on-the-go music', 50),
       ('Tablet ABC', 'Large screen tablet for productivity', 400),
       ('Fitness Tracker', 'Track your steps, calories, and workouts', 80),
       ('Coffee Maker', 'Automatic coffee maker with programmable timer', 100),
       ('Electric Toothbrush', 'Advanced toothbrush for effective cleaning', 50),
       ('Robot Vacuum', 'Smart vacuum cleaner with navigation', 300),
       ('External Hard Drive', 'High-capacity storage for your files', 120),
       ('Desk Chair', 'Comfortable chair for long hours of work', 150),
       ('LED TV', 'Ultra HD television with smart features', 700),
       ('Printed T-Shirt', 'Casual cotton t-shirt with a stylish print', 20),
       ('Wireless Keyboard', 'Compact keyboard for convenient typing', 40),
       ('Bluetooth Earbuds', 'Wireless earbuds with noise isolation', 80),
       ('Digital Watch', 'Water-resistant watch with digital display', 60),
       ('Sunglasses', 'Stylish UV protection sunglasses', 30),
       ('Backpack', 'Durable backpack for everyday use', 50),
       ('Hiking Boots', 'Waterproof boots for outdoor adventures', 120),
       ('Digital Camera', 'Compact camera with high-resolution sensor', 300),
       ('Smart Thermostat', 'Wi-Fi enabled thermostat for home automation', 80),
       ('Air Purifier', 'HEPA filter purifier for clean indoor air', 150),
       ('Electric Scooter', 'Foldable scooter for urban commuting', 250),
       ('Portable Charger', 'High-capacity power bank for charging on the go', 40),
       ('Yoga Mat', 'Non-slip yoga mat for fitness and meditation', 20),
       ('Travel Pillow', 'Memory foam neck pillow for comfortable travel', 15),
       ('Instant Pot', 'Multi-functional electric pressure cooker', 80),
       ('Wireless Charger', 'Qi-compatible charger for wireless charging', 30),
       ('Running Shoes', 'Lightweight and breathable shoes for running', 70),
       ('Office Desk', 'Sturdy desk for home or office use', 120),
       ('USB Flash Drive', 'Portable storage device for data transfer', 10),
       ('Hair Dryer', 'Ionic hair dryer for fast and efficient drying', 50),
       ('Smart Doorbell', 'Video doorbell with motion detection', 120),
       ('Compact Mirrorless Camera', 'Mirrorless camera for photography enthusiasts', 600),
       ('Gourmet Blender', 'High-performance blender for smoothies and more', 100),
       ('Water Bottle', 'Reusable and eco-friendly water bottle', 15),
       ('Camping Tent', 'Lightweight tent for outdoor camping', 80),
       ('Stainless Steel Cookware Set', 'Durable and stylish cookware set', 150),
       ('Sunscreen SPF 50', 'Broad-spectrum sunscreen for sun protection', 15),
       ('Noise-Canceling Headphones', 'Premium headphones for immersive audio', 250),
       ('Cordless Drill', 'Powerful drill for DIY projects', 70),
       ('Wireless Router', 'High-speed router for seamless internet connectivity', 80),
       ('Smart LED Bulbs', 'Energy-efficient smart bulbs with customizable colors', 20),
       ('Portable Bluetooth Printer', 'Compact printer for mobile printing', 100),
       ('Fitness Exercise Ball', 'Anti-burst exercise ball for core workouts', 20),
       ('Adjustable Dumbbell Set', 'Space-saving dumbbells for home workouts', 120);

SELECT *
FROM products;

SELECT *
FROM products
WHERE id = 17;

TRUNCATE products;

-- RESET SEQUENCE
ALTER SEQUENCE products_id_seq
    RESTART WITH 1;

SELECT *
FROM users;

SELECT * FROM wallets;

INSERT INTO users (username, password, name)
VALUES ('nilam', 'admin', 'Nilam Sakiyah Dewi');

DELETE FROM users where id = 25;

SELECT * FROM users where username = 'nilam';