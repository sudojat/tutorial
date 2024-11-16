-- Step 1: Insert data into the class table with MONITOR as NULL initially
/*
INSERT INTO classs (ID, CLASS_TEACHER, MONITOR, NAME) VALUES
(1, 'Mr. Smith', NULL, 'Math'),
(2, 'Ms. Johnson', NULL, 'Science'),
(3, 'Mr. Brown', NULL, 'History'),
(4, 'Mrs. White', NULL, 'English'),
(5, 'Ms. Green', NULL, 'Geography');

-- Step 2: Insert data into the student table with CLASS_ID references
INSERT INTO students (ID, DATE_OF_BIRTH, FIRST_NAME, LAST_NAME, CLASS_ID) VALUES
(1, '2005-06-15', 'Alice', 'Johnson', 1),
(2, '2006-08-22', 'Bob', 'Smith', 1),
(3, '2005-12-05', 'Charlie', 'Brown', 2),
(4, '2006-03-19', 'David', 'Wilson', 2),
(5, '2005-10-10', 'Eve', 'Davis', 3),
(6, '2007-01-01', 'Frank', 'Miller', 3),
(7, '2006-06-30', 'Grace', 'Clark', 4),
(8, '2005-09-20', 'Hank', 'Wright', 4),
(9, '2006-11-11', 'Ivy', 'Walker', 5),
(10, '2005-02-14', 'Jack', 'Lewis', 5);

-- Step 3: Update the class table to set MONITOR to a student ID after insertion
UPDATE classs SET MONITOR = 1 WHERE ID = 1;  -- Alice is monitor for Math
UPDATE classs SET MONITOR = 3 WHERE ID = 2;  -- Charlie is monitor for Science
UPDATE classs SET MONITOR = 5 WHERE ID = 3;  -- Eve is monitor for History
UPDATE classs SET MONITOR = 7 WHERE ID = 4;  -- Grace is monitor for English
UPDATE classs SET MONITOR = 9 WHERE ID = 5;  -- Ivy is monitor for Geography;

*/