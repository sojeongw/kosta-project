delete from test where num =5;

create table test(
num number,
name varchar2(20)   /*�ѱ��� 2byte�� 10�ڱ���*/
);

drop table test;    /*table�� ����� rollback�� �� ��. �׳� ���ϴ� ��*/

drop sequence seq_test;
create sequence seq_test_num;

insert into test(num,name) values(seq_test_num.nextval,'kim');

select num, name from test;
select * from test;
select * from test where num > 12;  /*���ٴ� = �ϳ���*/
