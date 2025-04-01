SELECT t.item_id, i.item_name, i.rarity
FROM item_info AS i
JOIN item_tree AS t ON i.item_id = t.item_id
WHERE t.parent_item_id 
in 
(SELECT item_id
FROM item_info
WHERE rarity = 'RARE')
ORDER BY item_id desc;