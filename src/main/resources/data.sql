/**
 * CREATE Script for init of DB
 */

-- Create 3 OFFLINE drivers

insert into driver (id, date_created, deleted, online_status, password, username) values (1, now(), false, 'OFFLINE',
'driver01pw', 'driver01');

insert into driver (id, date_created, deleted, online_status, password, username) values (2, now(), false, 'OFFLINE',
'driver02pw', 'driver02');

insert into driver (id, date_created, deleted, online_status, password, username) values (3, now(), false, 'OFFLINE',
'driver03pw', 'driver03');


-- Create 3 ONLINE drivers

insert into driver (id, date_created, deleted, online_status, password, username) values (4, now(), false, 'ONLINE',
'driver04pw', 'driver04');

insert into driver (id, date_created, deleted, online_status, password, username) values (5, now(), false, 'ONLINE',
'driver05pw', 'driver05');

insert into driver (id, date_created, deleted, online_status, password, username) values (6, now(), false, 'ONLINE',
'driver06pw', 'driver06');

-- Create 1 OFFLINE driver with coordinate(longitude=9.5&latitude=55.954)

insert into driver (id, coordinate, date_coordinate_updated, date_created, deleted, online_status, password, username)
values
 (7,
 'aced0005737200226f72672e737072696e676672616d65776f726b2e646174612e67656f2e506f696e7431b9e90ef11a4006020002440001784400017978704023000000000000404bfa1cac083127', now(), now(), false, 'OFFLINE',
'driver07pw', 'driver07');

-- Create 1 ONLINE driver with coordinate(longitude=9.5&latitude=55.954)

insert into driver (id, coordinate, date_coordinate_updated, date_created, deleted, online_status, password, username)
values
 (8,
 'aced0005737200226f72672e737072696e676672616d65776f726b2e646174612e67656f2e506f696e7431b9e90ef11a4006020002440001784400017978704023000000000000404bfa1cac083127', now(), now(), false, 'ONLINE',
'driver08pw', 'driver08');

-- Create Manufacturer

insert into manufacturer(id,address,date_created,name) values(1,'Toyota India, Chennai',now(),'Toyata');
insert into manufacturer(id,address,date_created,name) values(2,'Benz India, Delhi',now(),'Benz');
insert into manufacturer(id,address,date_created,name) values(3,'Honda, Banglore',now(),'Honda');
insert into manufacturer(id,address,date_created,name) values(4,'Hundai, Little Mount, Chennai, ',now(),'Hundai');
insert into manufacturer(id,address,date_created,name) values(5,'Suzuki, 1111 St Thomas MT, Mumbai',now(),'Suzuki');

-- Create Car
insert into car (color, convertible, date_created, engine_type, license_plate, manufacturer_id, name, online_status, rating, seat_count, id,associated)  values ('white', 'false', now(), '', 'TN-43-2130', 1, 'Etios VX', 'ONLINE', 4, 4, 1,false);
insert into car (color, convertible, date_created, engine_type, license_plate, manufacturer_id, name, online_status, rating, seat_count, id, associated)  values ('red', 'false', now(), '', 'TN-43-3152', 2, 'Mercedes-Benz S-Class', 'ONLINE', 4, 4, 2,false);
