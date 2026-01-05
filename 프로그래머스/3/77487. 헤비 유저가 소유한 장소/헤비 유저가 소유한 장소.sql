-- 코드를 입력하세요
SELECT 
    id,
    name,
    host_id
FROM PLACES
WHERE host_id IN (
    SELECT 
        host_id
    FROM PLACES
    GROUP BY host_id
    HAVING count(*) >= 2
)
ORDER BY ID;
