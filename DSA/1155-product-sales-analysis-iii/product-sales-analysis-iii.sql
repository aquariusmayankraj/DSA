select
year as first_year,
product_id, quantity, price
from Sales
where (product_id,year) 
in (select product_id, min(year) as year from Sales group by product_id)
