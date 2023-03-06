-- 코드를 입력하세요
SELECT food_order.product_id, food_product.product_name, sum(food_product.price * food_order.amount) as total_sales
from food_product inner join food_order
on food_product.product_id = food_order.product_id
where year(food_order.produce_date) = 2022 and month(food_order.produce_date) = 5
group by food_order.product_id
order by total_sales desc, food_order.product_id