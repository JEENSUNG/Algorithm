-- 코드를 입력하세요
SELECT july.flavor 
from july inner join first_half
on july.flavor = first_half.flavor
group by july.flavor
order by sum(first_half.total_order+july.total_order) desc limit 3