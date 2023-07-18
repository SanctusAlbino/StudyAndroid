--시퀀스
--create table [이름]
--특정 값만큼 증가하는 구분자용. 1부터시작해서 ~~몇씩 증가 nextval(현재 시퀀스값+증가값)
--, currval(현재 시퀀스 값지금값 조회)
-- create <-> drop
--create sequence [이름] increment by 증가값 [number, int]
create sequence seq_test increment by 1;

select seq_test.nextval from dual;

--seq_and_board 만들기
--seq_and_board로 andboard_no(키값)중복한되게 여러건 insert해보기

create sequence seq_and_board increment by 1;
select seq_and_board.nextval from and_board;
insert into and_board(BOARD_CATEGORY, BOARD_NO, BOARD_TITLE, BOARD_CONTENT, CREATE_DATE, CREATE_BY)
values('B', seq_and_board.nextval, 'title', 'content', sysdate, 'dev');

rollback;