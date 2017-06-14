SELECT N,
       CASE WHEN P IS NULL THEN 'Root'
            WHEN NOT EXISTS (SELECT 1 FROM BST t2 WHERE t2.P = t1.N) THEN 'Leaf'
            ELSE 'Inner'
       END
  FROM BST t1
ORDER BY N;