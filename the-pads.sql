SELECT value
  FROM (
        SELECT CONCAT(Name, '(', SUBSTR(Occupation, 1, 1), ')') AS value,
               1 AS key1,
               Name AS key2,
               NULL AS key3
          FROM OCCUPATIONS

        UNION ALL

        SELECT CONCAT('There are a total of ', COUNT(*), ' ', LOWER(Occupation), 's.') AS value,
               2 AS key1,
               COUNT(*) AS key2,
               Occupation AS key3
          FROM OCCUPATIONS
        GROUP BY Occupation
       ) t
ORDER BY key1, key2, key3;