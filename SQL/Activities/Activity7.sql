
-- Activity 7

select * from orders;

--To find the total purchase amount of all orders.
select SUM(PURCHASE_AMOUNT) AS TOTAL_SUM FROM ORDERS;

--To find the average purchase amount of all orders.
select AVG(PURCHASE_AMOUNT) AS AVERAGE_SUM FROM ORDERS;


-- To get the maximum purchase amount of all the orders.
select MAX(PURCHASE_AMOUNT) AS MAX_SUM FROM ORDERS;

-- To get the minimum purchase amount of all the orders.
select MIN(PURCHASE_AMOUNT) AS MAX_SUM FROM ORDERS;

-- To find the number of salesmen listed in the table.
select COUNT(SALESMAN_ID) FROM ORDERS GROUP BY SALESMAN_ID;


 