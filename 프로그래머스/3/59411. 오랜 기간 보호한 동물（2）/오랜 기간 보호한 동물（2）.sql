SELECT 
    animal_id, name
FROM (
    SELECT
        ai.animal_id,
        ai.name,
        ao.datetime - ai.datetime AS duration
    FROM ANIMAL_INS ai 
    JOIN ANIMAL_OUTS ao on ai.animal_id = ao.animal_id
    ORDER BY duration desc
) WHERE rownum <= 2;
