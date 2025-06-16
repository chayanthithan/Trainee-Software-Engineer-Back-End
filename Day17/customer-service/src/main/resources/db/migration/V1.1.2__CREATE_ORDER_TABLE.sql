CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product VARCHAR(255) NOT NULL,
    amount DOUBLE NOT NULL,
    customer_id BIGINT NOT NULL,
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE CASCADE
);