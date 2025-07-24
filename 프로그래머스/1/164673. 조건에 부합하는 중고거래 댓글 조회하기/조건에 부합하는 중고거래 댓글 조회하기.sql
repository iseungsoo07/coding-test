-- 코드를 입력하세요
SELECT ub.title,
       ub.board_id,
       ur.reply_id,
       ur.writer_id,
       ur.contents,
       TO_CHAR(ur.created_date, 'YYYY-MM-DD') created_date
FROM USED_GOODS_BOARD ub INNER JOIN USED_GOODS_REPLY ur ON ub.board_id = ur.board_id
WHERE to_char(ub.created_date, 'YYYY-MM') = '2022-10'
ORDER BY ur.created_date ASC, ub.title ASC;