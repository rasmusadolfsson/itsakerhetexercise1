create table app_user (
                          id bigint not null auto_increment,
                          password varchar(255) not null,
                          username varchar(255) not null unique,
                          primary key (id)
) engine=InnoDB;

create table app_user_seq (next_val bigint) engine=InnoDB;