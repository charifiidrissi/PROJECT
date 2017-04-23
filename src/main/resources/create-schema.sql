create table users(
      username varchar_ignorecase(50) not null primary key,
      password varchar_ignorecase(250) not null ,
      email VARCHAR (250) not null,
      enabled boolean not null,
      );



CREATE TABLE POSTS(
        ID int primary key AUTO_INCREMENT,
        CONTENT varchar(148),
        username varchar_ignorecase(50) NOT NULL,
        constraint fk1_authorities_users foreign key(username) references users(username)
);

CREATE TABLE COMMENTS (
    ID int PRIMARY KEY AUTO_INCREMENT,
    CONTENT VARCHAR(148),
    username varchar_ignorecase(50) NOT NULL,
    ID_POST int not null,
    constraint fk2_authorities_users foreign key(username) references users(username)
);


CREATE TABLE LIKES (
    ID int PRIMARY KEY AUTO_INCREMENT,
    username varchar_ignorecase(50) NOT NULL,
    ID_POST int not NULL,
    constraint fk3_authorities_users foreign key(username) references users(username)
);

  create table authorities (
      username varchar_ignorecase(50) not null,
      authority varchar_ignorecase(50) not null,
      constraint fk4_authorities_users foreign key(username) references users(username)
      );
  create unique index ix_auth_username on authorities (username,authority);