SELECT hacker_id, name, challenges_created
  FROM (
        SELECT h.hacker_id, h.name, COUNT(*) AS challenges_created
          FROM Challenges c
          JOIN Hackers h
            ON h.hacker_id = c.hacker_id
        GROUP BY h.hacker_id, h.name
       ) t2
 WHERE challenges_created NOT IN (
            SELECT challenges_cnt
              FROM (
                    SELECT COUNT(*) AS challenges_cnt
                      FROM Challenges
                    GROUP BY hacker_id
                   ) t
             WHERE challenges_cnt <> (SELECT MAX(cnt)
                                        FROM (
                                            SELECT COUNT(*) AS cnt
                                              FROM Challenges
                                            GROUP BY hacker_id
                                        ) t1
                                     )
            GROUP BY challenges_cnt
            HAVING COUNT(*) > 1
        )
ORDER BY challenges_created DESC, hacker_id;