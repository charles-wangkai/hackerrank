SELECT X, Y
  FROM (
        SELECT X, Y
          FROM Functions f1
         WHERE X < Y
           AND EXISTS (SELECT 1 FROM Functions f2 WHERE f2.X = f1.Y AND f2.Y = f1.X)

        UNION

        SELECT X, Y
          FROM Functions
         WHERE X = Y
        GROUP BY X, Y
        HAVING COUNT(*) > 1
       ) t
ORDER BY X;