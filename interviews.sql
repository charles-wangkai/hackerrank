SELECT con.contest_id,
       con.hacker_id,
       con.name,
       t3.total_submissions,
       t3.total_accepted_submissions,
       t3.total_views,
       t3.total_unique_views
  FROM (
        SELECT t.contest_id,
               SUM(total_submissions) AS total_submissions,
               SUM(total_accepted_submissions) AS total_accepted_submissions,
               SUM(total_views) AS total_views,
               SUM(total_unique_views) AS total_unique_views
          FROM (
                SELECT DISTINCT col.contest_id, cha.challenge_id
                  FROM Colleges col
                  JOIN Challenges cha
                    ON cha.college_id = col.college_id
               ) t
          LEFT JOIN (
                SELECT challenge_id,
                       SUM(total_views) AS total_views,
                       SUM(total_unique_views) AS total_unique_views
                  FROM View_Stats
                GROUP BY challenge_id
               ) t1
            ON t1.challenge_id = t.challenge_id
          LEFT JOIN (
                SELECT challenge_id,
                       SUM(total_submissions) AS total_submissions,
                       SUM(total_accepted_submissions) AS total_accepted_submissions
                  FROM Submission_Stats
                GROUP BY challenge_id
               ) t2
            ON t2.challenge_id = t.challenge_id
        GROUP BY t.contest_id
       ) t3
  JOIN Contests con
    ON con.contest_id = t3.contest_id;