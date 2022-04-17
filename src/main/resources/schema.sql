CREATE TABLE customers
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR
);

CREATE TABLE orders
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    order_date  DATE,
    customer_id BIGINT REFERENCES customers (id)
);
