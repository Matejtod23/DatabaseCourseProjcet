create schema GameShop

create table category (
	Category_Id serial primary key,
	Name varchar(100) not null
);

insert into category(name)
values
	('Action'),
	('RPG'),
	('Sports');



create table publisher(
	Publisher_Id serial primary key,
	Name varchar(100) not null,
	Country varchar(100) not null
);

insert into publisher(name, country)
values
	('GalacticGames', 'USA'),
	('CyberNexus Studios', 'South Korea'),
	('AtlasInteractive Entertainment', 'Canada');

insert into publisher(name, country)
values
	('Ubisoft', 'France'),
	('Activision', 'USA'),
	('Nintendo', 'Japan'),
	('CD Projekt', 'Poland');

insert into publisher(name, country)
values
	('Electronic Arts', 'USA');

create table customer(
	customer_id serial primary key,
	name varchar(100) not null,
	email varchar(50) not null,
	payment_info timestamp
);

alter table customer 
drop column payment_info;

insert into customer(name, email)
values
	('Emily Johnson', 'emily.johnson@example.com'),
	('Alex Rodriguez', 'alex.rodriguez@example.com'),
	('Jasmine Smith', 'jasmine.smith@example.com');

insert into customer (name, email)
values
	('Emily Davis', 'emily.davis@example.com'),
	('Alex Turner', 'alex.turner@example.com'),
	('Sarah Rodriguez', 'sarah.rodriguez@example.com'),
	('Michael Chang', 'michael.chang@xample.com'),
	('Olivia White', 'olivia.white@example.com');


create table game (
	game_Id serial primary key,
	title varchar(100) not null,
	price integer not null,
	platform varchar(10) not null,
	release_date date not null,
	publisher_id integer not null references publisher(publisher_id)
);	

insert into game(title, price, platform, release_date, publisher_id)
values
	('Galactic Conquest', 59, 'PS5', '2022-10-5', 1),
	('Cyber Nexus: Reloaded', 45, 'PC', '2021-5-20', 2),
	('GTA V', 79, 'PS5', '2020-10-4', 1);

insert into game(title, price, platform, release_date, publisher_id)
values
	('Space Odyssey', 49, 'PC', '2023-03-15', 5),
	('Epic Quest', 59, 'PS5', '2020-02-28', 3),
	('Galactic Conquest', 39, 'Xbox X', '2008-04-10', 6),
	('Mystic Legends', 44, 'Switch', '2023-05-05', 6),
	('Apex Legends: Galactic Warfare', 68, 'PS5', '2021-07-08', 8),
	('The Witcher 4: Dark Prophecy', 59, 'PC', '2005-08-15', 7),
	('Call of Duty: Black Ops V', 79, 'Xbox X', '2010-09-05', 5),
	('Legend of Zelda: Chronicles of Hyrule', 49, 'Switch', '2022-10-20', 6),
	('Assassins Creed: Unity Reborn', 69, 'PS5', '2021-11-12', 4);

create table review(
	review_id serial primary key,
	rating float,
	text varchar(200),
	date_posted date not null,
	game_id integer not null references game(game_id),
	customer_id integer not null references customer(customer_id)
);

insert into review(rating, date_posted, game_id, customer_id)
values
	('7.5', '2023-11-9', 1, 1);

insert into review(rating, date_posted, game_id, customer_id)
values
	('7.0', '2023-11-9', 1, 5),
	('6.2', '2023-2-3', 5, 1),
	('10.0', '2023-6-9', 3, 2),
	('9.0', '2023-10-4', 1, 3),
	('9.0', '2023-3-9', 5, 3),
	('8.0', '2018-3-20', 5, 6),
	('6.0', '2023-2-13', 3, 1),
	('8.2', '2022-4-20', 2, 5),
	('7.5', '2023-5-10', 2, 3);
	
create table "order"(
	order_id serial primary key,
	order_date date not null,
	total_amount integer not null,
	payment_status boolean not null,
	customer_id integer not null references customer(customer_id)
);

insert into "order"(order_date, total_amount, payment_status, customer_id)
values
	('2023-11-12', 45, true, 1);

insert into "order"(order_date, total_amount, payment_status, customer_id)
values
	('2023-12-4', 206, true, 3),
	('2023-11-10', 79, true, 2),
	('2023-12-8', 108, true, 3),
	('2023-12-4', 69, true, 5),
	('2023-12-6', 69, false, 2),
	('2023-11-2', 83, true, 4),
	('2023-10-4', 69, true, 1);
	
create table payment(
	payment_id serial,
	order_id integer not null references "order"(order_id),
	constraint pk_payment primary key(payment_id, order_id),
	amount integer not null,
	payment_method varchar(100) not null
);

insert into payment (order_id, amount, payment_method)
values
	(1, 45, 'Credit card');

insert into payment (order_id, amount, payment_method)
values
	(2, 206, 'Credit card'),
	(3, 79, 'Credit card'),
	(4, 108, 'Credit card'),
	(5, 69, 'Credit card'),
	(7, 83, 'Credit card'),
	(8, 69, 'Credit card');

create table game_is_of_category(
	category_id integer not null references category(category_id),
	game_id integer not null references game(game_Id),
	constraint pk_game_is_of_category primary key (category_id, game_id)
);
insert into game_is_of_category (category_id, game_id)
values
	(1, 1),
	(3, 2),
	(1, 3);
insert into game_is_of_category (category_id, game_id)
values
	(1, 4),
	(2, 5),
	(1, 6),
	(1, 7),
	(2, 8),
	(1, 9),
	(2, 10),
	(3, 11),
	(3, 12);

create table game_is_part_of_order(
	game_id integer not null references game(game_Id),
	order_id integer not null references "order"(order_id),
	constraint pk_game_is_part_of_order primary key (game_id, order_id)
);
insert into game_is_part_of_order (game_id, order_id)
values
	(2, 1);

insert into game_is_part_of_order (game_id, order_id)
values
	(8,2),
	(9,2),
	(10,2),
	(10,3),
	(11,4),
	(12,4),
	(12,5),
	(12,6),
	(6,7),
	(7,7),
	(12,8);

--view za informacii za igra i publisher detali
create view game_publisher_info as 
select
	g.title,
	g.platform,
	g.release_date,
	g.price,
	p."name" as publisher_name,
	p.country as publisher_country
from game g
join publisher p on g.publisher_id = p.publisher_id; 

--view za sumarizacija na poracki i igrite da se pokazat koi se del od narackata
create view customer_order_summary as
select
	c."name" as customer_name,
	c.email,
	o.order_date,
	o.total_amount,
	o.payment_status,
	gpo.order_id,
	g.title
from
	customer c
join "order" o on c.customer_id = o.customer_id
join game_is_part_of_order gpo on gpo.order_id = o.order_id
join game g ON gpo.game_id = g.game_id;

--view za game reviews posebno za sekoj game
create view game_reviews_summary as
select
	g.game_id,
	g.title,
	r.rating,
	r."text",
	r.date_posted
from
	game g 
right join review r on g.game_id = r.game_id


-- da se prikaze title i ime na platformata na site igri koi se soodvetni za platformata PC
select game.title, game.platform from game_is_of_category gioc
join game on game.game_id = gioc.game_id
join category on category.category_id = gioc.category_id
where game.platform = 'PC'

--da se prikazat site akcioni igri koi se izlezeni posle 2010 godina
select 
	g.title,
	g.platform,
	g.price,
	c."name" as "category name"
from game g
join game_is_of_category gioc on g.game_id = gioc.game_id
join category c on gioc.category_id = c.category_id 
where extract(year from g.release_date) >= 2010
and gioc.category_id = 1

--da se prikazat site korisnici koi napravile naracka i avh games per order
select 
	c.customer_id,
	c."name",
	c.email,
	count(*) as num_orders
from customer c 
join "order" o on c.customer_id = o.customer_id 
group by c.customer_id, c."name",c.email;

--prosecen rating za sekoj game posebno i totalen broj rating
select
	g.game_id,
	g.title,
	count(r.review_id) as num_reviews,
	case 
		when avg(r.rating) is null
		then 0
		else avg(r.rating) 
	end
	as average_rating
from
	game g 
left join review r on g.game_id = r.game_id
group by 
	g.game_id , g.title;

--
SELECT
    c.customer_id,
    c."name",
    case 
		when avg(r.rating) is null
		then 0
		else avg(r.rating) 
	end AS average_rating,
    COUNT(DISTINCT o.order_id) AS total_orders,
    SUM(p.amount) AS total_amount_paid
FROM
    customer c
LEFT JOIN
    review r ON c.customer_id = r.customer_id
LEFT JOIN
    "order" o ON c.customer_id = o.customer_id
LEFT JOIN
    payment p ON o.order_id = p.order_id
GROUP BY
    c.customer_id, c."name"
ORDER BY
    average_rating DESC;


select * from customer_order_summary cos2 
