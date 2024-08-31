alter table medicos add telefone varchar(20) not null;
alter table medicos add ativo tinyint;
update medicos set ativo = 1;
