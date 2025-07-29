-- 코드를 입력하세요
SELECT ('/home/grep/src/' || ub.board_id || '/' || uf.file_id || uf.file_name || uf.file_ext) as file_path
FROM USED_GOODS_BOARD ub INNER JOIN USED_GOODS_FILE uf ON ub.board_id = uf.board_id 
WHERE ub.views = (select max(views) from USED_GOODS_BOARD)
ORDER BY uf.file_id desc


