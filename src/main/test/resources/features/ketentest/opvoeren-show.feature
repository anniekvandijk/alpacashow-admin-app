# language:nl

Functionaliteit: De administratie kan een show en showdetails opvoeren.
  Deze gegevens kunnen geraadpleegd en gewijzigd worden.
  Bij de opvoer worden er controles uitgevoerd op de juistheid van de invoer.

 Scenario: Correcte opvoer show
   Stel ik ben als administratiemedewerker ingelogd
   Als ik met de juiste gegevens een nieuwe show opvoer
   Dan verwacht ik dat de opgevoerde gegevens zichtbaar zijn op het scherm

 Scenario: Niet correcte opvoer show
   Stel ik ben als administratiemedewerker ingelogd
   Als ik met onjuiste gegevens een nieuwe show opvoer
   Dan verwacht ik dat de opgevoerde gegevens niet opgeslagen kunnen worden

 Scenario: Correct wijzigen show
   Stel ik ben als administratiemedewerker ingelogd
   Als ik een opgevoerde show selecteer en correct wijzig
   Dan verwacht ik dat de gewijzige gegevens zichtbaar zijn op het scherm

 Scenario: Niet correct wijzigen show
   Stel ik ben als administratiemedewerker ingelogd
   Als ik een opgevoerde show selecteer en incorrect wijzig
   Dan verwacht ik dat de gewijzige gegevens niet opgeslagen kunnen worden

 Scenario: Verwijderen show
   Stel ik ben als administratiemedewerker ingelogd
   Als ik een opgevoerde show selecteer en verwijder
   Dan verwacht ik dat de show niet meer zichtbaar is op het scherm

