CREATE DATABASE config_lesson_JavaVision ENCODING 'UTF-8';

create table if not exists engines (
     model varchar(25),
     power int not null,
     primary key (model));

insert into  engines (model, power)
                values ('engine_model_01', 1250);
insert into  engines (model, power)
                values ('engine_model_02', 2510);