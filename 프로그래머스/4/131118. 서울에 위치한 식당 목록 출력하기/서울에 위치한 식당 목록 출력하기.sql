# -- 코드를 입력하세요
SELECT ri.rest_id,
    ri.rest_name,
    ri.food_type,
    ri.favorites,
    ri.address,
    round(avg(rr.review_score), 2) as score
from REST_INFO ri join REST_REVIEW rr
on ri.rest_id = rr.rest_id
group by ri.rest_id
having ri.address like '서울%'
order by score desc, ri.favorites desc;