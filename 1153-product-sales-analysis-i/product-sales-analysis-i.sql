# Write your MySQL query statement below
select product_name, year, price
from Sales -- table A
left join Product
on Sales.product_id = Product.product_id;