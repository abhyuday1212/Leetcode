# Write your MySQL query statement below
select unique_id, name
from Employees -- TableA
left join EmployeeUNI -- TableB
on Employees.id = EmployeeUNI.id;