# Write your MySQL query statement below
select query_name,
-- round((sum(rating/position))/(select count(query_name) from Queries), 2) as quality,
-- round((select count(rating) from Queries having rating < 3 )*100/(select count(query_name) from Queries), 2) as poor_query_percentage
round(avg(rating/position), 2) as quality,
round(avg(if(rating < 3, 1, 0)), 4)*100 as poor_query_percentage
from Queries
group by query_name