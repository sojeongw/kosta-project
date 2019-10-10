--학생, 동아리, 전공 테이블을 만들고 column은 자료와 유사하게 만든다.
--1. 학생 테이블, 동아리 테이블 join
--2. 학생, 동아리, 전공 테이블 join

create table students(
student_id number(5) not null,
first_name varchar2(20),
last_name varchar2(25) not null,
email varchar2(25) not null,
phone_number varchar2(20) not null,
entrance_date date not null,
money number(8,2),
major_name varchar2(25) not null
);

create table clubs(
club_name varchar2(10) not null,
major_name varchar2(25) not null
);

create table majors(
major_id number(4) not null,
major_name varchar2(25) not null,
student_id number(5) not null
);

-- join
select s.first_name, s.last_name, c.club_name, m.major_name
from students s, clubs c, majors m
where ((s.student_id = m.student_id)
and (m.student_id = c.student_id));
-- ansi join
select s.first_name, s.last_name, c.club_name, m.major_name
from students s join majors m 
on s.student_id = m.student_id
join clubs c
on m.student_id = c.student_id;
-- hr ansi join
select e.first_name, d.department_name, j.job_title
from employees e join departments d
on e.department_id = d.department_id
join jobs j
on j.job_id= e.job_id;
-- 7-2
select e.employee_id, d.location_id, j.job_title
from employees e join departments d
on  e.department_id = d.department_id
join jobs j
on j.job_id= e.job_id;
-- Q1
select e.first_name, e.last_name,
decode(d.department_name, 'Executive', '행정부',
                        'Shipping', '발송부') as "부서명"
from employees e, departments d
where e.first_name = 'Steven'
and e.department_id = d.department_id;
-- Q2
select d.department_id, d.department_name, e.first_name, e.salary
from departments d join employees e
on e.salary>12000
and e.department_id = d.department_id
order by e.salary desc;
-- 문제1-1
select e.employee_id, e.salary, j.job_title
from employees e, jobs j
where e.salary>15000 and e.salary<max_salary;
-- 문제1-2
select e.employee_id, e.salary, j.job_title
from employees e, jobs j
where e.salary between 15000 and j.max_salary;
-- 문제2
select e.employee_id, e.salary, j.job_title
from employees e join jobs j
on  e.salary between 15000 and j.max_salary;
-- self join
select e1.employee_id, e1.first_name ||
'의 매니저 '
|| nvl(e2.first_name, '없음')
from employees e1, employees e2
where e1.manager_id = e2.employee_id(+)
-- where e1.manager_id(+) = e2.employee_id : 그 사람을 매니저로 둔 사람을 불러옴
order by e1.employee_id asc;
-- outer join
select e.employee_id, e.first_name, d.department_name
from employees e left outer join departments d
using(department_id) order by e.employee_id asc;
-- 1
select e.employee_id, e.last_name, e.first_name, d.department_name
from employees e left outer join departments d
using (department_id) order by d.department_name desc;
-- 2
select e.first_name, e.last_name, e.job_id, d.location_id, d.department_name
from employees e left outer join departments d
using (department_id) where e.job_id ='IT_PROG';
--3
-- subquery
select * from employees where salary=
(select max(salary) from employees);
-- q1
select first_name||' '||last_name, job_id
from employees
where job_id = (select job_id from employees where employee_id=103);
-- q2
select first_name||' '||last_name, job_id
from employees
where department_id = (select department_id from employees
where first_name='Diana' and last_name='Lorentz');
-- q3
--select e.employee_id, e.first_name||' '||last_name, j.job_title
-- in
SELECT first_name||' '||last_name,job_id,hire_date,salary,department_id
FROM employees
where salary in(
select min(salary) from employees group by job_id
);
-- any
SELECT first_name||' '||last_name,job_id,hire_date,salary,department_id
from employees
where salary < any(17000, 14000, 24000);
-- all
SELECT first_name||' '||last_name,job_id,hire_date,salary,department_id
from employees
where salary < all(17000, 14000, 24000);
-- exist
select *
from employees e1
where not exists (
select employee_id
from employees e2
where e1.employee_id = e2.manager_id);
-- 상호 관련 subquery 예1
select *
from employees e
where exists(
select * from employees where manager_id = e.employee_id
);
-- 예2
select *
from employees e
where salary > (
select avg(salary)
from employees
where department_id = e.department_id);
-- update
select job_id from employees
where first_name = 'David'
and last_name = 'Austin';

select job_id from employees
where first_name = 'John'
and last_name = 'Chen';

update employees
set job_id =
(select job_id from employees
where first_name = 'John' and last_name='Chen')
where first_name = 'David' and last_name='Austin';

update students
set last_name = (
select last_name from students where first_name = 'nana')
where first_name = 'sojeong';
-- 실습문제 1
select d.department_id, d.department_name, e.first_name||' '||last_name, e.salary
from employees e join departments d
on e.department_id = d.department_id;

select department_id, department_name, first_name||' '||last_name, salary
from employees join departments
using (department_id);
-- 2
select e.first_name, d.department_name
from departments d, employees e
where d.department_id=e.department_id and  e.first_name='Steven';

select department_name, department_id
from departments
where department_id in(
select department_id from employees where first_name='Steven'
);

select department_id from employees where first_name='Steven';
-- 3
select department_id, department_name
from departments;

select first_name, last_name, department_id, department_name, salary
from departments left outer join employees 
using (department_id);
-- 4
select e1.first_name||'의 매니저는 '||nvl(e2.first_name, '없다')
from employees e1 left outer join employees e2
on e1.manager_id = e2.employee_id;
-- 5-1
--select e.first_name||' '||e.last_name, e.department_id, j.job_title
--from employees e, jobs j
--where j.job_title in(select j.job_title from jobs j where e.first_name='Neena')
--and e.job_id = j.job_id; : 첨에 틀린거

select first_name||' '||last_name, department_id, salary, job_id
from employees
where job_id = (
select job_id
from employees
where first_name='Neena'
);
-- 5-2
select e.first_name||' '||e.last_name, d.department_name, e.salary, e.job_id
from employees e join departments d
on e.department_id=d.department_id
and e.job_id = (
select job_id
from employees
where first_name='Neena'
);
-- 6
select department_id, employee_id, first_name||' '||last_name, hire_date, salary
from employees
where department_id in (
select department_id from employees where first_name='John');
-- 7-1
select e.employee_id, e.first_name||' '||e.last_name, d.department_name,
e.hire_date, e.salary
from employees e join departments d
on e.salary > (select avg(salary) from employees)
and e.department_id = d.department_id;
-- 7-2
select e.employee_id, e.first_name||' '||e.last_name, d.department_name,
e.hire_date, e.salary, l.city
from employees e join departments d
on e.salary > (select avg(salary) from employees)
and e.department_id = d.department_id
join locations l
using (location_id);
-- 8
select e.employee_id, e.job_id, e.first_name||' '||e.last_name,
d.department_name, e.hire_date, l.city
from employees e, locations l, departments d
where d.department_id= e.department_id
and d.location_id= l.location_id
and e.department_id=10
and job_id in(select job_id from employees where department_id=20);
-- 9
select e.employee_id, e.job_id, e.first_name||' '||e.last_name,
d.department_name, e.hire_date, l.city
from employees e join departments d
on e.department_id=d.department_id
and e.department_id = 10
and job_id not in(select job_id from employees where department_id=30)
join locations l
on l.location_id = d.location_id;
-- 10
select e.employee_id, e.job_id, e.first_name||' '||e.last_name,
d.department_name, d.department_id, l.city, e.salary
from employees e join departments d
on job_id in (select job_id from employees where department_id=10)
and e.department_id=d.department_id
join locations l
on l.LOCATION_ID=d.LOCATION_ID;
-- 11

create table sample1(
num number primary key,
fname varchar2(20),
lname varchar2(20) not null,
tel varchar2(20) not null,
addr varchar2(100),
regdate date default sysdate
);
create sequence sample1_seq;


begin
for i in 1..50 loop
insert into
sample1(num,fname,lname,tel,addr)
values(sample1_seq.nextval,
dbms_random.string('A',19),
dbms_random.string('Q',19),
'010-0000-0000',
'seoul');
end loop;
commit;
end;
/
Select count(*) from sample1;
Select * from sample1;
-- merge
drop table test1;
create table TEST1(pnum number,p2num number,pcount number,price number);
insert into test1 values(1001,2001,100,5000);
insert into test1 values(1002,2002,100,3000);
insert into test1 values(1003,2003,100,2000);

create table TEST2(pnum number,p2num number,pcount number,price number);
insert into test2 values(6001,7001,300,7000);
insert into test2 values(6002,7002,300,8000);
insert into test2 values(6003,7003,300,9000);

create table TEST_merge(pnum number,p2num number,pcount number,price number);

MERGE INTO test_merge tm USING test1 t1
ON (tm.pnum=t1.pnum)
WHEN MATCHED THEN
UPDATE SET tm.p2num=t1.p2num
WHEN NOT MATCHED THEN
INSERT VALUES(t1.pnum, t1.p2num, t1.pcount, t1.price);

MERGE INTO test_merge tm USING test2 t2
ON (tm.pnum=t2.pnum)
WHEN MATCHED THEN
UPDATE SET tm.p2num=t2.p2num
WHEN NOT MATCHED THEN
INSERT VALUES(t2.pnum, t2.p2num, t2.pcount, t2.price);
-- constraint
create table test_board(
wnum number(4),
writer varchar2(10) constraint test_b_writer_nn not null,
title varchar2(4) constraint test_b_title_nn not null,
wdate char(13) default sysdate constraint test_b_wdate_nn not null,
vcount number(2),
constraint test_b_wnum_pk primary key(wnum)
);
-- check
CREATE TABLE test4_dept(
deptno NUMBER(2),dname VARCHAR2(15)
default '개발부',loc_id CHAR(1),
CONSTRAINT test4_dept_deptno_pk PRIMARY KEY (deptno),
CONSTRAINT test4_dept_loc_ck CHECK(loc_id IN('1', '2'))
);
CREATE TABLE test4_emp(
empno NUMBER(4),
ename VARCHAR2(10) CONSTRAINT test4_emp_ename_nn NOT NULL,
loc_name VARCHAR2(6),
jumin CHAR(13),deptno NUMBER(2),
sal NUMBER,CONSTRAINT test4_emp_no_pk PRIMARY KEY (empno),
CONSTRAINT test4_emp_jumin_uq UNIQUE (jumin),
CONSTRAINT test4_emp_deptno_fk FOREIGN KEY (deptno) REFERENCES test4_dept(deptno));

INSERT INTO test4_dept VALUES(10, '영업부', '1');
INSERT INTO test4_dept VALUES(20, '기획부', '1');
INSERT INTO test4_dept VALUES(30, '홍보부', '2');
INSERT INTO test4_dept VALUES(40, '관리부', '2');
INSERT INTO test4_emp VALUES(1001, '홍길동', '서울', '1234561234567', 10,3000);
INSERT INTO test4_emp VALUES(1002, '최길동', '서울', '1234561234568', 10,4000);
INSERT INTO test4_emp VALUES(1003, '박길동', '경기', '1234561234569', 20,5000);
INSERT INTO test4_emp VALUES(1004, '양길동', '경기', '1234561234571', 30,6000);
INSERT INTO test4_emp VALUES(1005, '한길동', '서울', '1234561234572', 40,7000);
INSERT INTO test4_emp VALUES(1006, '강길동', '서울', '1234561234573', 40,8000);
Commit;
-- 실습1-문1
create view test4_emp_view as select empno, ename from test4_emp where deptno=10;
select * from test4_emp_view;
desc test4_emp_view;
-- 실습1-문2
create view test4_dept_view as
select deptno, dname from test4_dept where deptno=20;
select * from test4_dept_view;
desc test4_dept_view;
-- 실습2-문1
create or replace view test4_emp_view(employee_id, employee_name)
as select empno, ename from test4_emp where deptno=10;
-- 실습2-문2
create or replace view test4_dept_view(department_id, department_name)
as select deptno, dname from test4_dept where deptno=20;
-- 실습3-문1
create or replace view test4_emp_join_dept_view(사원번호, 사원명, 부서명, 지역명)
as select e.empno, e.ename, d.dname, e.loc_name from test4_emp e, test4_dept d
where e.deptno=d.deptno;
-- 실습4-문1
create or replace view test_emp_join_dept_view
(부서명, 최저급여, 최고급여, 평균급여) as
select d.dname, min(e.sal), max(e.sal), avg(e.sal)
from test4_dept d, test4_emp e
where e.deptno=d.deptno
group by dname;
-- rownum, rowid
select rowid, rownum, department_id, department_name
from departments;
-- 실습1
select first_name, hire_date from employees order by hire_Date desc;
select first_name, hire_date from(
select * from employees order by hire_date desc
)
where rownum<=5;