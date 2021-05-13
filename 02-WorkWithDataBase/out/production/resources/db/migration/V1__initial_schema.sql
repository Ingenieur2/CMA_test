create table "students"
(
    id bigserial not null primary key,
    first_name varchar(50),
    second_name varchar(50),
    middle_name varchar(50),
    date_of_birth date,
    student_group varchar(255)
);

insert into "students" (first_name, second_name, middle_name, date_of_birth, student_group)
values ('Ivan', 'Petrov', 'Ivanovich',  '1980-05-05', '1');

insert into "students" (first_name, second_name, middle_name, date_of_birth, student_group)
values ('Igor', 'Ivanov', 'Petrovich',  '1995-06-27', '1');

insert into "students" (first_name, second_name, middle_name, date_of_birth, student_group)
values ('Yana', 'Kim', 'Sergeevna',  '1998-07-02', '2');
