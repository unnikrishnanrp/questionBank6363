drop table Teaches;
drop table Person;
drop table Answer;
drop table Question;
drop table Course;


create table Person
(per_id varchar(7),
name varchar(50),
user_name varchar(7),
password varchar(20),
apt_no varchar(5),
city varchar(20),
state varchar(2),
zip_code int,
email varchar(40),
gender char(1),
primary key (per_id));


create table Course
(course_id varchar(7),
title varchar(50),
dept_name varchar(7),
credit int,
primary key (course_id));

create table Teaches
(per_id varchar(7),
course_id varchar(7),
primary key (per_id, course_id),
foreign key (per_id) references Person,
foreign key (course_id) references Course
);

create table Question
(question_id varchar(7),
course_id varchar(7),
chapter varchar(7),
primary key (question_id),
foreign key (course_id) references Course
);

create table Answer
(answer_id varchar(7),
question_id varchar(7),
answer_text varchar(200),
primary key (answer_id),
foreign key (question_id) references Question
);
