insert into category (name)
values
('Household'),
('Kitchen Utensils'),
('Office Supplies');

insert into product (name, quantity, category_id, created_at, updated_at)
values
('Lamp', 5, 1, now(), now()),
('Sofa', 10, 1, now(), now()),
('Knife', 12, 2, now(), now()),
('Cutting Board', 4, 2, now(), now()),
('Sticky Notes', 80, 3, now(), now());