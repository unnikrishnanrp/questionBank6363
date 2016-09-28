delete from Teaches;
delete from Person;
delete from Answer;
delete from Question;
delete from Course;
 
drop sequence seq_per;
create sequence seq_per
start with 10001
increment by 1
maxvalue 19999 
nocycle;


INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);
INSERT INTO Person VALUES ('P'||seq_per.nextval,null,null,null,null);

drop sequence seq_course;
create sequence seq_course
start with 1001
increment by 1
maxvalue 1999
nocycle;

INSERT INTO Course VALUES('C'||seq_course.nextval, null, null, null);
INSERT INTO Course VALUES('C'||seq_course.nextval, null, null, null);
INSERT INTO Course VALUES('C'||seq_course.nextval, null, null, null);
INSERT INTO Course VALUES('C'||seq_course.nextval, null, null, null);
INSERT INTO Course VALUES('C'||seq_course.nextval, null, null, null);
INSERT INTO Course VALUES('C'||seq_course.nextval, null, null, null);
INSERT INTO Course VALUES('C'||seq_course.nextval, null, null, null);
INSERT INTO Course VALUES('C'||seq_course.nextval, null, null, null);
INSERT INTO Course VALUES('C'||seq_course.nextval, null, null, null);
INSERT INTO Course VALUES('C'||seq_course.nextval, null, null, null);

INSERT INTO Teaches VALUES('P10001', 'C1001');
INSERT INTO Teaches VALUES('P10002', 'C1002');
INSERT INTO Teaches VALUES('P10003', 'C1003');
INSERT INTO Teaches VALUES('P10004', 'C1004');
INSERT INTO Teaches VALUES('P10005', 'C1005');
INSERT INTO Teaches VALUES('P10006', 'C1006');


drop sequence seq_question;
create sequence seq_question
start with 1001
increment by 1
maxvalue 1999 
nocycle;


INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);
INSERT INTO Question VALUES ('Q'||seq_question.nextval,null,null);


drop sequence seq_answer;
create sequence seq_answer
start with 1001
increment by 1
maxvalue 1999
nocycle;

INSERT INTO Question VALUES ('A'||seq_answer.nextval,null,null);
INSERT INTO Question VALUES ('A'||seq_answer.nextval,null,null);
INSERT INTO Question VALUES ('A'||seq_answer.nextval,null,null);
INSERT INTO Question VALUES ('A'||seq_answer.nextval,null,null);
INSERT INTO Question VALUES ('A'||seq_answer.nextval,null,null);
INSERT INTO Question VALUES ('A'||seq_answer.nextval,null,null);
INSERT INTO Question VALUES ('A'||seq_answer.nextval,null,null);
INSERT INTO Question VALUES ('A'||seq_answer.nextval,null,null);
INSERT INTO Question VALUES ('A'||seq_answer.nextval,null,null);
INSERT INTO Question VALUES ('A'||seq_answer.nextval,null,null);