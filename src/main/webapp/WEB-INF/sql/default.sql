drop database cake;

create database cake default character set utf8 collate utf8_general_ci;;

use cake;



create table user(
    u_pk int AUTO_INCREMENT primary key,
    u_id varchar(20) not null unique ,
    u_pw varchar(60) not null,
    u_type tinyint(1) -- 0은 일반회원, 1은 점주
);



create table store(
    s_pk int AUTO_INCREMENT primary key,
    s_name varchar(25) not null,
    s_loc varchar(50),
    s_time varchar(100),
    s_ctnt varchar(1000),

    u_pk int,
    foreign key(u_pk) references user(u_pk)
);

create table menu(
    m_pk int AUTO_INCREMENT primary key,
    m_ctnt varchar(100),
    s_pk int,
    foreign key(s_pk) references store(s_pk)
);

create table m_picture(
    m_pk int,
    mp_picture varchar(30) ,
    foreign key(m_pk) references menu(m_pk)
);

create table review(
    r_pk int AUTO_INCREMENT primary key,
    r_star int(1),
    r_ctnt varchar(100),

    m_pk int,
    foreign key(m_pk) references menu(m_pk)
);

create table r_picture(
    r_pk int,
    rm_picture varchar(30),
    foreign key(r_pk) references review(r_pk)
);

show tables;

select * from store;

