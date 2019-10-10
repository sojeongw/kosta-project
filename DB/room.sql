create table login_table(
num number not null,
id varchar(20) not null,
pw varchar(20)not null
);

create sequence seq_login_table_num;
drop sequence seq_login_table;
insert into LOGIN_TABLE (num, id, pw) values (seq_LOGIN_TABLE_num.nextval, 'moon', 'hi123456');
insert into LOGIN_TABLE (num, id, pw) values (seq_LOGIN_TABLE_num.nextval, 'kim', 'hi123456');
insert into LOGIN_TABLE (num, id, pw) values (seq_LOGIN_TABLE_num.nextval, 'wang', 'hi123456');
insert into LOGIN_TABLE (num, id, pw) values (seq_LOGIN_TABLE_num.nextval, 'jeon', 'hi123456');


CREATE TABLE OFFICE_TABLE(
R_NUM NUMBER PRIMARY KEY,
R_NAME VARCHAR2(20) NOT NULL,
WINDOW_CNT NUMBER NOT NULL,
DOOR_CNT NUMBER NOT NULL,
FIRE NUMBER DEFAULT 0 NOT NULL,
WINDOW_SCE NUMBER DEFAULT 0 NOT NULL,
DOOR_SCE NUMBER DEFAULT 0 NOT NULL
);

CREATE TABLE LOGIN_TABLE(
NUM NUMBER NOT NULL,
ID VARCHAR(50) NOT NULL,
PW VARCHAR(50) NOT NULL
);

CREATE SEQUENCE SEQ_LOGIN_NUM;

INSERT INTO LOGIN_TABLE (NUM, ID, PW) VALUES (SEQ_LOGIN_NUM.NEXTVAL, 'moon', 'hi123456');
INSERT INTO LOGIN_TABLE (NUM, ID, PW) VALUES (SEQ_LOGIN_NUM.NEXTVAL, 'kim', 'hi123456');
INSERT INTO LOGIN_TABLE (NUM, ID, PW) VALUES (SEQ_LOGIN_NUM.NEXTVAL, 'jeon', 'hi123456');
INSERT INTO LOGIN_TABLE (NUM, ID, PW) VALUES (SEQ_LOGIN_NUM.NEXTVAL, 'wang', 'hi123456');
