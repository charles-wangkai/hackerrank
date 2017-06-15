SELECT REPEAT('* ', N)
  FROM (
        SELECT 1 AS N
        UNION
        SELECT 2 AS N
        UNION
        SELECT 3 AS N
        UNION
        SELECT 4 AS N
        UNION
        SELECT 5 AS N
        UNION
        SELECT 6 AS N
        UNION
        SELECT 7 AS N
        UNION
        SELECT 8 AS N
        UNION
        SELECT 9 AS N
        UNION
        SELECT 10 AS N
        UNION
        SELECT 11 AS N
        UNION
        SELECT 12 AS N
        UNION
        SELECT 13 AS N
        UNION
        SELECT 14 AS N
        UNION
        SELECT 15 AS N
        UNION
        SELECT 16 AS N
        UNION
        SELECT 17 AS N
        UNION
        SELECT 18 AS N
        UNION
        SELECT 19 AS N
        UNION
        SELECT 20 AS N
       ) t
ORDER BY N DESC;