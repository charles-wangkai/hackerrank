SELECT SUM(cty.Population)
  FROM City cty, Country cnt
 WHERE cty.CountryCode = cnt.Code
   AND cnt.Continent = 'Asia';