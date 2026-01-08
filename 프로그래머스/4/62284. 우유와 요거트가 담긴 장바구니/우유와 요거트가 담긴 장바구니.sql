SELECT cart_id
FROM CART_PRODUCTS
WHERE cart_id IN (
    SELECT 
        cart_id
    FROM CART_PRODUCTS
    WHERE name = 'Milk'
) AND name = 'Yogurt'
