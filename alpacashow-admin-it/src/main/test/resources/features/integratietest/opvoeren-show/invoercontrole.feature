# language:nl

Functionaliteit: medewerker van de administratie wil ik dat de ingevoerde gegevens gecontroleerd worden op juistheid, 
zodat er geen foute gegevens worden berekend en alle nodige gegevens aanwezig zijn.

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


# todo: veldlengte
# todo: automatische correctie datum velden, datumkiezer? > toevoegen aan story?
# todo: onjuiste invoer kan (grotendeels) naar unittesten


