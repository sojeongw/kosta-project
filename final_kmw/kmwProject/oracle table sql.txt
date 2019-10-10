create table login_info(
id varchar2(100) not null primary key,
pw varchar2(100) not null);

create table control(
line varchar2(100) primary key not null,
motion varchar2(100));

create table second(
case number not null,
line number not null,
voltage number not null,
amp number not null,
per_time number not null);

create table ideal (
goal number not null,
case number,
line number,
i_energy number);

create table result(
id varchar2(100) not null,
constraint id_fk foreign key(id) references login_info(id),
goal number not null,
case number not null,
tot_energy number not null,
error_rate number not null,
cost number not null,
real_get number not null,
time number not null);

create table c_final(
id varchar2(100) not null,
constraint id_fk2 foreign key(id) references login_info(id),
best_case number not null,
choose_case number not null,
goal number not null);

create table case1(
id  varchar2(100) not null,
constraint id_fk_case1 foreign key(id) references login_info(id),
line number not null,
goal number not null,
e_time number,
energy number);

create table case2(
id  varchar2(100) not null,
constraint id_fk_case2 foreign key(id) references login_info(id),
line number not null,
goal number not null,
e_time number,
energy number);

create table case3(
id  varchar2(100) not null,
constraint id_fk_case3 foreign key(id) references login_info(id),
line number not null,
goal number not null,
e_time number,
energy number);

insert into login_info values('kmw', '123');
