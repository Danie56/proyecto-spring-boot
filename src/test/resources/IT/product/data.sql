
INSERT INTO categories (id, name) VALUES
  (1, 'CATEGORY 1'),
  (2, 'CATEGORY 2'),
  (3, 'CATEGORY 3');

INSERT INTO product_details (id, specifications, warranty, provider) VALUES
  (1, 'Intel i7...', '2-year warranty', 'TechStore');

INSERT INTO products (id, name, description, image, price, product_details_id) VALUES
(
  1,
  'product 1',
  'description 1',
  'img.jpg',
  29.99,
  1
);

INSERT INTO products_categories (product_id, category_id) VALUES
  (1, 1),
  (1, 3);
