SELECT (SELECT MAX(salary * months) FROM Employee),
       (SELECT COUNT(*) FROM Employee WHERE salary * months = (SELECT MAX(salary * months) FROM Employee));