-- PanelQuery 1
SELECT aflevering.Volgnummer, aflevering.SerieTitel, voortgang.BekekenPercentage
FROM voortgang
INNER JOIN profiel
  ON profiel.Naam = voortgang.Profielnaam AND profiel.AbonneeNr = voortgang.AbonneeNr
INNER JOIN programma
  ON programma.ID = voortgang.ProgrammaID
INNER JOIN aflevering
  ON aflevering.ID = programma.ID
WHERE profiel.Naam = "Sven902"; -- Sven902 vervangen met profielnaam variable

-- PanelQuery 2
SELECT programma.Titel, AVG(voortgang.BekekenPercentage)
FROM voortgang
INNER JOIN profiel
  ON profiel.Naam = voortgang.Profielnaam AND profiel.AbonneeNr = voortgang.AbonneeNr
INNER JOIN programma
  ON voortgang.ProgrammaID = programma.ID
INNER JOIN abonnement
  ON abonnement.AbonneeNr = profiel.AbonneeNr
INNER JOIN aflevering
  ON aflevering.ID = programma.ID
INNER JOIN serie
  ON serie.Titel = aflevering.SerieTitel
GROUP BY programma.Titel;

-- PanelQuery 3
SELECT DISTINCT programma.Titel
FROM voortgang
INNER JOIN programma
  ON programma.ID = voortgang.ProgrammaID
INNER JOIN film
  ON programma.ID = film.ID
INNER JOIN profiel
  ON profiel.Naam = voortgang.Profielnaam AND profiel.AbonneeNr = voortgang.AbonneeNr
INNER JOIN abonnement
  ON abonnement.AbonneeNr = profiel.AbonneeNr
WHERE abonnement.AbonneeNr = 4; -- AbonneNr vergangen met variable

-- PanelQuery 4
SELECT programma.Titel
FROM programma
INNER JOIN film
  ON film.ID = programma.ID
WHERE film.Leeftijdsindicatie < 16
  ORDER BY programma.Tijdsduur DESC;

-- PanelQuery 5
SELECT abonnement.Naam
FROM abonnement
INNER JOIN profiel
  ON abonnement.AbonneeNr = profiel.AbonneeNr
GROUP BY abonnement.AbonneeNr
  HAVING COUNT(*) = 1 

-- PanelQuery 6
SELECT COUNT(*)
FROM voortgang
INNER JOIN film
  ON film.ID = voortgang.ProgrammaID
WHERE voortgang.BekekenPercentage = 100 AND film.ID = 5; -- FilmID vervangen met variable
