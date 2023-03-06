-- 코드를 입력하세요
SELECT icecream_info.ingredient_type as ingredient_type, sum(first_half.total_order) as total_order
from first_half inner join icecream_info
on icecream_info.flavor = first_half.flavor
group by icecream_info.ingredient_type
order by first_half.total_order
