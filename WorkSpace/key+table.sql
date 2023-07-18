--키를 상속받아서 사용하는것
--키를 상속받을때 꼭 지켜야하는 규칙 (실제 사용): 부모가 가진 기본키를 모두 상속 받아야한다.

create table parent_tb(
    col_key number primary key,
    col_nokey NUMBER
);
==constraint를 이용해서 parent_tb의 키를 상속받아보기
create table child_tb(
    col_key number , --부모키 참조 
    col_nokey NUMBER
);

CREATE TABLE CHILD_TB 
(
  COL_KEY NUMBER 
, COL_NOKEY NUMBER 
);

ALTER TABLE CHILD_TB
ADD CONSTRAINT CHILD_TB_FK1 FOREIGN KEY
(
  COL_KEY 
)
REFERENCES PARENT_TB
(
  COL_KEY 
)
ENABLE;
drop table parent_tb;
drop table child_tb;

-- 게시판. 게시판의 구조가 똑같이
--게시글 번호 (key), 글 제목, 글 내용, 기타ㅏ속성(날짜 글쓴이 등등)일때
--게시판이 여러개 있다면 테이블이 여러개가 되어야할까?

create table and_board(
    board_category varchar2(10) not null, --b면 어떤 게시판... 구분자 키
    board_no number not null,    --자동증가 / 시퀀스와 트리거 이용
    board_title varchar2(200),
    board_content varchar2(2000),
    create_date date ,
    create_by varchar2(100),
    update_date date,
    CONSTRAINT and_board_PK PRIMARY KEY 
  (
    board_category 
  , board_no
  )
  ENABLE,
  CONSTRAINT and_board_FK FOREIGN KEY
(
     create_by
)
REFERENCES ANDMEMBER
(
  ID 
)
ENABLE
    
);
insert into and_board (BOARD_NO, BOARD_TITLE, BOARD_CATEGORY, 
                        BOARD_CONTENT, CREATE_DATE, CREATE_BY, UPDATE_DATE)
values (4, 'title', 'B', 'content', sysdate, 'dev', null );

select * from and_board;
commit;
-- and_board_reply테이블 만들기
--and_board_reply테이블은 부모테이블을 참조 (and_board, and_member)
--and_board_reply테이블은 별도의 키 (reply_no를 가짐)
--그 외에는 자유롭게 
create table and_board_reply( 
    board_category varchar2(100)not null,
    board_no number not null,
    reply_no number not null,
    reply_title varchar2(200),
    reply_content varchar2(2000),
    reply_date date,
    reply_by varchar2(100),
    update_reply_date date,
    CONSTRAINT and_board_reply_PK PRIMARY KEY 
  (
    reply_no
  )
  ENABLE,
  CONSTRAINT and_board_reply_FK_1 FOREIGN KEY
(
     reply_by
)
REFERENCES ANDMEMBER
(
  ID 
)
ENABLE,
CONSTRAINT and_board_reply_FK_2 FOREIGN KEY
(
  board_category
 ,board_no
)
REFERENCES AND_BOARD
(
  BOARD_CATEGORY 
, BOARD_NO 
)
ENABLE
   
);

insert into and_board_reply (BOARD_CATEGORY, BOARD_NO, REPLY_NO, REPLY_TITLE, 
                            REPLY_CONTENT, REPLY_DATE, REPLY_BY, UPDATE_REPLY_DATE)
       values ('B', 2 , 2,'title', 'content', sysdate, 'dev', sysdate);                     
select * from and_board_reply;                            
commit;
                            
                            