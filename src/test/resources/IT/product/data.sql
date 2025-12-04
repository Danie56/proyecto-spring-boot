
INSERT INTO categories (id, name) VALUES
  (1, 'CATEGORY 1'),
  (2, 'CATEGORY 2'),
  (3, 'CATEGORY 3');

INSERT INTO product_details (id, specifications, warranty, provider) VALUES
  (1, 'specification 1', 'warranty 1', 'provider 1');

INSERT INTO products (id, name, description, image, price, product_details_id) VALUES
(
  1,
  'product 1',
  'description 1',
  'image_1.jpg',
  29.99,
  1
);

INSERT INTO product_details (id, specifications, warranty, provider) VALUES
  (2, 'specification 2', 'warranty 2', 'provider 2');

INSERT INTO products (id, name, description, image, price, product_details_id) VALUES
(
  2,
  'product 2',
  'description 2',
  'image_2.jpg',
  29.99,
  2
);


INSERT INTO products_categories (product_id, category_id) VALUES
  (1, 1),
  (1, 3),
  (2,1);
