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
/* default sysdate : 시스템 날짜를 넣어줘 */

drop table board;
--------------------------------------------
시퀀스
create sequence seq_board_num; 값을 계속 증가시켜준다
drop sequence seq_board_num;
--------------------------------------------
입력
insert into board(num, title, content, writer)
values(seq_board_num.nextval, 'title', 'content', 'kim');
--------------------------------------------
수정
update board set title = 'aaa',
content = 'bbbb', writer = 'cccc'
where num = 2;
--------------------------------------------
삭제 : 조건만 있으면 지울 수 있다
delete from board where num = 2;
--------------------------------------------
select * from board;
select * from board where num = 12;