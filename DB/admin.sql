create user admin identified by hi123456 account unlock;
grant connect, resource to admin;

create table menu(
num number primary key,
imgname varchar2(200) not null,
menu varchar2(20) not null,
price number not null,
store varchar2(20) not null,
kcal number not null
);

drop table menu;

create sequence seq_menu_num;
drop sequence seq_menu_num;

insert into menu(num, menu, price, store, kcal) values(seq_menu_num.nextval, 'bento', 6000, 'zip', 500);
select * from menu order by num desc