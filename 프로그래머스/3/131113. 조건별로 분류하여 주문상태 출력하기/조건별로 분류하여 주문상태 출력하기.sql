SELECT
    order_id,
    product_id,
    to_char(out_date, 'YYYY-MM-DD'),
    CASE 
        WHEN out_date <= to_date('20220501', 'YYYYMMDD') THEN '출고완료'
        WHEN out_date > to_date('20220501', 'YYYYMMDD') THEN '출고대기'
        WHEN out_date is null THEN '출고미정'
    END AS "출고여부"
FROM FOOD_ORDER
ORDER BY order_id;