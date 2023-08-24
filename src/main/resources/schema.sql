drop table if exists user;
drop table if exists user_seq;
create table user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

create table role
(
    role_id   bigint AUTO_INCREMENT PRIMARY KEY not null,
    authority varchar(255),
);

create table user_role (
    role_id bigint not null,
    user_id bigint not null,
    primary key (role_id, user_id))
