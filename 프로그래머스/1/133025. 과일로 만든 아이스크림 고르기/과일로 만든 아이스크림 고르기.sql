-- 코드를 입력하세요

SELECT f.flavor
from FIRST_HALF f join ICECREAM_INFO i
on f.flavor = i.flavor
where total_order > 3000 and ingredient_type = 'fruit_based'
order by total_order desc;