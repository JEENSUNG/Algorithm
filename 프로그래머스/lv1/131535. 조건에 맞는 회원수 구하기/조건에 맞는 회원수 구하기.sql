-- 코드를 입력하세요
SELECT count(*)
from user_info
where year(joined) = 2021 and age >= 20 and age <= 29