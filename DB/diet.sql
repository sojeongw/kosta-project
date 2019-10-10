-- login
create table login(
id varchar2(20) not null primary key,
pw varchar2(20) not null
);

insert into login(id, pw) values ('manager', 'hi123456');
insert into login(id, pw) values ('admin', 'hi123456');
insert into login(id, pw) values ('sojeong', 'hi123456');

drop table login;

insert into login(id, pw)
values('sojeong', 'adad');

-- member_info
create table member_info(
id varchar2(20) not null primary key references login(id) on delete cascade,
name varchar2(20),
age number,
gender varchar2(20),
tel varchar2(20),
grade varchar2(2),
profile_pic varchar2(200)
);

drop table member_info;

insert into member_info(id, name, age, gender, tel, grade)
values('sojeong', 'wang', 28, 'female', '010', 'A');
insert into member_info(id, name, age, gender, tel, grade)
values('manager', 'wang', 28, 'female', '010', 'A');

-- member_goal
create table member_goal(
id varchar2(20) not null primary key references login(id) on delete cascade,
height number,
weight number,
goal number,
diet_pic varchar2(200)
);
drop table member_goal;

-- diet_sports
create table diet_sports(
id varchar2(20) not null primary key references login(id) on delete cascade,
sports_date date default sysdate,
running number,
bicycle number,
rope number,
totalkcal number
);
drop table diet_sports;

-- diet_board
create table diet_board(
id varchar2(20) not null references login(id) on delete cascade,
board_num number not null primary key,
content varchar2(200),
board_date date default sysdate,
reply varchar2(200)
);
drop table diet_board;

drop table diet_board CASCADE CONSTRAINTS;

create sequence seq_board;
drop sequence seq_board;

-- board insert
insert into diet_board(
board_num, id, content, board_date)
values(seq_board.nextval, id, content, sysdate);

insert into diet_board(id, board_num, content, board_date, reply)
values ('sojeong', seq_board.nextval, '����', sysdate, '�亯');

-- admin board update
update diet_board set
reply =	reply, board_date = sysdate where board_num = board_num;

update diet_board set
reply =	'�亯 ����', board_date = sysdate where board_num = board_num;

-- board delete
delete from diet_board where board_num = board_num;

-- board list : selectAll
select * from diet_board order by board_num;

-- board selectOne
select * from diet_board where board_num = board_num;

