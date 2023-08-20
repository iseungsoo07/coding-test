-- 코드를 입력하세요
SELECT count(*) as no_age_user
from user_info
where age is null or age = ''