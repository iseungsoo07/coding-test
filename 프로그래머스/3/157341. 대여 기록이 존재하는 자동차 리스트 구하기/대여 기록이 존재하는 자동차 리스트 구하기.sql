-- 코드를 입력하세요
SELECT DISTINCT cr.car_id
FROM CAR_RENTAL_COMPANY_CAR cr
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY ch ON cr.car_id = ch.car_id
WHERE cr.car_type = '세단' and SUBSTR(to_char(start_date, 'YYYYMMDD'), 5, 2) = '10'
ORDER BY cr.car_id desc


