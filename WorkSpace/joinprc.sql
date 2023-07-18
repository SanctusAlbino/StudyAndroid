--JOIN (?)
--INNER JOIN A n B <- 교집합을 가져온다. 
--LEFT, RIGHT OUTER JOIN <- (A n B) U (A-B)
--FULL JOIN

--[inner or outer or full] [join] on key=key , 조건=조건
select e.*, d.*, l.*
from employees e left outer join departments d on e.department_id = d.department_id
                 left outer join locations l on d.location_id = l.location_id;
--from employees e inner join departments d on e.employee_id = d.department_name; join이 정확히 안되어서
--결과를 출력할수가없는상태?