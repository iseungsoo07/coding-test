SELECT 
    b.category,
    sum(bs.sales) AS total_sales
FROM BOOK b JOIN BOOK_SALES bs on b.book_id = bs.book_id
WHERE to_char(bs.sales_date, 'YYYYMM') = '202201'
GROUP BY b.category
ORDER BY b.category ASC;
