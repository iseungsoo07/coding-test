-- 코드를 입력하세요
SELECT board_id, writer_id, title, price,
CASE 
    WHEN status = 'DONE' THEN '거래완료'
    WHEN status = 'SALE' THEN '판매중'
    ELSE '예약중'
END as status
FROM USED_GOODS_BOARD
WHERE to_char(created_date, 'YYYY-MM-DD') = '2022-10-05'
ORDER BY board_id desc;