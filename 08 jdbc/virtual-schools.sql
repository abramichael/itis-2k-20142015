University


Преподаватели
Учебные заведения (преподаватели)
Студенты
Предметы
Экзамены


create table "schools" (
	"id" integer not null primary key,
	"name" varchar(50) not null
);

create table "teachers" (
	"id" integer not null primary key,
	"name" varchar(50) not null,
	"school_id" integer not null references "schools"("id")
);

create table "students" (
	"id" integer not null primary key,
	"name" varchar(50) not null
);

create table "classes" (
	"id" integer not null primary key,
	"name" varchar(50) not null
);

create table "attendance" (
	"class_id" integer not null references "classes"("id"),
	"teacher_id" integer not null references "teachers"("id"),
	"year" integer not null,
	"student_id" integer not null references "students"("id")
);

insert into schools values(1, 'Hogwarts');
insert into schools values(2, 'X-Mansion');

insert into teachers values(1, 'Severus Snape', 1);
insert into teachers values(2, 'Horace Slughorn', 1);
insert into teachers values(3, 'Professor X', 2);

insert into students values(1, 'Harry Potter');
insert into students values(2, 'Tom Riddle');
insert into students values(3, 'Wolverine');
insert into students values(4, 'Jean');

insert into classes values(1, 'Potions');
insert into classes values(2, 'Mutant History');
insert into classes values(3, 'Mind Control');

insert into attendance values(1,1,1992,1);
insert into attendance values(1,1,1993,1);
insert into attendance values(1,2,1941,2);
insert into attendance values(1,2,1942,2);
insert into attendance values(1,2,1996,1);
insert into attendance values(2,3,1995,4);
insert into attendance values(2,3,2000,3);
insert into attendance values(3,3,1996,4);


