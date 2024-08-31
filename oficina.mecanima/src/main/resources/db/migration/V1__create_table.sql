create table barbeiros (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    especialidade varchar(100) not null,
    cidade varchar(100) not null,
    localizacao varchar(100) not null,

    primary key(id)
)