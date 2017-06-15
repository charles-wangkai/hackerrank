SELECT GROUP_CONCAT(n ORDER BY n SEPARATOR '&')
  FROM (
        SELECT n
          FROM (
                SELECT t_1.d * 100 + t_2.d * 10 + t_3.d AS n
                  FROM (
                        SELECT 0 AS d
                        UNION
                        SELECT 1 AS d
                        UNION
                        SELECT 2 AS d
                        UNION
                        SELECT 3 AS d
                        UNION
                        SELECT 4 AS d
                        UNION
                        SELECT 5 AS d
                        UNION
                        SELECT 6 AS d
                        UNION
                        SELECT 7 AS d
                        UNION
                        SELECT 8 AS d
                        UNION
                        SELECT 9 AS d
                       ) t_1,
                       (
                        SELECT 0 AS d
                        UNION
                        SELECT 1 AS d
                        UNION
                        SELECT 2 AS d
                        UNION
                        SELECT 3 AS d
                        UNION
                        SELECT 4 AS d
                        UNION
                        SELECT 5 AS d
                        UNION
                        SELECT 6 AS d
                        UNION
                        SELECT 7 AS d
                        UNION
                        SELECT 8 AS d
                        UNION
                        SELECT 9 AS d
                       ) t_2,
                       (
                        SELECT 0 AS d
                        UNION
                        SELECT 1 AS d
                        UNION
                        SELECT 2 AS d
                        UNION
                        SELECT 3 AS d
                        UNION
                        SELECT 4 AS d
                        UNION
                        SELECT 5 AS d
                        UNION
                        SELECT 6 AS d
                        UNION
                        SELECT 7 AS d
                        UNION
                        SELECT 8 AS d
                        UNION
                        SELECT 9 AS d
                       ) t_3
               ) t
         WHERE n >= 2
           AND NOT EXISTS (
                SELECT 1
                  FROM (
                    SELECT t1_1.d * 100 + t1_2.d * 10 + t1_3.d AS n
                      FROM (
                            SELECT 0 AS d
                            UNION
                            SELECT 1 AS d
                            UNION
                            SELECT 2 AS d
                            UNION
                            SELECT 3 AS d
                            UNION
                            SELECT 4 AS d
                            UNION
                            SELECT 5 AS d
                            UNION
                            SELECT 6 AS d
                            UNION
                            SELECT 7 AS d
                            UNION
                            SELECT 8 AS d
                            UNION
                            SELECT 9 AS d
                           ) t1_1,
                           (
                            SELECT 0 AS d
                            UNION
                            SELECT 1 AS d
                            UNION
                            SELECT 2 AS d
                            UNION
                            SELECT 3 AS d
                            UNION
                            SELECT 4 AS d
                            UNION
                            SELECT 5 AS d
                            UNION
                            SELECT 6 AS d
                            UNION
                            SELECT 7 AS d
                            UNION
                            SELECT 8 AS d
                            UNION
                            SELECT 9 AS d
                           ) t1_2,
                           (
                            SELECT 0 AS d
                            UNION
                            SELECT 1 AS d
                            UNION
                            SELECT 2 AS d
                            UNION
                            SELECT 3 AS d
                            UNION
                            SELECT 4 AS d
                            UNION
                            SELECT 5 AS d
                            UNION
                            SELECT 6 AS d
                            UNION
                            SELECT 7 AS d
                            UNION
                            SELECT 8 AS d
                            UNION
                            SELECT 9 AS d
                           ) t1_3
                       ) t1
                 WHERE t1.n BETWEEN 2 AND t.n - 1
                   AND t.n % t1.n = 0
               )
       ) t2;