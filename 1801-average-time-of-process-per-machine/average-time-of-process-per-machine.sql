# Write your MySQL query statement below
select t1.machine_id, round(avg(t2.timestamp - t1.timestamp),3) as processing_time
from Activity as t1
inner join Activity as t2
    on t1.machine_id = t2.machine_id   -- both rows belong to same machine
    and t1.process_id = t2.process_id   -- both rows are for the same process
    and t1.activity_type = 'start'      -- left side must be a start
    and t2.activity_type = 'end'        -- right side must be an end
group by machine_id
