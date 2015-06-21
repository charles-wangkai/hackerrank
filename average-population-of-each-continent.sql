SELECT cnt.Continent, FLOOR(AVG(cty.Population))
  FROM City cty, Country cnt
 WHERE cty.CountryCode = cnt.Code
GROUP BY cnt.Continent;