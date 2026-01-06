SELECT
    EXTRACT(YEAR FROM os.sales_date) AS year,
    EXTRACT(MONTH FROM os.sales_date) AS month,
    ui.gender,
    count(DISTINCT ui.user_id) AS users
FROM USER_INFO ui
JOIN ONLINE_SALE os ON ui.user_id = os.user_id
WHERE ui.gender is not null
GROUP BY EXTRACT(YEAR FROM os.sales_date), EXTRACT(MONTH FROM os.sales_date), ui.gender
ORDER BY year, month, ui.gender;
