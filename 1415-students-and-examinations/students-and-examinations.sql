# Write your MySQL query statement below
select s.student_id, s.student_name , sbj.subject_name, count(e.subject_name) as  attended_exams
from Students s
cross join Subjects sbj
left join Examinations e
    on s.student_id = e.student_id
    and e.subject_name = sbj.subject_name
    group by s.student_id, s.student_name , sbj.subject_name
order by s.student_id asc