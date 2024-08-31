
    create table alunos(
        id bigint not null auto_increment,
        nome varchar(40) not null,
        telefone varchar(11) not null unique,
        email varchar(60) not null unique,
        horario varchar(100) not null,
        aprovado boolean not null,

        primary key(id)

    );
