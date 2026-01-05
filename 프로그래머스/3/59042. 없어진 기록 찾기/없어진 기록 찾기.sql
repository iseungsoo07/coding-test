SELECT
    ao.animal_id,
    ao.name
FROM ANIMAL_OUTS ao
LEFT JOIN ANIMAL_INS ai on ao.animal_id = ai.animal_id
WHERE ai.animal_id is null
ORDER BY ao.animal_id;