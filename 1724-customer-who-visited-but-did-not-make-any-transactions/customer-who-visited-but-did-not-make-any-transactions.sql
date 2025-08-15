# Write your MySQL query statement below
-- Left Join
select customer_id , count(customer_id) as count_no_trans
from Visits as v -- table A
left join Transactions as t
    on v.visit_id = t.visit_id
where t.visit_id IS NULL              -- exclude visits that have a transaction
group by v.customer_id;