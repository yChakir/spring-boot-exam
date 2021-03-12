delete
from users_roles;
delete
from orders;
delete
from mails;
delete
from articles;
delete
from roles;
delete
from users;

-- roles
INSERT INTO roles (name)
VALUES ('ADMIN'),
       ('CLIENT');

-- users
INSERT INTO users (city, email, full_name, password, tel, username)
VALUES ('Casablanca',
        'admin@cigma.ecommerce.org',
        'Admin Admin',
        '$2a$10$MxO8sGQ2eUzOG3iYYEZiROqrq.0JbyfWq6vHHgNcsY4g65IPcXWaS',
        '0607003030',
        'admin'),
       ('Tanger',
        'client@gmail.org',
        'Client Client',
        '$2a$10$Mwn1BCgv5MUlV5m/fjx7LO1QL7MxjAbLCKUSmfANieCVseCe5NATW',
        '0666189144',
        'client');

-- user roles
INSERT INTO users_roles (user_id, roles_id)
VALUES ((SELECT ID FROM users WHERE username = 'admin'), (SELECT ID FROM roles WHERE name = 'ADMIN')),
       ((SELECT ID FROM users WHERE username = 'client'), (SELECT ID FROM roles WHERE name = 'CLIENT'));

-- articles
insert into articles (description, title, quantity, price, reference)
values ('In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.

Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.',
        'Mushroom - Portebello',
        62,
        193.98,
        '661745028-0');
insert into articles (description, title, quantity, price, reference)
values ('Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.

Phasellus in felis. Donec semper sapien a libero. Nam dui.

Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.',
        'Fuji Apples',
        76,
        108.75,
        '429708755-3');
insert into articles (description, title, quantity, price, reference)
values ('Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.

Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.',
        'Galliano',
        56,
        247.59,
        '215434368-6');
insert into articles (description, title, quantity, price, reference)
values ('In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.

Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.',
        'Gatorade - Xfactor Berry',
        20,
        68.08,
        '034202761-1');
insert into articles (description, title, quantity, price, reference)
values ('In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.

Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.',
        'Quail - Whole, Bone - In',
        20,
        223.08,
        '160311471-8');
insert into articles (description, title, quantity, price, reference)
values ('Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.',
        'Water, Tap',
        79,
        83.41,
        '507369779-0');
insert into articles (description, title, quantity, price, reference)
values ('Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.

Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.

Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.',
        'Quinoa',
        51,
        249.15,
        '361587876-0');
insert into articles (description, title, quantity, price, reference)
values ('Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus.

In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.

Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.',
        'Wine - Red, Pelee Island Merlot',
        37,
        249.83,
        '371606855-1');
insert into articles (description, title, quantity, price, reference)
values ('Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.

Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.',
        'Squid - Tubes / Tenticles 10/20',
        83,
        58.62,
        '892510033-9');
insert into articles (description, title, quantity, price, reference)
values ('Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.

Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.',
        'Sauce - Soya, Light',
        15,
        63.7,
        '418651043-1');
insert into articles (description, title, quantity, price, reference)
values ('Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.

Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.

Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.',
        'Nut - Pecan, Pieces',
        75,
        79.17,
        '490249527-9');
insert into articles (description, title, quantity, price, reference)
values ('Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.

Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus.

In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.',
        'Cheese - Manchego, Spanish',
        35,
        125.27,
        '240449524-0');
insert into articles (description, title, quantity, price, reference)
values ('Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.',
        'Crab - Back Fin Meat, Canned',
        46,
        67.18,
        '124164741-0');
insert into articles (description, title, quantity, price, reference)
values ('Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.

Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.',
        'Lid Tray - 16in Dome',
        68,
        268.92,
        '231068558-5');
insert into articles (description, title, quantity, price, reference)
values ('Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.

Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.', 'Taro Root', 70, 71.61, '674975890-8');
insert into articles (description, title, quantity, price, reference)
values ('Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.

Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.',
        'Plasticspoonblack',
        15,
        94.94,
        '458555252-9');
insert into articles (description, title, quantity, price, reference)
values ('Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.

Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.

Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.',
        'Salmon Atl.whole 8 - 10 Lb',
        99,
        237.81,
        '154976122-6');
insert into articles (description, title, quantity, price, reference)
values ('Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.

Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.',
        'Carrots - Jumbo',
        17,
        240.14,
        '712878584-1');
insert into articles (description, title, quantity, price, reference)
values ('Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.

Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.

Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.',
        'Godiva White Chocolate',
        52,
        198.56,
        '559113960-4');
insert into articles (description, title, quantity, price, reference)
values ('In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.

Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.

Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.',
        'Straws - Cocktale',
        73,
        294.45,
        '853467476-0');
insert into articles (description, title, quantity, price, reference)
values ('Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.

Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.',
        'Soup - Knorr, Chicken Gumbo',
        95,
        64.11,
        '948945222-X');
insert into articles (description, title, quantity, price, reference)
values ('Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.',
        'Energy Drink Bawls',
        94,
        71.61,
        '313685909-X');
insert into articles (description, title, quantity, price, reference)
values ('Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.',
        'Tea - Apple Green Tea',
        97,
        125.88,
        '853096553-1');
insert into articles (description, title, quantity, price, reference)
values ('Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.',
        'Cherries - Frozen',
        40,
        203.04,
        '341246032-X');
insert into articles (description, title, quantity, price, reference)
values ('In congue. Etiam justo. Etiam pretium iaculis justo.', 'Quiche Assorted', 49, 189.35, '160087578-5');
insert into articles (description, title, quantity, price, reference)
values ('Fusce consequat. Nulla nisl. Nunc nisl.

Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.',
        'Ginsing - Fresh',
        86,
        54.99,
        '203796099-9');
insert into articles (description, title, quantity, price, reference)
values ('Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.

Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.

Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.',
        'Burger Veggie',
        75,
        124.42,
        '816663143-1');
insert into articles (description, title, quantity, price, reference)
values ('In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.

Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.',
        'Cookies - Englishbay Oatmeal',
        66,
        190.01,
        '229586078-4');
insert into articles (description, title, quantity, price, reference)
values ('Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.

Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.

Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.',
        'Bread - Rolls, Corn',
        39,
        127.16,
        '057294339-3');
insert into articles (description, title, quantity, price, reference)
values ('Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.',
        'Yoplait - Strawbrasp Peac',
        39,
        184.78,
        '554084461-0');
insert into articles (description, title, quantity, price, reference)
values ('Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.

Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.',
        'Kellogs Raisan Bran Bars',
        56,
        245.78,
        '396215447-7');
insert into articles (description, title, quantity, price, reference)
values ('Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus. Praesent lectus.',
        'Mousse - Mango',
        84,
        237.3,
        '325839477-6');
insert into articles (description, title, quantity, price, reference)
values ('Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.

In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.',
        'Beer - Camerons Cream Ale',
        56,
        55.48,
        '355416889-0');
insert into articles (description, title, quantity, price, reference)
values ('Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus. Praesent lectus.

Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.',
        'Iced Tea - Lemon, 460 Ml',
        30,
        141.95,
        '259713218-8');
insert into articles (description, title, quantity, price, reference)
values ('Fusce consequat. Nulla nisl. Nunc nisl.

Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.

In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.',
        'Baking Soda',
        36,
        91.47,
        '995275161-3');
insert into articles (description, title, quantity, price, reference)
values ('Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.',
        'Wine - Savigny - Les - Beaune',
        16,
        76.64,
        '328126387-9');
insert into articles (description, title, quantity, price, reference)
values ('Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.',
        'Russian Prince',
        25,
        195.74,
        '060411642-X');
insert into articles (description, title, quantity, price, reference)
values ('Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.

Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.',
        'Ham - Cooked Italian',
        77,
        209.52,
        '807067734-1');
insert into articles (description, title, quantity, price, reference)
values ('Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.',
        'Wine - Bouchard La Vignee Pinot',
        80,
        195.54,
        '963669516-4');
insert into articles (description, title, quantity, price, reference)
values ('Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.',
        'Sauce - Oyster',
        93,
        73.24,
        '892021493-X');
insert into articles (description, title, quantity, price, reference)
values ('Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.

Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.

Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.',
        'Pork - Back, Long Cut, Boneless',
        96,
        230.78,
        '938929504-1');
insert into articles (description, title, quantity, price, reference)
values ('Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus. Praesent lectus.',
        'Salmon - Sockeye Raw',
        68,
        208.63,
        '858655564-9');
insert into articles (description, title, quantity, price, reference)
values ('Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.

Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus.', 'Squid U5 - Thailand', 21, 150.84, '895053087-2');
insert into articles (description, title, quantity, price, reference)
values ('Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.

Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.

Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.',
        'Pepper - Red, Finger Hot',
        84,
        193.96,
        '529176898-3');
insert into articles (description, title, quantity, price, reference)
values ('Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.

In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.

Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.',
        'Beans - Turtle, Black, Dry',
        82,
        88.29,
        '056633619-7');
insert into articles (description, title, quantity, price, reference)
values ('Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.',
        'Wine - Peller Estates Late',
        21,
        237.35,
        '346205244-6');
insert into articles (description, title, quantity, price, reference)
values ('Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.

Phasellus in felis. Donec semper sapien a libero. Nam dui.', 'Bread Fig And Almond', 88, 155.0, '805252715-5');
insert into articles (description, title, quantity, price, reference)
values ('Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.

In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.',
        'Lettuce - Radicchio',
        78,
        147.91,
        '961719147-4');
insert into articles (description, title, quantity, price, reference)
values ('Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.

Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.',
        'Wakami Seaweed',
        51,
        106.26,
        '659733438-8');
insert into articles (description, title, quantity, price, reference)
values ('Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.',
        'Island Oasis - Magarita Mix',
        83,
        175.52,
        '521413954-3');
insert into articles (description, title, quantity, price, reference)
values ('In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.

Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.

Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.',
        'Cheese - Brick With Onion',
        46,
        164.35,
        '702740219-X');
insert into articles (description, title, quantity, price, reference)
values ('Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.

Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.',
        'Wine - Savigny - Les - Beaune',
        71,
        117.18,
        '352762371-X');
insert into articles (description, title, quantity, price, reference)
values ('Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.

Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.',
        'Cocktail Napkin Blue',
        87,
        221.72,
        '601194840-5');
insert into articles (description, title, quantity, price, reference)
values ('Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.

Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.

Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.',
        'Lemonade - Island Tea, 591 Ml',
        44,
        271.05,
        '049470013-0');
insert into articles (description, title, quantity, price, reference)
values ('Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus. Praesent lectus.

Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.

Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.',
        'Stock - Beef, White',
        73,
        195.89,
        '674510581-0');
insert into articles (description, title, quantity, price, reference)
values ('Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.

Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.

Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.',
        'Squid - U 5',
        80,
        140.68,
        '061904256-7');
insert into articles (description, title, quantity, price, reference)
values ('Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus.', 'Napkin White', 31, 52.49, '842289331-2');
insert into articles (description, title, quantity, price, reference)
values ('Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.

Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.

Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.',
        'Potatoes - Mini White 3 Oz',
        15,
        143.43,
        '236220423-5');
insert into articles (description, title, quantity, price, reference)
values ('Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.

Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.

Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.',
        'Sauce - Salsa',
        26,
        115.6,
        '407872420-5');
insert into articles (description, title, quantity, price, reference)
values ('Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.',
        'Capon - Whole',
        29,
        186.56,
        '137089650-6');
insert into articles (description, title, quantity, price, reference)
values ('Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.',
        'Tart - Lemon',
        66,
        143.36,
        '559262434-4');
insert into articles (description, title, quantity, price, reference)
values ('Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.',
        'Stock - Beef, White',
        47,
        243.06,
        '482858406-4');
insert into articles (description, title, quantity, price, reference)
values ('Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.

Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.',
        'Ecolab - Hobart Washarm End Cap',
        68,
        213.42,
        '996632657-X');
insert into articles (description, title, quantity, price, reference)
values ('Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.',
        'Yogurt - Cherry, 175 Gr',
        94,
        65.69,
        '339036585-0');
insert into articles (description, title, quantity, price, reference)
values ('Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.

Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.

Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.',
        'Cheese - Brick With Onion',
        23,
        213.34,
        '045602775-0');
insert into articles (description, title, quantity, price, reference)
values ('In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.',
        'Water - Mineral, Carbonated',
        89,
        246.64,
        '057684951-0');
insert into articles (description, title, quantity, price, reference)
values ('Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.',
        'Crab - Dungeness, Whole',
        57,
        83.3,
        '567566953-1');
insert into articles (description, title, quantity, price, reference)
values ('Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.

Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.',
        'Cheese - Bocconcini',
        32,
        238.84,
        '414537798-2');
insert into articles (description, title, quantity, price, reference)
values ('Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.

Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.',
        'Spoon - Soup, Plastic',
        28,
        109.49,
        '712297337-9');
insert into articles (description, title, quantity, price, reference)
values ('Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.',
        'Tea - English Breakfast',
        50,
        132.14,
        '779966794-X');
insert into articles (description, title, quantity, price, reference)
values ('Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.',
        'Cranberries - Fresh',
        77,
        153.55,
        '685445484-0');
insert into articles (description, title, quantity, price, reference)
values ('Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.',
        'Cheese - Marble',
        99,
        283.71,
        '636173798-5');
insert into articles (description, title, quantity, price, reference)
values ('In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.

Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.',
        'Chicken Thigh - Bone Out',
        46,
        180.12,
        '632320177-1');
insert into articles (description, title, quantity, price, reference)
values ('Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.

Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.',
        'Table Cloth 62x114 Colour',
        41,
        281.9,
        '411101518-2');
insert into articles (description, title, quantity, price, reference)
values ('Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.',
        'Walkers Special Old Whiskey',
        78,
        180.61,
        '398597209-5');
insert into articles (description, title, quantity, price, reference)
values ('In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.

Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.',
        'Table Cloth 54x72 White',
        17,
        111.95,
        '767165322-5');
insert into articles (description, title, quantity, price, reference)
values ('Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.',
        'Muffin Hinge - 211n',
        51,
        172.31,
        '283923543-9');
insert into articles (description, title, quantity, price, reference)
values ('Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.',
        'Juice - Orangina',
        93,
        265.12,
        '228795876-2');
insert into articles (description, title, quantity, price, reference)
values ('Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.',
        'Soupcontfoam16oz 116con',
        37,
        121.6,
        '488035266-7');
insert into articles (description, title, quantity, price, reference)
values ('Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.

Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.',
        'Beer - Labatt Blue',
        49,
        289.39,
        '357665461-5');
insert into articles (description, title, quantity, price, reference)
values ('In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.

Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.',
        'Shrimp, Dried, Small / Lb',
        31,
        83.11,
        '220630523-2');
insert into articles (description, title, quantity, price, reference)
values ('Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.

Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.

Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.',
        'Cocktail Napkin Blue',
        77,
        162.81,
        '305973298-1');
insert into articles (description, title, quantity, price, reference)
values ('Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.',
        'Filling - Mince Meat',
        28,
        247.15,
        '077015413-1');
insert into articles (description, title, quantity, price, reference)
values ('In congue. Etiam justo. Etiam pretium iaculis justo.

In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.', 'Parsley - Fresh', 57, 60.11, '844331437-0');
insert into articles (description, title, quantity, price, reference)
values ('Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.

Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.',
        'Pepper - Black, Ground',
        50,
        120.35,
        '050401217-7');
insert into articles (description, title, quantity, price, reference)
values ('Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.

Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.

Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.',
        'Wine - Beaujolais Villages',
        57,
        129.73,
        '352217958-7');
insert into articles (description, title, quantity, price, reference)
values ('Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.

Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.

Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.',
        'Sauce - Black Current, Dry Mix',
        83,
        108.88,
        '768060271-9');
insert into articles (description, title, quantity, price, reference)
values ('Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.',
        'Chocolate Eclairs',
        46,
        69.87,
        '486875957-4');
insert into articles (description, title, quantity, price, reference)
values ('Phasellus in felis. Donec semper sapien a libero. Nam dui.

Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.',
        'Anchovy Paste - 56 G Tube',
        89,
        203.84,
        '316795122-2');
insert into articles (description, title, quantity, price, reference)
values ('Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.',
        'Hickory Smoke, Liquid',
        75,
        82.24,
        '475404786-9');
insert into articles (description, title, quantity, price, reference)
values ('Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.', 'Parsnip', 81, 169.21, '469759034-1');
insert into articles (description, title, quantity, price, reference)
values ('Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.

Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.',
        'Venison - Denver Leg Boneless',
        44,
        172.68,
        '211127665-0');
insert into articles (description, title, quantity, price, reference)
values ('Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.

Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.

Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.',
        'Bread - Roll, Canadian Dinner',
        12,
        139.51,
        '702366903-5');
insert into articles (description, title, quantity, price, reference)
values ('Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.

Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.

Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.',
        'Toamtoes 6x7 Select',
        68,
        105.82,
        '064872928-1');
insert into articles (description, title, quantity, price, reference)
values ('Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.

Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.',
        'Pasta - Angel Hair',
        20,
        55.75,
        '004646282-1');
insert into articles (description, title, quantity, price, reference)
values ('Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.

Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.

Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.',
        'Dasheen',
        17,
        130.64,
        '098384395-3');
insert into articles (description, title, quantity, price, reference)
values ('Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.',
        'Squid - Breaded',
        69,
        168.32,
        '562716391-7');
insert into articles (description, title, quantity, price, reference)
values ('Sed ante. Vivamus tortor. Duis mattis egestas metus.

Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.',
        'Cookie Dough - Chocolate Chip',
        81,
        150.47,
        '772355299-8');
insert into articles (description, title, quantity, price, reference)
values ('Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.

Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.

Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.',
        'Lamb - Loin, Trimmed, Boneless',
        63,
        71.77,
        '981240026-5');
insert into articles (description, title, quantity, price, reference)
values ('Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.

Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.

Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.',
        'Beef - Striploin Aa',
        19,
        169.23,
        '506975247-2');