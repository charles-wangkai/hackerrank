SELECT cty.Name
  FROM City cty, Country cnt
 WHERE cty.CountryCode = cnt.Code
   AND cnt.Continent = 'Africa';