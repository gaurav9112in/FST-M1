--Activity 9

-- Create the customers table
create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);

-- Insert values into it
insert into customers values 
(3002, 'Nick Rimando', 'New York', 100, 5001), (3007, 'Brad Davis', 'New York', 200, 5001),
(3005, 'Graham Zusi', 'California', 200, 5002), (3008, 'Julian Green', 'London', 300, 5002),
(3004, 'Fabian Johnson', 'Paris', 300, 5006), (3009, 'Geoff Cameron', 'Berlin', 100, 5003),
(3003, 'Jozy Altidor', 'Moscow', 200, 5007), (3001, 'Brad Guzan', 'London', 300, 5005);

--To know which salesman are working for which customer.
select c.CUSTOMER_ID , c.CUSTOMER_NAME, s.SALESMAN_ID , s.SALESMAN_NAME  from customers c INNER JOIN salesman s ON c.salesman_id = s.salesman_id;   
   
-- To make a list in ascending order for the customer who holds a grade less than 300 and works either through a salesman.   
SELECT a.customer_name, a.city, a.grade, b.name AS "Salesman", b.city FROM customers a 
LEFT OUTER JOIN salesman b ON a.salesman_id=b.salesman_id WHERE a.grade<300 
ORDER BY a.customer_id;


-- To find the list of customers who appointed a salesman for their jobs who gets a commission from the company is more than 12%.
select c.CUSTOMER_ID, c.CUSTOMER_NAME, s.SALESMAN_ID, s.SALESMAN_NAME from customers c INNER JOIN salesman s ON c.salesman_id = s.salesman_id
WHERE s.commission > 12;  
    

--To find the details of a order i.e. order number, order date, amount of order, which customer gives the order and which salesman works for that customer and commission rate he gets for an order.
SELECT a.order_no, a.order_date, a.purchase_amount, b.customer_name AS "Customer Name", b.grade, c.SALESMAN_NAME AS "Salesman", c.commission FROM orders a 
INNER JOIN customers b ON a.customer_id=b.customer_id 
INNER JOIN salesman c ON a.salesman_id=c.salesman_id;
