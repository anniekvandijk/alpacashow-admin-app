# language:nl

Functionaliteit: De administratie kan een show en showdetails opvoeren.
  Deze gegevens kunnen geraadpleegd en gewijzigd worden.
  Bij de opvoer worden er controles uitgevoerd op de juistheid van de invoer

  # todo: veldlengte
  # todo: automatische correctie datum velden, datumkiezer? > toevoegen aan story?
  # todo: onjuiste invoer kan (grotendeels) naar unittesten
  # todo: Datepicker om foute invoer te voorkomen.

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

  Scenario: Navigeren naar scherm voor opvoeren nieuwe show
    Stel ik ben als administratiemedewerker op het scherm 'showgegevens'
    Als ik op de knop 'nieuwe show opvoeren' klik
    Dan verwacht ik dat ik in het scherm 'opvoeren showgegevens' kom

  Scenario: invoer gegevens
    Stel ik ben als administratiemedewerker op het scherm 'opvoeren showgegevens'
    Dan verwacht ik dat ik de volgende gegevens kan opvoeren
      | Naam show                           |
      | Datum show                          |
      | Sluitingsdatum aanmeldingen         |
      | Plaats show                         |
      | Jury                                |
      | Maximum aantal dieren per deelnemer |

  Scenario: melding bij opslaan correcte gegevens
    Stel ik ben als administratiemedewerker op het scherm 'opvoeren showgegevens'
    Als ik alle showgegevens correct invoer
    En ik druk op 'opslaan'
    Dan verwacht ik dat ik terug ga naar het scherm 'showgegevens'
    En verwacht ik op het scherm 'showgegevens' een melding 'showgegevens opgeslagen'

  Scenario: melding bij annuleren
    Stel ik ben als administratiemedewerker op het scherm 'opvoeren showgegevens'
    Als ik alle showgegevens correct invoer
    En ik druk op 'annuleren'
    Dan verwacht ik de melding 'weet u zeker dat u wilt annuleren - ja / nee'

  Scenario: annuleren, nee
    Stel ik ben als administratiemedewerker op het scherm 'opvoeren showgegevens'
    Als ik alle showgegevens correct invoer
    En ik druk op 'annuleren'
    En ik druk bij de melding 'weet u zeker dat u wilt annuleren' op nee
    Dan verwacht ik dat er geen wijzigingen op het scherm zijn

  Scenario: annuleren, ja
    Stel ik ben als administratiemedewerker op het scherm 'opvoeren showgegevens'
    Als ik alle showgegevens correct invoer
    En ik druk op 'annuleren'
    En ik druk bij de melding 'weet u zeker dat u wilt annuleren' op ja
    Dan verwacht ik dat ik terug ga naar het scherm 'showgegevens'
    En verwacht ik op het scherm 'showgegevens' een melding 'showgegevens opvoeren geannuleerd'

        # Controle zowel op het scherm als in de backend (stel dat de implementatie in een interface niet goed is, dan kan de applicatie dit afvangen)

  Abstract Scenario: validatie op verplicht veld
    Stel ik ben als administratiemedewerker op het scherm 'opvoeren showgegevens'
    Als ik in het veld '<Veld>' geen waarde invoer
    Dan verwacht ik de melding 'Het veld '<Veld>' is verplicht
    En is het niet mogelijk om op de 'opslaan' knop te drukken
    Voorbeelden:
      | Veld                        |
      | Naam show                   |
      | Datum show                  |
      | Sluitingsdatum aanmeldingen |
      | Plaats show                 |
      | Jury                        |

  Abstract Scenario: validatie op onjuiste gegevens
    Stel ik ben als administratiemedewerker op het scherm 'opvoeren showgegevens'
    Als ik in het veld '<Veld>' een onjuiste waarde invoer
    Dan verwacht ik de melding 'De invoer in het veld '<Veld>' is niet toegestaan
    En is het niet mogelijk om op de 'opslaan' knop te drukken
    Voorbeelden:
      | Veld                        |
      | Naam show                   |
      | Datum show                  |
      | Sluitingsdatum aanmeldingen |
      | Plaats show                 |
      | Jury                        |



