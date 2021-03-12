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