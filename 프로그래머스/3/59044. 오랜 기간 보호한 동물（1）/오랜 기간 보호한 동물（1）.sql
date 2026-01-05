SELECT
    ai.name,
    ai.datetime
FROM ANIMAL_INS ai
LEFT JOIN ANIMAL_OUTS ao on ai.animal_id = ao.animal_id
WHERE ao.animal_id is null
ORDER BY ai.datetime
FETCH FIRST 3 ROWS ONLY;