--Table 명 : AndMember
--컬럼 : id, password, name, phonenumber, address, profileimg, gender
-- 키 : id
--성별 : 남 또는 여만 입력 가능
--비밀번화와 이름은 null이면 안됨
--데이터는 두건 정도 넣고 테스트

create table AndMember(
id      varchar2(50) primary key,
password      varchar2(300) not null,
name        varchar2(50) not null, 
phonenumber      nvarchar2(20),
address     varchar2(300),
profileimg     varchar2(300),
gender      varchar2(3) default '남' check (gender in ('남','여')) enable
);
insert into Andmember(id, password, name, phonenumber, address, profileimg, gender)
values ('dev','pw','개발자','010-1234-5678','광주광역시 서구',
        'https://img.hani.co.kr/imgdb/original/2007/1227/68227042_20071227.jpg','남');
        
        commit;
        select * from AndMember;
        --Spring을 이용하여 테이블을 이용하여 로그인 정보를 가져옴
        
rollback;

select * from andmember;