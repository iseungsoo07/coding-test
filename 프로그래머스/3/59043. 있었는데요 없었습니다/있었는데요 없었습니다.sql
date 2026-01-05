SELECT
    ai.animal_id,
    ai.name
FROM ANIMAL_INS ai 
JOIN ANIMAL_OUTS ao on ai.animal_id = ao.animal_id
WHERE ai.datetime > ao.datetime
ORDER BY ai.datetime;