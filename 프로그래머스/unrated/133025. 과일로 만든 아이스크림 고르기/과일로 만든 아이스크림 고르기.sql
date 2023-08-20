-- 코드를 입력하세요
SELECT fh.flavor 
from first_half fh
    join icecream_info i on fh.flavor = i.flavor
where fh.total_order > 3000 and i.ingredient_type = 'fruit_based'
order by fh.total_order desc;