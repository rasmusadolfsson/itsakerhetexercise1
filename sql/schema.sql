create table user (id bigint not null, password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB;
create table user_seq (next_val bigint) engine=InnoDB;