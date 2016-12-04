# language:nl

Functionaliteit: Als er via online inschrijving of inlezen van een lijst dieren worden aangemeld,
  dan worden de klasse van de dieren automatisch bepaald aan de hand van de soort,
  de leeftijdsgroep, het geslacht en de kleur.
  De klasse moet altijd kloppen, dus bij elke wijziging van de kenmerken moet de klasse herbepaald worden.
  De klasse hoort bij een show en wordt daarom apart opgeslagen.
  Bij een haltershow wordt de leeftijdsklasse bepaald aan de hand van de showdatum.
  Bij een fleecshow wordt de klasse bepaald aan de hand van de laatste scheerdatum.
  NB. Nakomelingenklassen kennen klassebepaling (en dus ook geen leeftijdsklasse).

  # TODO Scenario zo opzetten dat er duidelijk andere data worden gebruikt voor de berekeningen

  Scenario: Opvoeren nieuw dier haltershow
    Stel ik wil mij inschrijven voor de haltershow van 16-04-2016
    Als ik via een scherm een dier opvoer met de volgende gegevens
      | label           | waarde      |
      | soort           | huacaya     |
      | geslacht        | man         |
      | kleur           | wit         |
      | geboortedatum   | 15-04-2014  |
      | scheerdatum     | 01-05-2015  |
    Dan verwacht ik dat de klasse HUACAYA ADULT MALE WHITE getoond wordt
    En verwacht ik dat de klassecode 150 getoond wordt

  Scenario: Opvoeren nieuw dier fleeceshow
    Stel ik wil mij inschrijven voor de fleeceshow van 16-04-2016
    Als ik via een scherm een dier opvoer met de volgende gegevens
      | label           | waarde      |
      | soort           | huacaya     |
      | geslacht        | man         |
      | kleur           | wit         |
      | geboortedatum   | 15-04-2014  |
      | scheerdatum     | 01-05-2015  |
    Dan verwacht ik dat de klasse HUACAYA INTERMEDIATE MALE WHITE getoond wordt
    En verwacht ik dat de klassecode 130 getoond wordt

  Scenario: Wijzigen dier haltershow
    Stel ik wil mijn inschrijving wijzigen voor de haltershow van 16-04-2016
    Als  ik via een scherm een dier wijzig met de volgende gegevens
      | label           | waarde      | wijziging   |
      | soort           | huacaya     | suri        |
      | geslacht        | man         |             |
      | kleur           | wit         |             |
      | geboortedatum   | 15-04-2014  |             |
      | scheerdatum     | 01-05-2015  |             |
    Dan verwacht ik dat de klasse is SURI INTERMEDIATE MALE WHITE getoond wordt
    En verwacht ik dat de klassecode 250 getoond wordt

