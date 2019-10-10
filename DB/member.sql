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
/* default sysdate : 시스템 날짜를 넣어줘 */

drop table member;
--------------------------------------------
--시퀀스
create sequence seq_member_num; /*값을 계속 증가시켜준다*/
drop sequence seq_member_num;
--------------------------------------------
--입력
insert into member(num, id, pw, name, tel)
values(seq_member_num.nextval, 'test id', 'test pw', 'test name', '4655');
--------------------------------------------
--수정
update member set id = 'update id',pw = 'update pw', name = 'update name',tel = '747'8 where num = 2;
--------------------------------------------
--삭제 : 조건만 있으면 지울 수 있다
delete from member;
delete from member where num = 3;
--------------------------------------------
select * from member;
select * from member where num = 5;