SELECT e1.id, ifnull(count(e2.parent_id), 0) as child_count
FROM ecoli_data e1 left join ecoli_data e2
on e1.id = e2.parent_id
group by e1.id
order by e1.id