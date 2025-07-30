-- 코드를 입력하세요
SELECT distinct uu.user_id,
       uu.nickname,
       uu.city || ' ' || uu.street_address1 || ' ' || uu.street_address2 AS "전체주소",
       substr(uu.tlno, 1, 3) || '-' || substr(uu.tlno, 4, 4) || '-' || substr(uu.tlno, 8, 4) AS "전화번호"
FROM USED_GOODS_BOARD ub
JOIN USED_GOODS_USER uu ON ub.writer_id = uu.user_id
WHERE ub.writer_id IN (
    SELECT b.writer_id FROM USED_GOODS_BOARD b
    GROUP BY b.writer_id
    HAVING count(*) >= 3
)
ORDER BY uu.user_id desc;
    