SELECT
    month,
    car_id,
    count(*) AS records
FROM (
    SELECT 
        EXTRACT(MONTH FROM cr.start_date) AS month,
        cr.car_id
    FROM ( 
        SELECT 
            car_id,
            count(*) as rental_cnt
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE to_char(start_date, 'YYYYMMDD') >= '20220801'
        AND to_char(start_date, 'YYYYMMDD') < '20251101'
        GROUP BY car_id
        having count(*) >= 5
    ) tmp
    JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY cr ON tmp.car_id = cr.car_id 
    AND to_char(start_date, 'YYYYMMDD') >= '20220801' AND to_char(start_date, 'YYYYMMDD') < '20251101'
    GROUP BY cr.car_id, cr.start_date
) T
GROUP BY T.month, T.car_id
ORDER BY month, car_id desc;