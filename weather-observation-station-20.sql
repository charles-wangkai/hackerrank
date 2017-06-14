SELECT ROUND(AVG(t_lower.LAT_N), 4)
  FROM (
        SELECT t1.LAT_N, COUNT(*) AS cnt
          FROM STATION t1
          JOIN STATION t2
            ON t2.LAT_N < t1.LAT_N
            OR (t2.LAT_N = t1.LAT_N AND t2.ID <= t1.ID)
        GROUP BY t1.LAT_N
       ) t_lower
  JOIN (
        SELECT t1.LAT_N, COUNT(*) AS cnt
          FROM STATION t1
          JOIN STATION t2
            ON t2.LAT_N > t1.LAT_N
            OR (t2.LAT_N = t1.LAT_N AND t2.ID >= t1.ID)
        GROUP BY t1.LAT_N
       ) t_upper
    ON t_upper.LAT_N = t_lower.LAT_N
 WHERE t_lower.cnt - t_upper.cnt BETWEEN -1 AND 1;