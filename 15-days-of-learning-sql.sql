SELECT t2.submission_date, t2.hacker_cnt, h.hacker_id, h.name
  FROM (
        SELECT submission_date, COUNT(DISTINCT hacker_id) AS hacker_cnt
          FROM (
                SELECT s1.submission_date, s1.hacker_id, COUNT(DISTINCT s2.submission_date) AS day_cnt
                  FROM Submissions s1
                  JOIN Submissions s2
                    ON s2.hacker_id = s1.hacker_id
                   AND s2.submission_date <= s1.submission_date
                GROUP BY s1.submission_date, s1.hacker_id
               ) t4
         WHERE DATEDIFF(submission_date, '2016-03-01') + 1 = day_cnt
        GROUP BY submission_date
       ) t2
  JOIN (
        SELECT submission_date, hacker_id
          FROM (
                SELECT submission_date, hacker_id, COUNT(*) AS cnt
                  FROM Submissions
                GROUP BY submission_date, hacker_id
               ) t
         WHERE NOT EXISTS (
                SELECT 1
                  FROM (
                        SELECT submission_date, hacker_id, COUNT(*) AS cnt
                          FROM Submissions
                        GROUP BY submission_date, hacker_id
                       ) t1
                 WHERE t1.submission_date = t.submission_date
                   AND t1.hacker_id <> t.hacker_id
                   AND (t1.cnt > t.cnt OR (t1.cnt = t.cnt AND t1.hacker_id < t.hacker_id))
               )
       ) t3
    ON t3.submission_date = t2.submission_date
  JOIN Hackers h
    ON h.hacker_id = t3.hacker_id
ORDER BY t2.submission_date;