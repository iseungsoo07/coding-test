SELECT
    ai.animal_id,
    ai.animal_type,
    ai.name
FROM ANIMAL_INS ai
JOIN ANIMAL_OUTS ao ON ai.animal_id = ao.animal_id
WHERE ai.sex_upon_intake LIKE 'Intact%' 
AND (ao.sex_upon_outcome LIKE 'Spayed%' OR ao.sex_upon_outcome LIKE 'Neutered%')
ORDER BY ai.animal_id;