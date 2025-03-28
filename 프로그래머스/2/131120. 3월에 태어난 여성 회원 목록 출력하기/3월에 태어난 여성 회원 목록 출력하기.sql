-- 코드를 입력하세요
SELECT member_id, member_name, gender, DATE_FORMAT(date_of_birth, '%Y-%m-%d')
from member_profile
where tlno is not null and gender = 'W' and MONTH(DATE_OF_BIRTH) = 3;