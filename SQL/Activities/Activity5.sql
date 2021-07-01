
--Activity5

-- Update the grade score of salesmen from Rome to 200.
UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

-- Update the grade score of Pit Alex to 300. ( NOTE : James Hoog is not present in table)

UPDATE salesman SET grade=300 WHERE salesman_name='Pit Alex';

-- Update the name McLyon to Pierre.
UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

-- Display modified data
SELECT * FROM salesman;