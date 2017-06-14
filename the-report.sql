SELECT IF(g.Grade < 8, NULL, s.Name) AS Name,
       g.Grade AS Grade,
       s.Marks AS Mark
  FROM Students s
  JOIN Grades g
    ON s.Marks BETWEEN g.Min_Mark AND g.Max_Mark
ORDER BY Grade DESC, NAME, Mark;