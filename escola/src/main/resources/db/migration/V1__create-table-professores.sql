create table professores(
    id bigint not null auto_increment,
    nome varchar(40) not null,
    especialidade varchar(100) not null,

    primary key(id)
);