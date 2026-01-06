SELECT 
    T.product_id,
    T.product_name,
    T.total_amt * A.price AS total_sales
FROM FOOD_PRODUCT A
JOIN (
    SELECT
        fp.product_id,
        fp.product_name,
        sum(fo.amount) as total_amt
    FROM FOOD_PRODUCT fp
    JOIN FOOD_ORDER fo on fp.product_id = fo.product_id
    WHERE to_char(fo.produce_date, 'YYYYMM') = '202205'
    GROUP BY fp.product_id, fp.product_name
) T
ON A.product_id = T.product_id
ORDER BY total_sales DESC, T.product_id;
