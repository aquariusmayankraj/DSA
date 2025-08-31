select e1.name as Employee
from Employee e1
join Employee e2
on e1.managerID = e2.Id
where e1.salary>e2.salary;