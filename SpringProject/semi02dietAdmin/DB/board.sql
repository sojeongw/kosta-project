create user diet identified by hi123456;
grant connect to diet ;
grant resource to diet ;

create table board(
num number primary key,
content varchar2(4000) not null,
reg_date date default sysdate,
reply varchar2(4000) not null
);

create sequence seq_board;
drop sequence seq_member;

--drop table member;
--
--create table member(id varchar2(20) primary key,
--pw varchar2(20) not null,
--name varchar2(20) not null,
--age varchar2(20) ,
--gender varchar2(20) ,
--tel varchar2(20) ,
--height varchar2(20) ,
--weight varchar2(20),
--goal varchar2(20),
--ranking varchar2(20));
--
--create sequence seq_ranking;
--drop sequence seq_ranking;