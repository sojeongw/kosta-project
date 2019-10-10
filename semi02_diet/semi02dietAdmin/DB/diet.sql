create table reply(
content varchar2(4000),
reg_date date default sysdate
);

create sequence seq_board;
drop sequence seq_board;

drop table reply;

create table board(
num number primary key,
content varchar2(4000) not null,
reg_date date default sysdate,
id varchar2(20) not null
);

create table DIETMEMBER(
ID	VARCHAR2(20) NOT NULL	primary key,
PW 	VARCHAR2(20) NOT NULL,
NAME	VARCHAR2(20),
AGE	NUMBER,
GENDER 	VARCHAR2(20),
TEL 	VARCHAR2(20),
HEIGHT 	NUMBER,
WEIGHT 	NUMBER,
GOAL	NUMBER,
GRADE	VARCHAR2(20)
);

create table userkcal(
ID	VARCHAR2(20),
DAY	VARCHAR2(50),
TOTALKCAL	NUMBER
);
