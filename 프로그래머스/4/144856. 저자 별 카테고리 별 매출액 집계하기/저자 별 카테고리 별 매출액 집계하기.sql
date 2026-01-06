SELECT 
    a.author_id,
    a.author_name,
    b.category,
    sum(T.total_sales) AS total_sales
FROM AUTHOR a
JOIN BOOK b on a.author_id = b.author_id
JOIN (
    SELECT 
        b.book_id,
        b.category,
        sum(b.price * bs.sales) AS total_sales
    FROM BOOK_SALES bs
    JOIN BOOK b ON bs.book_id = b.book_id
    JOIN AUTHOR a ON b.author_id = a.author_id
    WHERE TO_CHAR(bs.sales_date, 'YYYYMM') = '202201'
    GROUP BY b.book_id, b.category
) T ON b.book_id = T.book_id
GROUP BY a.author_id, a.author_name, b.category
ORDER BY a.author_id, b.category DESC;