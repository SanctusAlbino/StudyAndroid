set serveroutput on;
declare
v_Str varchar2(100); --변수 선언
begin
    if 1 = 1 then
        dbms_output.put_line('조건이 트루입니다.');
    elsif 1= 2 then
        dbms_output.put_line('조건이 폴스입니다.');
    end if;
end;    