-- 코드를 입력하세요
SELECT uu.user_id,
       uu.nickname,
       sum(ub.price) as total_sales
FROM USED_GOODS_BOARD ub JOIN USED_GOODS_USER uu ON ub.writer_id = uu.user_id
GROUP BY uu.user_id, uu.nickname, ub.status
HAVING sum(ub.price) >= 700000 and ub.status = 'DONE'
ORDER BY sum(ub.price);



