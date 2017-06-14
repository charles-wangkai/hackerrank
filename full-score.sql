SELECT h.hacker_id, h.name
  FROM Submissions s
  JOIN Challenges c
    ON c.challenge_id = s.challenge_id
  JOIN Difficulty d
    ON d.difficulty_level = c.difficulty_level
   AND d.score = s.score
  JOIN Hackers h
    ON h.hacker_id = s.hacker_id
GROUP BY h.hacker_id, h.name
HAVING COUNT(*) > 1
ORDER BY COUNT(*) DESC, hacker_id;