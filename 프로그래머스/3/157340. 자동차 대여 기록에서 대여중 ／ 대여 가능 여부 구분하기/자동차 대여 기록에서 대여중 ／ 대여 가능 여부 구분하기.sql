-- 코드를 입력하세요
SELECT
  c.car_id,
  CASE
    WHEN EXISTS (
      SELECT 1
      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY h
      WHERE h.car_id = c.car_id
        AND TO_DATE('20221016', 'YYYYMMDD') BETWEEN h.start_date AND h.end_date
    )
    THEN '대여중'
    ELSE '대여 가능'
  END AS avaliability
FROM (
  SELECT DISTINCT car_id
  FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
) c
ORDER BY c.car_id DESC;
