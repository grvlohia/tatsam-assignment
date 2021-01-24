create database prioritydb;

use prioritydb;

create table priority(
	id int PRIMARY KEY AUTO_INCREMENT,
    category varchar(255) not null
);

create table user(
	id int PRIMARY KEY AUTO_INCREMENT,
    username varchar(255) not null,
    phone varchar(20),
    email varchar(255)
);

create table user_priority(
	user_id int,
    priority_id int,
    satisfaction tinyint not null,
    priority int not null,
    CONSTRAINT CHK_satisfaction CHECK (satisfaction >= 0 AND satisfaction <= 5),
    foreign key (user_id) references user(id),
    foreign key (priority_id) references priority(id),
    primary key (user_id, priority_id)
);

-- Seeding the Priority table with categories

insert into priority(category)
values
("connection"),
("relationships"),
("career"),
("wealth");

-- Seeding the User table with test user

insert into user(username, phone, email)
value ("testuser", "1234567890", "test@test.com");
