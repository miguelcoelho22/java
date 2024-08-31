create table turmas(
      id bigint not null auto_increment,
      anoTurma varchar(100) not null,
      horarioTurma varchar(100) not null,
      professor_id bigint not null,
      aluno_id bigint not null,

      primary key(id),
      constraint fk_turmas_professor_id foreign key(professor_id) references professores(id),
      constraint fk_turmas_aluno_id foreign key(aluno_id) references alunos(id)
    );