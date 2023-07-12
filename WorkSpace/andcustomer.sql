insert into customer
select *
from customer;

select * from customer order by id asc;
select count(*) from customer;
commit;
rollback;
delete from customer where id < 100;