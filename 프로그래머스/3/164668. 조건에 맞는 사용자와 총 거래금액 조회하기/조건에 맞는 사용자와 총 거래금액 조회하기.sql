-- 코드를 입력하세요
SELECT uu.user_id,
       uu.nickname,
       sum(ub.price) as total_sales
FROM USED_GOODS_BOARD ub JOIN USED_GOODS_USER uu ON ub.writer_id = uu.user_id
WHERE ub.status = 'DONE'
GROUP BY uu.user_id, uu.nickname
HAVING sum(ub.price) >= 700000 
ORDER BY sum(ub.price);