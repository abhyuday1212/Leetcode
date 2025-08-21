# Write your MySQL query statement below
select
    ifnull(
        (SELECT DISTINCT salary 
        FROM Employee e
        ORDER BY salary DESC
        LIMIT 1 OFFSET 1),
        null
    ) as SecondHighestSalary