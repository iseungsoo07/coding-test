WITH tmp AS (
    SELECT
        food_type, max(favorites) AS favorites
    FROM REST_INFO
    GROUP BY food_type
)
SELECT 
    ri.food_type, ri.rest_id, ri.rest_name, ri.favorites
FROM REST_INFO ri JOIN tmp on ri.food_type = tmp.food_type
WHERE ri.favorites = tmp.favorites
ORDER BY ri.food_type DESC;


