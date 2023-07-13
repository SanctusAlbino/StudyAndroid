select count(*) from employees;
select * from employees;

select Employee_id from employees where MOD(Employee_id, 2) = 0;
--case
select MOD(Employee_id, 2) from employees;
select last_name||' '||first_name name from employees;
select email||' hhh'from employees;

select e.employee_id, e.last_name||' '||e.first_name name, e.salary, d.department_name,
case when mod(e.employee_id,2) =0 then e.email||'@gmail.com'
     when mod(e.employee_id,2) =1 then e.email||'@naver.com' 
end 이메일,
replace (e.phone_number, '.', '-') 전화번호 ,
TO_CHAR(e.hire_date, 'YYYY-MM-DD')입사일,
case when e.commission_pct is null then TO_CHAR(e.salary*1289, 'FM999,999,999,999')||'원'
     ELSE TO_CHAR((e.salary*1289)+(e.salary*1289*e.commission_pct), 'FM999,999,999,999')||'원('|| TO_CHAR(e.salary*1289*e.commission_pct, 'FM999,999,999,999')||')' 
    end 급여
from employees e LEFT JOIN departments d 
ON   e.department_id = d.department_id;

SELECT COUNT(*)
from employees e LEFT OUTER JOIN departments d 
ON   e.department_id = d.department_id;




--String str = str + "hhh" last_name+ " " + first_name
--String email = email||'hhh' last_name||' '||first_name