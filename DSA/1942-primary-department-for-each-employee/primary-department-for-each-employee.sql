select employee_id, department_id
from Employee 
where primary_flag = 'Y'
union
select department_id, employee_id
from Employee
group by employee_id
having count(employee_id) = 1