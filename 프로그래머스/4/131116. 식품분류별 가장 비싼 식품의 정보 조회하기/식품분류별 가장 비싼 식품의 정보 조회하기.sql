SELECT category, max_price, product_name
FROM (
    SELECT
        category,
        price,
        max(price) OVER (PARTITION BY category) AS max_price,
        product_name
    FROM FOOD_PRODUCT
    WHERE category IN ('과자', '국', '김치', '식용유')
) T
WHERE max_price = T.price
ORDER BY T.price DESC
