-- 코드를 입력하세요
SELECT car_id,
       to_char(round(avg(end_date - start_date + 1), 1), 'FM9990.0') average_duration
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
GROUP BY car_id
HAVING avg(end_date - start_date + 1) >= 7
ORDER BY to_number(average_duration) desc, car_id desc;