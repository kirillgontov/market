DROP TABLE IF EXISTS products;
CREATE TABLE products (id BIGSERIAL PRIMARY KEY, title VARCHAR(255), price INT);
INSERT INTO products (title, price) VALUES
('beer', 50),
('cheeps', 70),
('fish', 100);