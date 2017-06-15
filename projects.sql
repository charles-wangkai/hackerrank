SELECT p1.Start_Date, p2.End_Date
  FROM Projects p1
  JOIN Projects p2
    ON p1.Start_Date <= p2.Start_Date
   AND DATEDIFF(p2.End_Date, p1.Start_Date) = (
            SELECT COUNT(*)
            FROM Projects
            WHERE Start_Date BETWEEN p1.Start_Date AND p2.Start_Date
        )
   AND NOT EXISTS (
            SELECT 1
              FROM Projects p3
              JOIN Projects p4
                ON p3.Start_Date <= p4.Start_Date
               AND DATEDIFF(p4.End_Date, p3.Start_Date) = (
                        SELECT COUNT(*)
                        FROM Projects
                        WHERE Start_Date BETWEEN p3.Start_Date AND p4.Start_Date
                    )
             WHERE p3.Start_Date <= p1.Start_Date
               AND p4.Start_Date >= P2.Start_Date
               AND NOT (p3.Start_Date = p1.Start_Date AND p4.Start_Date = P2.Start_Date)
        )
ORDER BY DATEDIFF(p2.End_Date, p1.Start_Date), p1.Start_Date;