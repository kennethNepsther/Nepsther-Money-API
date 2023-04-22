create table person (
                          id BIGINT  primary key AUTO_INCREMENT,
                          name varchar(50) not null,
                          active boolean not null,
                          street varchar(50) not null,
                          number varchar(50) not null,
                          neighborhood varchar(50) not null,
                          city varchar(50) not null,
                          Province varchar(50) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

