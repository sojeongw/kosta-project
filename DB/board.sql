create user board identified by hi123456;
grant connect, resource to board;

drop user board;
--------------------------------------------
create table board (
  num number primary key,
  imgName varchar2(200) not null,
  title varchar2(200) not null,
  content varchar2(4000),
  writer varchar2(20) not null,
  reg_date Date default sysdate 
);
/* default sysdate : �ý��� ��¥�� �־��� */

drop table board;
--------------------------------------------
������
create sequence seq_board_num; ���� ��� ���������ش�
drop sequence seq_board_num;
--------------------------------------------
�Է�
insert into board(num, title, content, writer)
values(seq_board_num.nextval, 'title', 'content', 'kim');
--------------------------------------------
����
update board set title = 'aaa',
content = 'bbbb', writer = 'cccc'
where num = 2;
--------------------------------------------
���� : ���Ǹ� ������ ���� �� �ִ�
delete from board where num = 2;
--------------------------------------------
select * from board;
select * from board where num = 12;