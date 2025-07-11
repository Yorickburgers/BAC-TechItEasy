insert into televisions (ambi_light,available_size,bluetooth,brand,hdr,original_stock,price,refresh_rate,screen_quality,screen_type,smarttv,sold,type,voice_control,wifi)
values (false, 52, true, 'LG', true, 12, 123, 50, 'HD', 'LED', false, 0, 'maxi', false, false),
       (true, 72, true, 'Samsung', true, 18, 324, 90, 'Super HD', 'O-LED', true, 12, 'turbo', true, true),
       (false, 12, false, 'Panasonic', false, 24, 59, 30, 'Black & White', 'CRT', false, 2, 'classic', false, false);

insert into remote_controllers (battery_type,brand,compatible_with,name,original_stock,price)
values ('AA', 'Samsung', 'Samsung', 'Samsung Power Remote', 18, 12),
       ('AAA', 'Panasonic', 'Panasonic', 'Panasonic Classic Remote', 24, 8),
       ('AA', 'LG', 'LG', 'LG All-Purpose Remote', 24, 16);

insert into ci_modules (name, price, type)
values ('Yamaha Module', 49, 'Prime'),
       ('Sega Hyper Module', 59, 'Epic Edition');

insert into users (username, password, email, apikey, enabled)
values ('Henk', '$2a$04$BJQHNV/ILx0i0bE2lYydfuROnMSy9lA5ciZklAewYKL31qNsoV4g2', 'Henk@Henk.nl', null, true),
       ('Ingrid', '$2a$04$IUsYVTbpY84KjDw3.eZLG.wYN3MuR8WSFmiZKTlixdheTMiYP5RQ2', 'Ingrid@Henk.nl', null, true);

insert into authorities (username, authority)
values ('Henk', 'ROLE_ADMIN'),
       ('Ingrid', 'ROLE_USER');