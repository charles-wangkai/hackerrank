SELECT w.id, p.age, w.coins_needed, w.power
  FROM Wands w
  JOIN Wands_Property p
    ON w.code = p.code
   AND p.is_evil = 0
 WHERE (w.power, w.code, w.coins_needed) IN (
        SELECT power, code, MIN(coins_needed)
          FROM Wands
        GROUP BY power, code
       )
ORDER BY w.power DESC, p.age DESC;