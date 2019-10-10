delete from test where num =5;

create table test(
num number,
name varchar2(20)   /*한글은 2byte라 10자까지*/
);

drop table test;    /*table을 지우면 rollback이 안 됨. 그냥 망하는 것*/

drop sequence seq_test;
create sequence seq_test_num;

insert into test(num,name) values(seq_test_num.nextval,'kim');

select num, name from test;
select * from test;
select * from test where num > 12;  /*같다는 = 하나다*/
