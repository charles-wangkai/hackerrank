SELECT t_doctor.name AS Doctor, t_professor.name AS Professor, t_singer.name AS Singer, t_actor.name AS Actor
  FROM (
        SELECT t1.name, COUNT(*) AS rank
          FROM OCCUPATIONS t1
          JOIN OCCUPATIONS t2
            ON t2.Occupation = t1.Occupation
           AND t1.Occupation = 'Doctor'
           AND t2.name <= t1.name
        GROUP BY t1.name
       ) t_doctor
  LEFT JOIN (
        SELECT t1.name, COUNT(*) AS rank
          FROM OCCUPATIONS t1
          JOIN OCCUPATIONS t2
            ON t2.Occupation = t1.Occupation
           AND t1.Occupation = 'Professor'
           AND t2.name <= t1.name
        GROUP BY t1.name
       ) t_professor
    ON t_professor.rank = t_doctor.rank
  LEFT JOIN (
        SELECT t1.name, COUNT(*) AS rank
          FROM OCCUPATIONS t1
          JOIN OCCUPATIONS t2
            ON t2.Occupation = t1.Occupation
           AND t1.Occupation = 'Singer'
           AND t2.name <= t1.name
        GROUP BY t1.name
       ) t_singer
    ON t_singer.rank = t_doctor.rank
  LEFT JOIN (
        SELECT t1.name, COUNT(*) AS rank
          FROM OCCUPATIONS t1
          JOIN OCCUPATIONS t2
            ON t2.Occupation = t1.Occupation
           AND t1.Occupation = 'Actor'
           AND t2.name <= t1.name
        GROUP BY t1.name
       ) t_actor
    ON t_actor.rank = t_doctor.rank

UNION

SELECT t_doctor.name AS Doctor, t_professor.name AS Professor, t_singer.name AS Singer, t_actor.name AS Actor
  FROM (
        SELECT t1.name, COUNT(*) AS rank
          FROM OCCUPATIONS t1
          JOIN OCCUPATIONS t2
            ON t2.Occupation = t1.Occupation
           AND t1.Occupation = 'Professor'
           AND t2.name <= t1.name
        GROUP BY t1.name
       ) t_professor
  LEFT JOIN (
        SELECT t1.name, COUNT(*) AS rank
          FROM OCCUPATIONS t1
          JOIN OCCUPATIONS t2
            ON t2.Occupation = t1.Occupation
           AND t1.Occupation = 'Doctor'
           AND t2.name <= t1.name
        GROUP BY t1.name
       ) t_doctor
    ON t_doctor.rank = t_professor.rank
  LEFT JOIN (
        SELECT t1.name, COUNT(*) AS rank
          FROM OCCUPATIONS t1
          JOIN OCCUPATIONS t2
            ON t2.Occupation = t1.Occupation
           AND t1.Occupation = 'Singer'
           AND t2.name <= t1.name
        GROUP BY t1.name
       ) t_singer
    ON t_singer.rank = t_professor.rank
  LEFT JOIN (
        SELECT t1.name, COUNT(*) AS rank
          FROM OCCUPATIONS t1
          JOIN OCCUPATIONS t2
            ON t2.Occupation = t1.Occupation
           AND t1.Occupation = 'Actor'
           AND t2.name <= t1.name
        GROUP BY t1.name
       ) t_actor
    ON t_actor.rank = t_professor.rank

UNION

SELECT t_doctor.name AS Doctor, t_professor.name AS Professor, t_singer.name AS Singer, t_actor.name AS Actor
  FROM (
        SELECT t1.name, COUNT(*) AS rank
          FROM OCCUPATIONS t1
          JOIN OCCUPATIONS t2
            ON t2.Occupation = t1.Occupation
           AND t1.Occupation = 'Singer'
           AND t2.name <= t1.name
        GROUP BY t1.name
       ) t_singer
  LEFT JOIN (
        SELECT t1.name, COUNT(*) AS rank
          FROM OCCUPATIONS t1
          JOIN OCCUPATIONS t2
            ON t2.Occupation = t1.Occupation
           AND t1.Occupation = 'Doctor'
           AND t2.name <= t1.name
        GROUP BY t1.name
       ) t_doctor
    ON t_doctor.rank = t_singer.rank
  LEFT JOIN (
        SELECT t1.name, COUNT(*) AS rank
          FROM OCCUPATIONS t1
          JOIN OCCUPATIONS t2
            ON t2.Occupation = t1.Occupation
           AND t1.Occupation = 'Professor'
           AND t2.name <= t1.name
        GROUP BY t1.name
       ) t_professor
    ON t_professor.rank = t_singer.rank
  LEFT JOIN (
        SELECT t1.name, COUNT(*) AS rank
          FROM OCCUPATIONS t1
          JOIN OCCUPATIONS t2
            ON t2.Occupation = t1.Occupation
           AND t1.Occupation = 'Actor'
           AND t2.name <= t1.name
        GROUP BY t1.name
       ) t_actor
    ON t_actor.rank = t_singer.rank

UNION

SELECT t_doctor.name AS Doctor, t_professor.name AS Professor, t_singer.name AS Singer, t_actor.name AS Actor
  FROM (
        SELECT t1.name, COUNT(*) AS rank
          FROM OCCUPATIONS t1
          JOIN OCCUPATIONS t2
            ON t2.Occupation = t1.Occupation
           AND t1.Occupation = 'Actor'
           AND t2.name <= t1.name
        GROUP BY t1.name
       ) t_actor
  LEFT JOIN (
        SELECT t1.name, COUNT(*) AS rank
          FROM OCCUPATIONS t1
          JOIN OCCUPATIONS t2
            ON t2.Occupation = t1.Occupation
           AND t1.Occupation = 'Doctor'
           AND t2.name <= t1.name
        GROUP BY t1.name
       ) t_doctor
    ON t_doctor.rank = t_actor.rank
  LEFT JOIN (
        SELECT t1.name, COUNT(*) AS rank
          FROM OCCUPATIONS t1
          JOIN OCCUPATIONS t2
            ON t2.Occupation = t1.Occupation
           AND t1.Occupation = 'Professor'
           AND t2.name <= t1.name
        GROUP BY t1.name
       ) t_professor
    ON t_professor.rank = t_actor.rank
  LEFT JOIN (
        SELECT t1.name, COUNT(*) AS rank
          FROM OCCUPATIONS t1
          JOIN OCCUPATIONS t2
            ON t2.Occupation = t1.Occupation
           AND t1.Occupation = 'Singer'
           AND t2.name <= t1.name
        GROUP BY t1.name
       ) t_singer
    ON t_singer.rank = t_actor.rank;