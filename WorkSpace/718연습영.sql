create sequence seq_crud_retrofit increment by 1;
select seq_crud_retrofit.nextval from dual;

create or replace trigger trg_crud_retrofit_pk --1
before insert --시점(추가 전 시점)
on crud_retrofit --트리거를 부착할 테이블 이름
for each row --각 행마다 적용이 된다.
begin
    :new.col_no := seq_crud_retrofit.nextval; --int numboardno = 10;
end;

create table crud_retrofit(
    col_no number primary key not null,
    col1 varchar2(1000),
    col2 varchar2(1000)
);
commit;

select * from crud_retrofit;

insert into crud_retrofit(col1, col2)
values ('a','b');