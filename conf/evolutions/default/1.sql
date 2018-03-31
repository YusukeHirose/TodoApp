# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table todos (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  deadline                  datetime,
  rate                      varchar(255),
  state                     integer,
  created_at                datetime not null,
  updated_at                datetime not null,
  constraint uq_todos_title unique (title),
  constraint pk_todos primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table todos;

SET FOREIGN_KEY_CHECKS=1;

