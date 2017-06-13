SELECT CASE WHEN NOT (A + B > C AND B + C > A AND C + A > B) THEN 'Not A Triangle'
            WHEN A = B AND B = C THEN 'Equilateral'
            WHEN A = B OR B = C OR C = A THEN 'Isosceles'
            ELSE 'Scalene'
       END
  FROM TRIANGLES;