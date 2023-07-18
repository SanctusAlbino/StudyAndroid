--trigger 의 기본형태
-- TRIGGER 의 기본형태.
--CREATE [ OR REPLACE ] TRIGGER [ schema.] trigger
--BEFORE | AFTER | INSTEAD OF
--DML EVENT ( INSERT [OR] UPDATE [OR} DELETE )
--ON [SCHEMA.] DATABASE TABLE
--WHEN ( 조건)
--PL/SQL_BLOCK | CALL_PROCEDURE_STATEMENT ; 

--트리거 : DML EVENT/ 즉 트랜잭션이 발생하는 작업을 하기 전 또는 후에 어떤 로직을 실행하게 만드는것
--구분    new(신규) / old(기존)
--insert 새로들어온데이터(행)/ null:데이터 행이 새로추가될때에는 기존(old)데이터는 없음
--update 바뀐 데이터 (행) / 바뀌기 전 데이터 (행)
--delete null / 삭제 되는 데이터(기존)
--for each row : insert, update, delete는 여러행이 한번에 작업되는 경우가 존재한다.
--따라서 한 행마다의 작업을 구분한다.
--begin end; pl/sql 
-- for(i<insert.row){

--}

--before DML이벤트가 시작 전, after 하고 나서
--이벤트 기준으로 전, 후
--trigger를 이용해서 여러시점에 대해서 and_board_history에 이력을 남긴다. 
create table and_board_history(
    board_category varchar2(10) not null, 
    board_no number not null, 
    board_title varchar2(200),
    board_content varchar2(2000),
    create_date date, 
    STATUS_VALUE varchar2(50)
);

create or replace trigger trg_and_board --1
AFTER update or delete --시점(수정 또는 삭제)
on and_board --트리거를 부착할 테이블 이름
for each row --각 행마다 적용이 된다.
begin
    if updating then
        insert into and_board_history
        values(:old.board_category, :old.board_no, :old.board_title, :old.board_content, sysdate, 'updating');
    elsif deleting then
        insert into and_board_history
        values(:old.board_category, :old.board_no, :old.board_title, :old.board_content, sysdate, 'deleting');
    end if;    
end;

create or replace trigger trg_and_board_pk --1
before insert --시점(추가 전 시점)
on and_board --트리거를 부착할 테이블 이름
for each row --각 행마다 적용이 된다.
begin
    :new.board_no := seq_and_board.nextval; --int numboardno = 10;
end;





