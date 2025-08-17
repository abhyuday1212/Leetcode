# Write your MySQL query statement below
select e.name, b.bonus
from Employee as e -- table a
left join bonus as b -- table b
on e.empId = b.empId 
where bonus < 1000 or b.bonus is null