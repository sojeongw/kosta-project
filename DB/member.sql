create user member identified by hi123456;
grant connect, resource to member;

drop user member;
--------------------------------------------
create table member (
  num number primary key,
  id varchar2(20) not null,
  pw varchar2(20),
  name varchar2(20) not null,
  tel varchar2(20)
);
/* default sysdate : �ý��� ��¥�� �־��� */

drop table member;
--------------------------------------------
--������
create sequence seq_member_num; /*���� ��� ���������ش�*/
drop sequence seq_member_num;
--------------------------------------------
--�Է�
insert into member(num, id, pw, name, tel)
values(seq_member_num.nextval, 'test id', 'test pw', 'test name', '4655');
--------------------------------------------
--����
update member set id = 'update id',pw = 'update pw', name = 'update name',tel = '747'8 where num = 2;
--------------------------------------------
--���� : ���Ǹ� ������ ���� �� �ִ�
delete from member;
delete from member where num = 3;
--------------------------------------------
select * from member;
select * from member where num = 5;